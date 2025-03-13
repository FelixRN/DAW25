// Comenzando con la estructura para importar/exportar ficheros (Parte 2)

Parte 2: Importar/Exportar en formato tabulado
En el MainController he implementado:

exportData(): Guarda todos los componentes en un archivo TSV (valores separados por tabulaciones) con encabezados, lo que facilita su lectura tanto por humanos como por programas.
importData(): Lee un archivo TSV, salta la primera línea (encabezados) y crea objetos Component con los datos importados. Antes de importar, limpia la base de datos actual.

Parte 3: Selección de componentes para un cliente
Para el identificador único de cliente:

He utilizado UUID para generar identificadores únicos tanto para componentes como para clientes
El método getUserId() en la vista permite al usuario elegir entre:

Usar un ID existente (para clientes que vuelven)
Generar un nuevo ID (acortado a 6 caracteres para mejor usabilidad)


El método addToCart() del controlador maneja toda la lógica para:

Verificar si el cliente ya tiene un carrito
Validar el componente y la cantidad seleccionada
Actualizar el carrito



Parte 4: Ver carrito y finalizar compra
La funcionalidad completa incluye:

viewCart(): Muestra el contenido del carrito para un cliente específico
generateTicket(): Crea un ticket detallado con:

ID del cliente
Fecha y hora
Lista de componentes con cantidad y subtotal
Total final


updateStock(): Actualiza el inventario después de la compra
Confirmación de compra antes de finalizarla

Estructura MVC

Modelo: Interfaces y clases para manejar los datos

Component y ShoppingCart como entidades principales
IModel define las operaciones sobre componentes


Vista: Interfaz para la interacción con el usuario

IMainView y su implementación MainTerminalView
Métodos para mostrar menús, recoger datos y confirmar acciones


Controlador: Coordina el modelo y la vista

MainController como punto central de la aplicación
Maneja el flujo de trabajo y las operaciones principales



Para implementar completamente esta aplicación, necesitarías:

Una implementación concreta del modelo (podría ser en memoria o con base de datos)
Una clase Main para iniciar la aplicación
Completar los métodos de persistencia si deseas guardar los datos a largo plazo
```java
package com.store.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.store.model.IModel;
import com.store.model.entities.Component;
import com.store.model.entities.ShoppingCart;
import com.store.utils.TerminalUtils;
import com.store.view.IMainView;

public class MainController {
    private IModel model;
    private IMainView mainView;
    private Map<String, ShoppingCart> userCarts;
    
    public MainController(IModel model, IMainView mainView) {
        this.model = model;
        this.mainView = mainView;
        this.userCarts = new HashMap<>();
    }
    
    public void run() {
        int option;
        
        do {
            option = mainView.mainMenu();
            switch(option) {
                case 0: // Salir
                    mainView.exit();
                    break;
                    
                case 1: // Listar componentes
                    List<Component> list = model.listComponents();
                    mainView.listComponents(list);
                    break;
                    
                case 2: // Añadir componente
                    Component component = mainView.addComponent();
                    model.addComponent(component);
                    break;
                    
                case 3: // Editar componente
                    List<Component> listForEdit = model.listComponents();
                    mainView.listComponents(listForEdit);

                    String idForEdit = mainView.selectComponentId();
                    Component componentForEdit = model.findComponentById(idForEdit);

                    if (componentForEdit != null) {
                        Component modifiedComponent = mainView.editComponent(componentForEdit);
                        model.updateComponent(idForEdit, modifiedComponent);
                        mainView.showMessage("Componente actualizado correctamente.");
                    } else {
                        mainView.showMessage("No se encontró ningún componente con ese ID.");
                    }
                    break;
                    
                case 4: // Eliminar componente
                    List<Component> listForDelete = model.listComponents();
                    mainView.listComponents(listForDelete);

                    String idToDelete = mainView.selectComponentToDelete();
                    Component componentToDelete = model.findComponentById(idToDelete);

                    if (componentToDelete != null) {
                        if (mainView.confirmDelete()) {
                            model.deleteComponent(idToDelete);
                            mainView.showMessage("Componente eliminado correctamente.");
                        } else {
                            mainView.showMessage("Eliminación cancelada.");
                        }
                    } else {
                        mainView.showMessage("No se encontró ningún componente con ese ID.");
                    }
                    break;
                    
                case 5: // Exportar datos
                    mainView.showMessage("Exportando datos...");
                    List<Component> listForExport = model.listComponents();
                    try {
                        exportData(listForExport);
                        mainView.showMessage("Datos exportados correctamente.");
                    } catch (IOException e) {
                        mainView.showMessage("Error al exportar datos: " + e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                    
                case 6: // Importar datos
                    mainView.showMessage("Importando datos...");
                    try {
                        importData();
                        mainView.showMessage("Datos importados correctamente.");
                    } catch (IOException e) {
                        mainView.showMessage("Error al importar datos: " + e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                    
                case 7: // Añadir al carrito
                    addToCart();
                    break;
                    
                case 8: // Ver carrito
                    viewCart();
                    break;
                    
                default:
                    mainView.showMessage("Opción no válida.");
            }
        } while (option != 0);
    }
    
    // PARTE 2: Importar/Exportar datos en formato tabulado
    public void exportData(List<Component> components) throws IOException {
        File file = new File("components.tsv");
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // Escribir encabezado
            writer.write("ID\tNombre\tDescripción\tPrecio\tStock\n");
            
            // Escribir cada componente
            for (Component component : components) {
                writer.write(component.getId() + "\t" +
                             component.getName() + "\t" +
                             component.getDescription() + "\t" +
                             component.getPrice() + "\t" +
                             component.getStock() + "\n");
            }
        }
        
        mainView.showMessage("Datos exportados a: " + file.getAbsolutePath());
    }
    
    public void importData() throws IOException {
        File file = new File("components.tsv");
        
        if (!file.exists()) {
            mainView.showMessage("El archivo no existe: " + file.getAbsolutePath());
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isFirstLine = true;
            
            // Limpiar los componentes existentes
            model.clearComponents();
            
            while ((line = reader.readLine()) != null) {
                // Saltar la primera línea (encabezado)
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                
                String[] parts = line.split("\t");
                if (parts.length >= 5) {
                    Component component = new Component(
                        parts[0].trim(),                    // ID
                        parts[1].trim(),                    // Nombre
                        parts[2].trim(),                    // Descripción
                        Double.parseDouble(parts[3].trim()), // Precio
                        Integer.parseInt(parts[4].trim())   // Stock
                    );
                    model.addComponent(component);
                } else {
                    mainView.showMessage("Línea con formato incorrecto: " + line);
                }
            }
        }
    }
    
    // PARTE 3: Seleccionar componentes para un cliente
    private void addToCart() {
        // Mostrar componentes disponibles
        List<Component> availableComponents = model.listComponents();
        mainView.listComponents(availableComponents);
        
        // Pedir ID de cliente o crear uno nuevo
        String userId = mainView.getUserId();
        
        // Si no existe este usuario, crear un carrito nuevo
        if (!userCarts.containsKey(userId)) {
            userCarts.put(userId, new ShoppingCart(userId));
            mainView.showMessage("Nuevo cliente registrado con ID: " + userId);
        }
        
        // Seleccionar componente
        String componentId = mainView.selectComponentId();
        Component selectedComponent = model.findComponentById(componentId);
        
        if (selectedComponent == null) {
            mainView.showMessage("No se encontró ningún componente con ese ID.");
            return;
        }
        
        // Pedir cantidad
        int quantity = mainView.getQuantity(selectedComponent.getStock());
        
        if (quantity <= 0 || quantity > selectedComponent.getStock()) {
            mainView.showMessage("Cantidad inválida o insuficiente stock.");
            return;
        }
        
        // Añadir al carrito
        ShoppingCart cart = userCarts.get(userId);
        cart.addItem(selectedComponent, quantity);
        
        mainView.showMessage("Añadido al carrito: " + selectedComponent.getName() 
                             + " x" + quantity);
    }
    
    // PARTE 4: Ver carrito y finalizar compra
    private void viewCart() {
        // Pedir ID de usuario
        String userId = mainView.getUserId();
        
        // Verificar si el usuario tiene un carrito
        if (!userCarts.containsKey(userId)) {
            mainView.showMessage("No hay ningún carrito para este usuario.");
            return;
        }
        
        // Mostrar el carrito
        ShoppingCart cart = userCarts.get(userId);
        mainView.showCart(cart);
        
        // Preguntar si desea finalizar la compra
        if (mainView.confirmPurchase()) {
            // Generar ticket
            String ticket = generateTicket(cart);
            mainView.showTicket(ticket);
            
            // Actualizar stock
            updateStock(cart);
            
            // Eliminar carrito
            userCarts.remove(userId);
            mainView.showMessage("Compra finalizada. ¡Gracias por su compra!");
        }
    }
    
    private String generateTicket(ShoppingCart cart) {
        StringBuilder ticket = new StringBuilder();
        
        ticket.append("=== TICKET DE COMPRA ===\n");
        ticket.append("Cliente ID: ").append(cart.getUserId()).append("\n");
        ticket.append("Fecha: ").append(java.time.LocalDateTime.now()).append("\n");
        ticket.append("------------------------\n");
        
        double total = 0;
        
        for (Map.Entry<Component, Integer> entry : cart.getItems().entrySet()) {
            Component component = entry.getKey();
            int quantity = entry.getValue();
            double subtotal = component.getPrice() * quantity;
            
            ticket.append(component.getName())
                  .append(" x").append(quantity)
                  .append(" = ").append(String.format("%.2f€", subtotal))
                  .append("\n");
            
            total += subtotal;
        }
        
        ticket.append("------------------------\n");
        ticket.append("TOTAL: ").append(String.format("%.2f€", total)).append("\n");
        ticket.append("=========================\n");
        
        return ticket.toString();
    }
    
    private void updateStock(ShoppingCart cart) {
        for (Map.Entry<Component, Integer> entry : cart.getItems().entrySet()) {
            Component component = entry.getKey();
            int quantity = entry.getValue();
            
            // Actualizar el stock
            int newStock = component.getStock() - quantity;
            component.setStock(newStock);
            
            // Actualizar en el modelo
            model.updateComponent(component.getId(), component);
        }
    }
}

// Entidades del modelo
package com.store.model.entities;

public class Component {
    private String id;
    private String name;
    private String description;
    private double price;
    private int stock;
    
    public Component(String id, String name, String description, double price, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }
    
    // Constructor alternativo que genera un ID único automáticamente
    public Component(String name, String description, double price, int stock) {
        this.id = generateUniqueId();
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }
    
    private String generateUniqueId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
    
    // Getters y setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getStock() {
        return stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + name + " | Precio: " + price + "€ | Stock: " + stock;
    }
}

package com.store.model.entities;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private String userId;
    private Map<Component, Integer> items;
    
    public ShoppingCart(String userId) {
        this.userId = userId;
        this.items = new HashMap<>();
    }
    
    public void addItem(Component component, int quantity) {
        // Si ya existe, aumentar la cantidad
        if (items.containsKey(component)) {
            items.put(component, items.get(component) + quantity);
        } else {
            items.put(component, quantity);
        }
    }
    
    public void removeItem(Component component) {
        items.remove(component);
    }
    
    public Map<Component, Integer> getItems() {
        return items;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public double getTotal() {
        double total = 0;
        for (Map.Entry<Component, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}

// Interfaces del modelo
package com.store.model;

import java.util.List;

import com.store.model.entities.Component;

public interface IModel {
    List<Component> listComponents();
    Component addComponent(Component component);
    Component findComponentById(String id);
    void updateComponent(String id, Component component);
    void deleteComponent(String id);
    void clearComponents();
}

// Vista principal
package com.store.view;

import java.util.List;

import com.store.model.entities.Component;
import com.store.model.entities.ShoppingCart;

public interface IMainView {
    int mainMenu();
    void exit();
    void listComponents(List<Component> components);
    Component addComponent();
    Component editComponent(Component component);
    String selectComponentId();
    String selectComponentToDelete();
    boolean confirmDelete();
    void showMessage(String message);
    String getUserId();
    int getQuantity(int maxStock);
    void showCart(ShoppingCart cart);
    boolean confirmPurchase();
    void showTicket(String ticket);
}

// Implementación de la vista
package com.store.view;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.store.model.entities.Component;
import com.store.model.entities.ShoppingCart;
import com.store.utils.TerminalUtils;

public class MainTerminalView implements IMainView {

    @Override
    public int mainMenu() {
        int option;
        
        TerminalUtils.output("===== TIENDA DE COMPONENTES =====");
        TerminalUtils.output("1. Listar componentes");
        TerminalUtils.output("2. Añadir componente");
        TerminalUtils.output("3. Editar componente");
        TerminalUtils.output("4. Eliminar componente");
        TerminalUtils.output("5. Exportar datos");
        TerminalUtils.output("6. Importar datos");
        TerminalUtils.output("7. Añadir al carrito");
        TerminalUtils.output("8. Ver carrito");
        TerminalUtils.output("0. Salir");
        TerminalUtils.output("Seleccione una opción: ");
        
        try {
            option = Integer.parseInt(TerminalUtils.input());
        } catch (NumberFormatException e) {
            option = -1;
        }
        
        return option;
    }

    @Override
    public void exit() {
        TerminalUtils.output("¡Hasta pronto!");
    }

    @Override
    public void listComponents(List<Component> components) {
        TerminalUtils.output("===== LISTADO DE COMPONENTES =====");
        
        if (components.isEmpty()) {
            TerminalUtils.output("No hay componentes disponibles.");
            return;
        }
        
        for (Component component : components) {
            TerminalUtils.output(component.toString());
        }
    }

    @Override
    public Component addComponent() {
        TerminalUtils.output("===== AÑADIR COMPONENTE =====");
        
        TerminalUtils.output("Nombre: ");
        String name = TerminalUtils.input();
        
        TerminalUtils.output("Descripción: ");
        String description = TerminalUtils.input();
        
        double price = 0;
        do {
            TerminalUtils.output("Precio (€): ");
            try {
                price = Double.parseDouble(TerminalUtils.input());
                if (price <= 0) {
                    TerminalUtils.output("El precio debe ser mayor que 0.");
                }
            } catch (NumberFormatException e) {
                TerminalUtils.output("Por favor, introduzca un número válido.");
                price = 0;
            }
        } while (price <= 0);
        
        int stock = 0;
        do {
            TerminalUtils.output("Stock: ");
            try {
                stock = Integer.parseInt(TerminalUtils.input());
                if (stock < 0) {
                    TerminalUtils.output("El stock no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                TerminalUtils.output("Por favor, introduzca un número válido.");
                stock = -1;
            }
        } while (stock < 0);
        
        // Crear componente con ID generado automáticamente
        return new Component(name, description, price, stock);
    }

    @Override
    public Component editComponent(Component component) {
        TerminalUtils.output("===== EDITAR COMPONENTE =====");
        TerminalUtils.output("(Deje en blanco para mantener el valor actual)");
        
        TerminalUtils.output("Nombre actual: " + component.getName());
        TerminalUtils.output("Nuevo nombre: ");
        String name = TerminalUtils.input();
        if (!name.trim().isEmpty()) {
            component.setName(name);
        }
        
        TerminalUtils.output("Descripción actual: " + component.getDescription());
        TerminalUtils.output("Nueva descripción: ");
        String description = TerminalUtils.input();
        if (!description.trim().isEmpty()) {
            component.setDescription(description);
        }
        
        TerminalUtils.output("Precio actual: " + component.getPrice() + "€");
        TerminalUtils.output("Nuevo precio: ");
        String priceStr = TerminalUtils.input();
        if (!priceStr.trim().isEmpty()) {
            try {
                double price = Double.parseDouble(priceStr);
                if (price > 0) {
                    component.setPrice(price);
                } else {
                    TerminalUtils.output("El precio debe ser mayor que 0. Se mantiene el valor actual.");
                }
            } catch (NumberFormatException e) {
                TerminalUtils.output("Formato de precio inválido. Se mantiene el valor actual.");
            }
        }
        
        TerminalUtils.output("Stock actual: " + component.getStock());
        TerminalUtils.output("Nuevo stock: ");
        String stockStr = TerminalUtils.input();
        if (!stockStr.trim().isEmpty()) {
            try {
                int stock = Integer.parseInt(stockStr);
                if (stock >= 0) {
                    component.setStock(stock);
                } else {
                    TerminalUtils.output("El stock no puede ser negativo. Se mantiene el valor actual.");
                }
            } catch (NumberFormatException e) {
                TerminalUtils.output("Formato de stock inválido. Se mantiene el valor actual.");
            }
        }
        
        return component;
    }

    @Override
    public String selectComponentId() {
        TerminalUtils.output("Introduzca el ID del componente: ");
        return TerminalUtils.input();
    }

    @Override
    public String selectComponentToDelete() {
        TerminalUtils.output("Introduzca el ID del componente a eliminar: ");
        return TerminalUtils.input();
    }

    @Override
    public boolean confirmDelete() {
        TerminalUtils.output("¿Está seguro de que desea eliminar este componente? (s/n): ");
        String response = TerminalUtils.input();
        return response.equalsIgnoreCase("s");
    }

    @Override
    public void showMessage(String message) {
        TerminalUtils.output(message);
    }

    @Override
    public String getUserId() {
        TerminalUtils.output("===== IDENTIFICACIÓN DE CLIENTE =====");
        TerminalUtils.output("1. Usar un ID existente");
        TerminalUtils.output("2. Crear un ID nuevo");
        TerminalUtils.output("Seleccione una opción: ");
        
        int option;
        try {
            option = Integer.parseInt(TerminalUtils.input());
        } catch (NumberFormatException e) {
            option = 0;
        }
        
        if (option == 1) {
            TerminalUtils.output("Introduzca su ID de cliente: ");
            return TerminalUtils.input();
        } else if (option == 2) {
            // Generar un ID único para el cliente
            String newId = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
            TerminalUtils.output("Su nuevo ID de cliente es: " + newId);
            return newId;
        } else {
            TerminalUtils.output("Opción no válida. Generando ID nuevo.");
            String newId = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
            TerminalUtils.output("Su nuevo ID de cliente es: " + newId);
            return newId;
        }
    }

    @Override
    public int getQuantity(int maxStock) {
        int quantity = 0;
        do {
            TerminalUtils.output("Introduzca la cantidad (máximo disponible: " + maxStock + "): ");
            try {
                quantity = Integer.parseInt(TerminalUtils.input());
                if (quantity <= 0) {
                    TerminalUtils.output("La cantidad debe ser mayor que 0.");
                } else if (quantity > maxStock) {
                    TerminalUtils.output("No hay suficiente stock disponible.");
                }
            } catch (NumberFormatException e) {
                TerminalUtils.output("Por favor, introduzca un número válido.");
                quantity = 0;
            }
        } while (quantity <= 0 || quantity > maxStock);
        
        return quantity;
    }

    @Override
    public void showCart(ShoppingCart cart) {
        TerminalUtils.output("===== CARRITO DE COMPRA =====");
        TerminalUtils.output("Cliente ID: " + cart.getUserId());
        
        Map<Component, Integer> items = cart.getItems();
        
        if (items.isEmpty()) {
            TerminalUtils.output("El carrito está vacío.");
            return;
        }
        
        double total = 0;
        
        for (Map.Entry<Component, Integer> entry : items.entrySet()) {
            Component component = entry.getKey();
            int quantity = entry.getValue();
            double subtotal = component.getPrice() * quantity;
            
            TerminalUtils.output(component.getName() + 
                              " x" + quantity + 
                              " = " + String.format("%.2f€", subtotal));
            
            total += subtotal;
        }
        
        TerminalUtils.output("---------------------------");
        TerminalUtils.output("TOTAL: " + String.format("%.2f€", total));
    }

    @Override
    public boolean confirmPurchase() {
        TerminalUtils.output("¿Desea finalizar la compra? (s/n): ");
        String response = TerminalUtils.input();
        return response.equalsIgnoreCase("s");
    }

    @Override
    public void showTicket(String ticket) {
        TerminalUtils.output(ticket);
    }
}

// Utilidades para entrada/salida en terminal
package com.store.utils;

import java.util.Scanner;

public class TerminalUtils {
    private static Scanner scanner = new Scanner(System.in);
    
    public static String input() {
        return scanner.nextLine();
    }
    
    public static void output(String text) {
        System.out.println(text);
    }
}
```
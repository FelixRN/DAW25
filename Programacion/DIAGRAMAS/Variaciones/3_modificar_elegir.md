
# Modificaciones para implementar el flujo de gestión de inventario

## 1. Modificar `MainController.java`

```java
package controller;

import java.util.List;

import controller.model.IModel;
import controller.model.ModelMemory;
import controller.model.entities.Car;
import controller.view.IMainView;
import controller.view.MainTerminalView;

public class MainController {
    private IModel model;
    private IMainView mainView;
    
    public MainController() {
        this.model = new ModelMemory();
        this.mainView = new MainTerminalView();
    }
    
    public void run() {
        // Primero gestionar el inventario
        manageInventory();
        
        // Una vez confirmado el inventario, mostrar coches al cliente
        if (mainView.confirmInventory()) {
            showCarsToCustomer();
        } else {
            mainView.showMessage("Proceso cancelado por el usuario.");
        }
    }
    
    private void manageInventory() {
        int option;
        
        mainView.showMessage("MODO ADMINISTRADOR: Gestión de inventario");
        
        do {
            option = mainView.inventoryMenu();
            switch(option) {
                case 0: // Finalizar gestión de inventario
                    mainView.showMessage("Finalizando gestión de inventario...");
                    break;
                    
                case 1: // Listar coches
                    List<Car> list = model.list();
                    mainView.list(list);
                    break;
                    
                case 2: // Añadir coche
                    Car car = mainView.add();
                    model.add(car);
                    break;
                    
                case 3: // Editar coche
                    List<Car> listForEdit = model.list();
                    mainView.list(listForEdit);

                    String plateForEdit = mainView.selectPlateCar();
                    Car carForEdit = model.findByPlate(plateForEdit);

                    if (carForEdit != null) {
                        Car modifiedCar = mainView.editCar(carForEdit);
                        model.updateCar(plateForEdit, modifiedCar);
                    } else {
                        mainView.showMessage("No se encontró ningún coche con esa matrícula.");
                    }
                    break;
                    
                case 4: // Eliminar coche
                    List<Car> listForDelete = model.list();
                    mainView.list(listForDelete); 

                    String plateToDelete = mainView.selectCarToDelete();
                    Car carToDelete = model.findByPlate(plateToDelete);

                    if (carToDelete != null) { 
                        if (mainView.confirmDelete()) { 
                            model.delete(plateToDelete);
                            mainView.showMessage("Coche eliminado correctamente.");
                        } else {
                            mainView.showMessage("Eliminación cancelada.");
                        }
                    } else {
                        mainView.showMessage("No se encontró ningún coche con esa matrícula.");
                    }
                    break;
                    
                default:
                    mainView.showMessage("Opción no válida.");
            }
        } while (option != 0);
    }
    
    private void showCarsToCustomer() {
        int option;
        
        mainView.showMessage("MODO CLIENTE: Selección de vehículo");
        
        do {
            option = mainView.customerMenu();
            switch(option) {
                case 0: // Salir
                    mainView.exit();
                    break;
                    
                case 1: // Ver todos los coches
                    List<Car> list = model.list();
                    mainView.list(list);
                    break;
                    
                case 2: // Seleccionar un coche
                    List<Car> availableCars = model.list();
                    mainView.list(availableCars);
                    
                    if (!availableCars.isEmpty()) {
                        String selectedPlate = mainView.selectPlateCar();
                        Car selectedCar = model.findByPlate(selectedPlate);
                        
                        if (selectedCar != null) {
                            mainView.showCarDetails(selectedCar);
                            if (mainView.confirmPurchase()) {
                                mainView.completePurchase(selectedCar);
                            }
                        } else {
                            mainView.showMessage("No se encontró ningún coche con esa matrícula.");
                        }
                    } else {
                        mainView.showMessage("No hay coches disponibles.");
                    }
                    break;
                    
                default:
                    mainView.showMessage("Opción no válida.");
            }
        } while (option != 0);
    }
}
```

## 2. Modificar `IMainView.java`

```java
package controller.view;

import java.util.List;

import controller.model.entities.Car;

public interface IMainView {
    // Menús
    int inventoryMenu();  // Nuevo método para el menú de gestión de inventario
    int customerMenu();   // Nuevo método para el menú de clientes
    
    // Métodos existentes
    void exit();
    void list(List<Car> list);
    Car add();
    String selectPlateCar();
    Car editCar(Car carForEdit);
    String getText();
    void showMessage(String message);
    String selectCarToDelete();
    boolean confirmDelete();
    
    // Nuevos métodos
    boolean confirmInventory();  // Confirmar si el inventario está listo
    void showCarDetails(Car car);  // Mostrar detalles de un coche
    boolean confirmPurchase();   // Confirmar la compra
    void completePurchase(Car car);  // Completar la compra
}
```

## 3. Modificar `MainTerminalView.java`

```java
package controller.view;

import java.util.List;

import controller.model.entities.Car;
import controller.utils.TerminalUtils;

public class MainTerminalView implements IMainView {

    @Override
    public int inventoryMenu() {
        int option;
        
        TerminalUtils.output("\n===== GESTIÓN DE INVENTARIO =====");
        TerminalUtils.output("1.- Listar coches disponibles");
        TerminalUtils.output("2.- Añadir coche");
        TerminalUtils.output("3.- Editar coche");
        TerminalUtils.output("4.- Eliminar coche");
        TerminalUtils.output("0.- Finalizar gestión de inventario");
        TerminalUtils.output("Seleccione una opción: ");
        
        try {
            option = TerminalUtils.inputInt();
        } catch (Exception e) {
            option = -1;
        }
        
        return option;
    }
    
    @Override
    public int customerMenu() {
        int option;
        
        TerminalUtils.output("\n===== CONCESIONARIO DE COCHES =====");
        TerminalUtils.output("1.- Ver todos los coches disponibles");
        TerminalUtils.output("2.- Seleccionar un coche");
        TerminalUtils.output("0.- Salir");
        TerminalUtils.output("Seleccione una opción: ");
        
        try {
            option = TerminalUtils.inputInt();
        } catch (Exception e) {
            option = -1;
        }
        
        return option;
    }

    @Override
    public void exit() {
        TerminalUtils.output("Gracias por su visita. ¡Hasta pronto!");
    }

    @Override
    public void list(List<Car> list) {
        if (list.isEmpty()) {
            TerminalUtils.output("No hay coches disponibles.");
            return;
        }
        
        TerminalUtils.output("\n=== LISTA DE COCHES DISPONIBLES ===");
        TerminalUtils.output("MATRÍCULA - MODELO");
        
        for(Car car : list) {
            TerminalUtils.output(car.toString());
        }
        
        TerminalUtils.output("Total de coches: " + list.size());
    }
    
    @Override
    public Car add() {
        TerminalUtils.output("\n=== AÑADIR NUEVO COCHE ===");
        TerminalUtils.output("Introduzca la matrícula:");
        String plate = TerminalUtils.inputText();

        TerminalUtils.output("Introduzca el modelo:");
        String model = TerminalUtils.inputText();
        
        Car car = new Car(plate, model);
        TerminalUtils.output("Coche añadido correctamente.");
        return car;
    }
    
    @Override
    public void showMessage(String message) {
        TerminalUtils.output(message);
    }
    
    @Override
    public String selectPlateCar() {
        TerminalUtils.output("Introduzca la matrícula del coche:");
        String plate = TerminalUtils.inputText();
        return plate;
    }

    @Override
    public Car editCar(Car carForEdit) {
        TerminalUtils.output("\n=== EDITAR COCHE ===");
        TerminalUtils.output("Editando coche: " + carForEdit.toString());

        TerminalUtils.output("Introduzca la nueva matrícula (deje vacío para mantener la actual):");
        String plate = TerminalUtils.inputText();
        if(isValidString(plate)) {
            carForEdit.setPlate(plate);
        }

        TerminalUtils.output("Introduzca el nuevo modelo (deje vacío para mantener el actual):");
        String model = TerminalUtils.inputText();
        if(isValidString(model)) {
            carForEdit.setModel(model);
        }
        
        TerminalUtils.output("Coche actualizado correctamente.");
        return carForEdit;
    }
    
    public boolean isValidString(String value) {
        return value != null && !value.isEmpty() && !value.isBlank();
    }
    
    @Override
    public String selectCarToDelete() {
        TerminalUtils.output("Introduzca la matrícula del coche que desea eliminar:");
        return TerminalUtils.inputText();
    }
    
    @Override
    public boolean confirmDelete() {
        TerminalUtils.output("¿Está seguro de que desea eliminar este coche? (s/n):");
        String respuesta = TerminalUtils.inputText();
        return respuesta.equalsIgnoreCase("s");
    }
    
    @Override
    public String getText() {
        return TerminalUtils.inputText();
    }
    
    @Override
    public boolean confirmInventory() {
        TerminalUtils.output("\n=== CONFIRMACIÓN DE INVENTARIO ===");
        TerminalUtils.output("¿El inventario está completo y listo para mostrar a los clientes? (s/n):");
        String respuesta = TerminalUtils.inputText();
        return respuesta.equalsIgnoreCase("s");
    }
    
    @Override
    public void showCarDetails(Car car) {
        TerminalUtils.output("\n=== DETALLES DEL COCHE SELECCIONADO ===");
        TerminalUtils.output("Matrícula: " + car.getPlate());
        TerminalUtils.output("Modelo: " + car.getModel());
        // Aquí podrías añadir más detalles si la clase Car tuviera más atributos
    }
    
    @Override
    public boolean confirmPurchase() {
        TerminalUtils.output("¿Desea adquirir este vehículo? (s/n):");
        String respuesta = TerminalUtils.inputText();
        return respuesta.equalsIgnoreCase("s");
    }
    
    @Override
    public void completePurchase(Car car) {
        TerminalUtils.output("\n=== ¡FELICIDADES! ===");
        TerminalUtils.output("Ha adquirido el vehículo: " + car.toString());
        TerminalUtils.output("Nuestro equipo se pondrá en contacto con usted para finalizar el trámite.");
        TerminalUtils.output("Gracias por confiar en nosotros.");
    }
}
```

## 4. Modificar `ModelMemory.java` para incluir algunos coches predefinidos

```java
package controller.model;

import java.util.ArrayList;
import java.util.List;

import controller.model.entities.Car;

public class ModelMemory implements IModel {

    private List<Car> list;
    
    public ModelMemory() {
        list = new ArrayList<>();
        // Podemos inicializar con algunos coches para no empezar con lista vacía
        list.add(new Car("1234ABC", "Toyota Corolla"));
        list.add(new Car("5678DEF", "Honda Civic"));
        list.add(new Car("9012GHI", "Ford Focus"));
    }
    
    // El resto del código permanece igual
    @Override
    public List<Car> list() {
        return list;
    }

    @Override
    public void add(Car car) {
        list.add(car);
    }

    @Override
    public Car findByPlate(String plateForEdit) {
        Car car = null;
        
        for(Car i : list) {
            if(i.getPlate().equals(plateForEdit)) {
                car = i.clone();
            }
        }
        
        return car;
    }
    
    @Override
    public void updateCar(String plate, Car modifiedCar) {
        for (int i = 0; i < list.size(); i++) {
            Car car = list.get(i);
            if (car.getPlate().equals(plate)) {
                list.set(i, modifiedCar);
                break;
            }
        }
    }

    @Override
    public void editCar(String plateForEdit, Car modifiedCar) {
        // Este método puede quedarse vacío ya que usamos updateCar
    }

    @Override
    public void delete(String plate) {
        list.removeIf(car -> car.getPlate().equals(plate));
    }
}
```

## 5. Modificar `Car.java` para añadir métodos getter/setter faltantes

```java
package controller.model.entities;

public class Car {
    private String plate;
    private String model;
    
    public Car(String plate, String model) {
        this.plate = plate;
        this.model = model;
    }

    @Override
    public String toString() {
        return this.plate + " - " + this.model;
    }
    
    @Override
    public Car clone() {
        return new Car(this.plate, this.model);
    }

    public String getPlate() {
        return this.plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getModel() {
        return this.model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
}
```

## Flujo del programa modificado

1. **Fase de gestión de inventario (Modo Administrador)**:
   - Al iniciar, el programa entra en modo de gestión de inventario
   - El administrador puede listar, añadir, editar o eliminar coches
   - El administrador finaliza la gestión cuando está satisfecho con el inventario

2. **Confirmación del inventario**:
   - Se pregunta si el inventario está listo para mostrar a los clientes
   - Si no está listo, el programa termina
   - Si está listo, se pasa al modo cliente

3. **Fase de selección de coches (Modo Cliente)**:
   - El cliente puede ver la lista de coches disponibles
   - El cliente puede seleccionar un coche para ver sus detalles
   - El cliente puede confirmar la compra de un coche
   - Se muestra un mensaje de confirmación de compra

Este flujo implementa exactamente lo que has solicitado: primero se realizan las modificaciones al inventario y luego, una vez confirmado, se le permite al cliente elegir un coche del inventario finalizado.
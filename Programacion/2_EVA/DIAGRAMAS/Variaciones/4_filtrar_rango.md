# Modificaciones para añadir año de creación y filtrar por rango

## 1. Modificar `Car.java` para añadir el año de creación

```java
package controller.model.entities;

public class Car {
    private String plate;
    private String model;
    private int year; // Nuevo atributo para el año de creación
    
    public Car(String plate, String model, int year) {
        this.plate = plate;
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.plate + " - " + this.model + " (" + this.year + ")";
    }
    
    @Override
    public Car clone() {
        return new Car(this.plate, this.model, this.year);
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
    
    public int getYear() {
        return this.year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
}
```

## 2. Modificar `ModelMemory.java` para incluir años y el método de filtrado por rango

```java
package controller.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controller.model.entities.Car;

public class ModelMemory implements IModel {

    private List<Car> list;
    private Random random = new Random();
    
    public ModelMemory() {
        list = new ArrayList<>();
        
        // Añadir algunos coches predefinidos con años aleatorios entre 1950 y 2000
        list.add(new Car("1234ABC", "Toyota Corolla", getRandomYear()));
        list.add(new Car("5678DEF", "Honda Civic", getRandomYear()));
        list.add(new Car("9012GHI", "Ford Focus", getRandomYear()));
        list.add(new Car("3456JKL", "Volkswagen Golf", getRandomYear()));
        list.add(new Car("7890MNO", "Chevrolet Impala", getRandomYear()));
        list.add(new Car("1357PQR", "Dodge Charger", getRandomYear()));
        list.add(new Car("2468STU", "Fiat 500", getRandomYear()));
        list.add(new Car("9876VWX", "Mercedes Benz 300", getRandomYear()));
    }
    
    // Método para generar un año aleatorio entre 1950 y 2000
    private int getRandomYear() {
        return random.nextInt(51) + 1950; // 0-50 + 1950 = 1950-2000
    }
    
    @Override
    public List<Car> list() {
        return list;
    }
    
    @Override
    public List<Car> listByYearRange(int startYear, int endYear) {
        List<Car> filteredList = new ArrayList<>();
        
        for (Car car : list) {
            if (car.getYear() >= startYear && car.getYear() <= endYear) {
                filteredList.add(car);
            }
        }
        
        return filteredList;
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
        // Este método puede quedarse vacío ya que updateCar realiza esta función
    }

    @Override
    public void delete(String plate) {
        list.removeIf(car -> car.getPlate().equals(plate));
    }
}
```

## 3. Modificar `IModel.java` para añadir el método de filtrado

```java
package controller.model;

import java.util.List;

import controller.model.entities.Car;

public interface IModel {
    List<Car> list();
    
    // Nuevo método para filtrar coches por rango de años
    List<Car> listByYearRange(int startYear, int endYear);

    void add(Car car);

    Car findByPlate(String plateForEdit);

    void updateCar(String plate, Car modifiedCar);

    void editCar(String plateForEdit, Car modifiedCar);

    void delete(String plate);
}
```

## 4. Modificar `IMainView.java` para añadir los métodos necesarios

```java
package controller.view;

import java.util.List;

import controller.model.entities.Car;

public interface IMainView {
    int mainMenu();
    
    // Nuevo método para obtener el rango de años a filtrar
    int[] getYearRange();

    void exit();

    void list(List<Car> list);

    Car add();

    void edit();

    void delete();

    String selectPlateCar();

    Car editCar(Car carForEdit);

    String getText();
    
    void showMessage(String message);

    String selectCarToDelete();
    
    boolean confirmDelete();
}
```

## 5. Modificar `MainTerminalView.java` para implementar los nuevos métodos

```java
package controller.view;

import java.util.List;

import controller.model.entities.Car;
import controller.utils.TerminalUtils;

public class MainTerminalView implements IMainView {

    @Override
    public int mainMenu() {
        int option;
        
        TerminalUtils.output("\n===== CONCESIONARIO DE COCHES CLÁSICOS =====");
        TerminalUtils.output("1.- Listar todos los coches");
        TerminalUtils.output("2.- Filtrar coches por rango de años");
        TerminalUtils.output("3.- Añadir coche");
        TerminalUtils.output("4.- Editar coche");
        TerminalUtils.output("5.- Eliminar coche");
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
    public int[] getYearRange() {
        int[] range = new int[2];
        
        TerminalUtils.output("\n===== FILTRAR POR RANGO DE AÑOS =====");
        
        try {
            TerminalUtils.output("Ingrese el año inicial (1950-2000): ");
            range[0] = TerminalUtils.inputInt();
            
            TerminalUtils.output("Ingrese el año final (1950-2000): ");
            range[1] = TerminalUtils.inputInt();
            
            // Validar que los años estén dentro del rango permitido
            if (range[0] < 1950) range[0] = 1950;
            if (range[0] > 2000) range[0] = 2000;
            if (range[1] < 1950) range[1] = 1950;
            if (range[1] > 2000) range[1] = 2000;
            
            // Asegurar que el rango sea correcto (inicio <= fin)
            if (range[0] > range[1]) {
                int temp = range[0];
                range[0] = range[1];
                range[1] = temp;
            }
        } catch (Exception e) {
            TerminalUtils.output("Error en el formato. Usando rango predeterminado (1950-2000).");
            range[0] = 1950;
            range[1] = 2000;
        }
        
        return range;
    }

    @Override
    public void exit() {
        TerminalUtils.output("\nGracias por visitar nuestro concesionario de coches clásicos. ¡Hasta pronto!");
    }

    @Override
    public void list(List<Car> list) {
        if (list.isEmpty()) {
            TerminalUtils.output("\nNo hay coches que coincidan con los criterios.");
            return;
        }
        
        TerminalUtils.output("\n===== LISTA DE COCHES =====");
        TerminalUtils.output("MATRÍCULA - MODELO (AÑO)");
        TerminalUtils.output("------------------------");
        
        for(Car car : list) {
            TerminalUtils.output(car.toString());
        }
        
        TerminalUtils.output("------------------------");
        TerminalUtils.output("Total: " + list.size() + " coches");
    }
    
    @Override
    public Car add() {
        TerminalUtils.output("\n===== AÑADIR NUEVO COCHE =====");
        
        TerminalUtils.output("Introduzca la matrícula:");
        String plate = TerminalUtils.inputText();

        TerminalUtils.output("Introduzca el modelo:");
        String model = TerminalUtils.inputText();
        
        int year = 1950;
        try {
            TerminalUtils.output("Introduzca el año (1950-2000):");
            year = TerminalUtils.inputInt();
            
            // Validar que el año esté dentro del rango permitido
            if (year < 1950 || year > 2000) {
                TerminalUtils.output("Año fuera de rango. Se establecerá a un valor predeterminado.");
                year = 1950;
            }
        } catch (Exception e) {
            TerminalUtils.output("Error en el formato. Se establecerá el año a 1950.");
        }
        
        Car car = new Car(plate, model, year);
        return car;
    }
    
    @Override
    public void showMessage(String message) {
        TerminalUtils.output(message);
    }

    @Override
    public void edit() {
        // No se utiliza directamente
    }
    
    @Override
    public String selectPlateCar() {
        TerminalUtils.output("Introduzca la matrícula del coche:");
        String plate = TerminalUtils.inputText();
        return plate;
    }

    @Override
    public Car editCar(Car carForEdit) {
        TerminalUtils.output("\n===== EDITAR COCHE =====");
        TerminalUtils.output("Coche actual: " + carForEdit.toString());

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
        
        TerminalUtils.output("Introduzca el nuevo año (0 para mantener el actual):");
        try {
            int year = TerminalUtils.inputInt();
            if (year != 0) {
                if (year >= 1950 && year <= 2000) {
                    carForEdit.setYear(year);
                } else {
                    TerminalUtils.output("Año fuera de rango (1950-2000). No se modificará.");
                }
            }
        } catch (Exception e) {
            TerminalUtils.output("Formato de año inválido. No se modificará.");
        }
        
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
    public void delete() {
        // No se utiliza directamente
    }
}
```

## 6. Modificar `MainController.java` para implementar el filtrado por rango de años

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
        int option;
        
        do {
            option = mainView.mainMenu();
            switch(option) {
                case 0: // Salir
                    mainView.exit();
                    break;
                    
                case 1: // Listar todos los coches
                    List<Car> listAll = model.list();
                    mainView.list(listAll);
                    break;
                    
                case 2: // Filtrar coches por rango de años
                    int[] yearRange = mainView.getYearRange();
                    List<Car> filteredList = model.listByYearRange(yearRange[0], yearRange[1]);
                    
                    mainView.showMessage("\nCoches entre " + yearRange[0] + " y " + yearRange[1] + ":");
                    mainView.list(filteredList);
                    break;
                    
                case 3: // Añadir coche
                    Car car = mainView.add();
                    model.add(car);
                    mainView.showMessage("Coche añadido correctamente.");
                    break;
                    
                case 4: // Editar coche
                    List<Car> listForEdit = model.list();
                    mainView.list(listForEdit);

                    String plateForEdit = mainView.selectPlateCar();
                    Car carForEdit = model.findByPlate(plateForEdit);

                    if (carForEdit != null) {
                        Car modifiedCar = mainView.editCar(carForEdit);
                        model.updateCar(plateForEdit, modifiedCar);
                        mainView.showMessage("Coche actualizado correctamente.");
                    } else {
                        mainView.showMessage("No se encontró ningún coche con esa matrícula.");
                    }
                    break;
                    
                case 5: // Eliminar coche
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
                    mainView.showMessage("Opción no válida. Intente de nuevo.");
            }
        } while (option != 0);
    }
}
```

## Resumen de cambios

1. **Clase `Car`**:
   - Añadido atributo `year` para almacenar el año de creación
   - Añadidos métodos getter y setter para el año
   - Modificado el método `toString()` para incluir el año
   - Actualizado el método `clone()` para incluir el año

2. **Interfaz `IModel`**:
   - Añadido nuevo método `listByYearRange(int startYear, int endYear)` para filtrar coches por rango de años

3. **Clase `ModelMemory`**:
   - Implementado el método `listByYearRange`
   - Añadido método auxiliar `getRandomYear()` para generar años aleatorios entre 1950 y 2000
   - Inicializado con coches predefinidos que tienen años aleatorios

4. **Interfaz `IMainView`**:
   - Añadido método `getYearRange()` para obtener del usuario el rango de años a filtrar

5. **Clase `MainTerminalView`**:
   - Implementado el método `getYearRange()` con validación
   - Actualizada la visualización de coches para mostrar el año
   - Modificado el método `add()` para solicitar también el año
   - Modificado el método `editCar()` para permitir editar el año

6. **Clase `MainController`**:
   - Añadido caso 2 en el switch para manejar el filtrado por rango de años
   - Modificado el menú principal para incluir la opción de filtrar por rango de años

Estos cambios permiten:
1. Almacenar el año de creación de cada coche (entre 1950 y 2000)
2. Mostrar el año junto con la matrícula y el modelo
3. Filtrar la lista de coches por un rango de años especificado por el usuario
4. Añadir nuevos coches con su año correspondiente
5. Editar el año de los coches existentes

Ahora los usuarios pueden ver todos los coches o filtrarlos por un rango específico de años, lo que es útil para encontrar coches clásicos de determinadas épocas.
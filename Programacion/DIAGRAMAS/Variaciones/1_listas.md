# Cambios para implementar versión con datos predefinidos

Para convertir la aplicación de entrada libre de datos a una basada en selección de opciones predefinidas, es necesario hacer los siguientes cambios:

## 1. ModelMemory.java

### Código a reemplazar:
```java
public ModelMemory() {
    list = new ArrayList<>();
}
```

### Nuevo código:
```java
public ModelMemory() {
    list = new ArrayList<>();
    // Precarga de datos
    list.add(new Car("1234ABC", "Toyota Corolla"));
    list.add(new Car("5678DEF", "Honda Civic"));
    list.add(new Car("9012GHI", "Ford Focus"));
    list.add(new Car("3456JKL", "Volkswagen Golf"));
    list.add(new Car("7890MNO", "Seat Ibiza"));
}
```

## 2. MainTerminalView.java - Método add()

### Código a reemplazar:
```java
@Override
public Car add() {
    TerminalUtils.output("Menú de concesionario");
    TerminalUtils.output("Nuevo coche");
    TerminalUtils.output("================");

    TerminalUtils.output("Introduzca la matrícula");
    String plate = TerminalUtils.inputText();

    TerminalUtils.output("Introduzca el modelo");
    String model = TerminalUtils.inputText();
    
    Car car = new Car(plate, model);
    return car;
}
```

### Nuevo código:
```java
@Override
public Car add() {
    TerminalUtils.output("Añadir coche");
    TerminalUtils.output("================");
    
    // Definir opciones de coches disponibles
    Car[] availableCars = {
        new Car("1111AAA", "Mercedes Clase A"),
        new Car("2222BBB", "BMW Serie 3"),
        new Car("3333CCC", "Audi A4"),
        new Car("4444DDD", "Renault Clio"),
        new Car("5555EEE", "Peugeot 308")
    };
    
    // Mostrar opciones
    TerminalUtils.output("Seleccione un coche para añadir:");
    for (int i = 0; i < availableCars.length; i++) {
        TerminalUtils.output((i+1) + ". " + availableCars[i].toString());
    }
    
    // Obtener selección del usuario
    int selection;
    try {
        selection = TerminalUtils.inputInt() - 1; // Restar 1 para ajustar al índice del array
        if (selection >= 0 && selection < availableCars.length) {
            return availableCars[selection];
        } else {
            TerminalUtils.output("Selección no válida. Se canceló la adición.");
            return null;
        }
    } catch (Exception e) {
        TerminalUtils.output("Entrada no válida. Se canceló la adición.");
        return null;
    }
}
```

## 3. MainTerminalView.java - Método editCar()

### Código a reemplazar:
```java
@Override
public Car editCar(Car carForEdit) {
    TerminalUtils.output("Editar coche");
    TerminalUtils.output("================");

    TerminalUtils.output("Introduzca la nueva matrícula (si lo deja vacío no se modificará)");
    String plate = TerminalUtils.inputText();
    if(isValidString(plate)) {
        carForEdit.setPlate(plate);
    }

    TerminalUtils.output("Introduzca el nuevo modelo (si lo deja vacío no se modificará)");
    String model = TerminalUtils.inputText();
    if(isValidString(model)) {
        carForEdit.setModel(model);
    }
    
    return carForEdit;
}
```

### Nuevo código:
```java
@Override
public Car editCar(Car carForEdit) {
    TerminalUtils.output("Editar coche");
    TerminalUtils.output("================");
    
    // Opciones predefinidas para matrículas
    String[] plateOptions = {"1111AAA", "2222BBB", "3333CCC", "4444DDD", "5555EEE"};
    // Opciones predefinidas para modelos
    String[] modelOptions = {"Mercedes Clase A", "BMW Serie 3", "Audi A4", "Renault Clio", "Peugeot 308"};
    
    // Editar matrícula
    TerminalUtils.output("Seleccione nueva matrícula:");
    for (int i = 0; i < plateOptions.length; i++) {
        TerminalUtils.output((i+1) + ". " + plateOptions[i]);
    }
    TerminalUtils.output("0. No cambiar");
    
    int plateSelection = TerminalUtils.inputInt();
    if (plateSelection > 0 && plateSelection <= plateOptions.length) {
        carForEdit.setPlate(plateOptions[plateSelection-1]);
    }
    
    // Editar modelo
    TerminalUtils.output("Seleccione nuevo modelo:");
    for (int i = 0; i < modelOptions.length; i++) {
        TerminalUtils.output((i+1) + ". " + modelOptions[i]);
    }
    TerminalUtils.output("0. No cambiar");
    
    int modelSelection = TerminalUtils.inputInt();
    if (modelSelection > 0 && modelSelection <= modelOptions.length) {
        carForEdit.setModel(modelOptions[modelSelection-1]);
    }
    
    return carForEdit;
}
```

## 4. MainController.java - case 2 (añadir coche)

### Código a reemplazar:
```java
case 2: // Añadir coche
    Car car = mainView.add();
    model.add(car);
    break;
```

### Nuevo código:
```java
case 2: // Añadir coche
    Car car = mainView.add();
    if (car != null) {
        model.add(car);
        mainView.showMessage("Coche añadido correctamente.");
    }
    break;
```

## 5. Opcional - Métodos adicionales para seleccionar coches

Para mantener la consistencia, también se podrían modificar los métodos `selectPlateCar()` y `selectCarToDelete()` para que muestren la lista de coches existentes y permitan seleccionar uno por número en lugar de escribir la matrícula.
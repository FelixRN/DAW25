# Proyecto CRUD de concesionario en Java

Este proyecto implementa un sistema CRUD (Crear, Leer, Actualizar, Eliminar) para gestionar información de coches en un concesionario. El programa utiliza una arquitectura orientada a objetos con separación de responsabilidades entre el controlador, el modelo y la vista.

## Estructura del proyecto

El proyecto se estructura en los siguientes paquetes:

*   **`controller`**: Contiene la clase `MainController` que gestiona el flujo del programa y la interacción entre la vista y el modelo.
*   **`model`**: Define la interfaz `IModel` y la implementación concreta `ModelMemory` para el almacenamiento de datos en memoria.
*   **`model.entities`**: Contiene la clase `Car` que representa un coche.
*   **`view`**: Define la interfaz `IMainView` y la implementación `MainTerminalView` para la interfaz de usuario en la consola.
*   **`utils`**: Contiene la clase `TerminalUtils` con métodos de utilidad para la interacción con la consola.
*   **`Main`**: Contiene la clase `Main` con el método `main` que inicia el programa.

## Casos de uso implementados

El programa implementa los siguientes casos de uso:

### Caso 1: Listar coches

El usuario puede listar todos los coches almacenados en el sistema.

*   Se llama al método `list()` de `IModel` para obtener la lista de coches.
*   Se llama al método `list(List<Car>)` de `IMainView` para mostrar la lista al usuario.

### Caso 2: Añadir coche

El usuario puede añadir un nuevo coche al sistema.

*   Se llama al método `add()` de `IMainView` para obtener los datos del nuevo coche.
*   Se llama al método `add(Car)` de `IModel` para añadir el coche al sistema.

### Caso 3: Editar coche

El usuario puede editar la información de un coche existente.

*   Se llama al método `selectPlateCar()` de `IMainView` para que el usuario seleccione el coche a editar.
*   Se llama al método `findByPlate(plate)` de `IModel` para obtener el coche a editar.
*   Se llama al método `editCar(car)` de `IMainView` para que el usuario modifique los datos del coche.
*   Se llama al método `updateCar(plate, modifiedCar)` de `IModel` para actualizar el coche en el sistema.

### Caso 4: Eliminar coche

El usuario puede eliminar un coche del sistema.

*   Se llama al método `selectCarToDelete()` de `IMainView` para que el usuario seleccione el coche a eliminar.
*   Se llama al método `confirmDelete()` de `IMainView` para confirmar la eliminación.
*   Se llama al método `delete(plate)` de `IModel` para eliminar el coche del sistema.

## Próximos pasos

*   Implementar la persistencia de datos en una base de datos.
*   Mejorar la interfaz de usuario con una librería como JLine.
*   Añadir validaciones para los datos introducidos por el usuario.
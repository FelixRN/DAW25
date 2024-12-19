# Ejercicio 15

Crear una lista de libros.
El dueño de la tienda hará un inventario de sus libros, introducirá los campos un id (posición en la que se crea), título (teclado), Autor (se elegirá una aleatoria dentro de una lista), año (aleatorio entre 1800 y 2024) y precio (aleatorio decimal).
Terminará cuando el dueño escriba "listo" en el título.

Se simulará una conversación entre un empleado y cliente comprará preguntando por un título de un libro y si lo tiene el empleado le dirá los campos del libro y el cliente comprará los que sean anteriores a 1900 y valgan más de 20€.

###

* OBLIGATORIO: empezar por el Análisis (Pseudocódigo)
* OBLIGATORIO: programar en inglés
* OBLIGATORIO: `clase` en *Pascalcase* (**primera letra mayúscula**)
* OBLIGATORIO: **cada clase en un fichero** y con el **nombre de la clase**
* OBLIGATORIO: `propiedades`, `variables`, `métodos` y `funciones` en *camelcase* (**primera letra minúscula**)
* OBLIGATORIO: Los `modelos` tienen que tener **propiedades privadas**
* Muy recomendado: uso de git
* Muy recomendado: uso del this con las propiedades
* Muy recomendado: realizar búsquedas en inglés
* Muy recomendado: mantener formateo del código (cuidado con: tabulaciones, líneas vacías)

## Análisis

### Modelo

- Clase Year
    - private int year;

- Price
    -private float price;

- Book
    -private int id;
    -private String title;
    -private Autor autor;
    -private Year year;
    -private Price price;



### Lógica de negocio

- Instanciar la clase Autor
- Instanciar la clase Year
- Instanciar la clase Book

- Crear la lista mediante teclado (scanner)
- Guardar el dato

- Instanciamos la clase Book para poder añadirlo a la lista

- Preguntar si queremos añadir más libros a la lista o no

- Agregar un bucle para la conversión y encontrar el libro anteriormente agregado
- Definir las condiciones en el bucle para que las cumpla

- Si el dato introducido no es encontrado preguntar si desea otro libro, en caso de no ser así cerrar el programa



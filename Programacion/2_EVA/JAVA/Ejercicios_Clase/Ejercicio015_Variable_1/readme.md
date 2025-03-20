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

### Lógica de negocio

- Crear una lista del inventario y del autor
- Crear un inventario con las propiedades: id, título, Autor(elegido aleatoriamente dentro de una lista), Año (entre 1800 y 2024) y precio (aleatorio decimal)
- Acabara cuando el dueño escribar "Listo"

- Conversacion:
"Teneis " + título 
lo tengo/no lo tengo
si lo tiene le dira las propiedades y el cliente comprará los que sean anteriores a 1900 y que valgan más de  20
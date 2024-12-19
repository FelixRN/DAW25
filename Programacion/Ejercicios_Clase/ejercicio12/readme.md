# Ejercicio 12

Crear una lista de al menos cinco móviles, definidos por su marca y cantidad de ram.
Se comprarán los móviles de más de 8GB de ram y los otros se descartarán.

* OBLIGATORIO: `clase` en *camelcase* con primera **letra mayúscula**
* OBLIGATORIO: **cada clase en un fichero** y con el **nombre de la clase**
* OBLIGATORIO: `propiedades`, `variables`, `métodos` y `funciones` en *camelcase* con **primera letra minúscula**
* OBLIGATORIO: Los `modelos` tienen que tener **propiedades privadas**
* Muy recomendado: uso de git
* Muy recomendado: uso del this con las propiedades
* Muy recomendado: programar y realizar búsquedas en inglés
* Muy recomendado: mantener formateo del código (cuidado con: tabulaciones, lineas vacías)

## Análisis
### Modelo

- Phone
    - brand: String
    - ramGB: int

### Lógica de negocio

- Crear lista de móviles
- Instanciar y añadir a la lista 5 móviles
- Recorremos la lista
    - comprobamos si tiene más de 8GB de ram
        - si si lo "compramos"

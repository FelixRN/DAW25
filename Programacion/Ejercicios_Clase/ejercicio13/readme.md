# Ejercicio 13

Crear una lista de al menos cinco botes de pintura, definidos por su marca, cantidad en litros y nombre del color.
Se simulara que un usuario quiere comprar los botes de la lista y le indicara a un vendedor que tamaño y color quiere.
El vendedor le indicara que:
- Si es de más de un litro o igual se imprimirá que es de tamaño grande o si no de tamaño pequeño.
- Para imprimir el color se hará con el color hexadecimal que se disponga en la tienda. Se usará una función `printColorFromName` de `ColorUtils` (la tenéis que crear).
- Al menos uno de los colores no se encuentra controlado por lo que se ha de decir que no se dispone de ese bote de pintura.

##

* OBLIGATORIO: empezar por el Análisis
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

- PaintBucket
    - liters
    - brand
    - colorName

### Lógica de negocio
- Crear una lista
- Instanciar y añadir a la lista cinco botes de pintura
- recorrer la lista
    - Conversacion - Cliente: Quiero un bote de tamaño X y color Y
    - Conversacion - Vendedor:
        - Si es de más de un litro o igual, tamaño grande
        - Si no, de tamaño pequeño
        - variable color = ColorUtils.printColorFromName(String name) 
            - la variable puede no existir
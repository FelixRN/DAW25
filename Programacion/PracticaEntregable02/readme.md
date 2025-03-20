# Ejercicio 14
Un cliente acudirá a una inmobiliaria pues está buscando un piso para alquilar. 
Los datos que se tienen de los pisos son: el nombre de la calle, el número, los metros cuadrados, la planta y si tiene o no ascensor. 
Para elegir un piso se seguirá la siguiente conversación:
    - El cliente preguntara por si tiene algún piso más.
    - El vendedor le ofrecerá mínimo 3 pisos y máximo 6
    - Si el vendedor tiene que ofrecer un piso que añadirá a la lista de pisos ofrecidos y sacará:

        - La calle, se obtendrá por teclado.
        - El número, de la posición en la lista.
        - Los metros cuadrados, un número decimal entre 33,33 m2 y 88.20 m2
        - La planta, número entre 0 y 8.

El cliente preguntará por si tiene ascensor y vendedor le dirá que si o no.

Como el cliente es extranjero, pide que le repita todos los pisos:
    - Se utilizarán dos funciones para la presentación de los pisos:
        - La planta no irá por número si no por cardinales (1).
        - Y los metros cuadrados en pies cuadrados (1).
El cliente contestará:
    - Si está entre 33,33 m2 y 40,00 m2 (incluidos) “Este es muy pequeño”.
    - Si está entre 40,00 m2 y 65,00 m2 (no incluidos), “Este mediano…”.
    - Si es igual o más de 65,00 m2 “Mucho para limpiar”


##

* OBLIGATORIO: empezar por el Análisis
* OBLIGATORIO: programar en inglés
* OBLIGATORIO: `clase` en *camelcase* con primera **letra mayúscula**
* OBLIGATORIO: **cada clase en un fichero** y con el **nombre de la clase**
* OBLIGATORIO: `propiedades`, `variables`, `métodos` y `funciones` en *camelcase* con **primera letra minúscula**
* OBLIGATORIO: Los `modelos` tienen que tener **propiedades privadas**
* Muy recomendado: uso de git
* Muy recomendado: uso del this con las propiedades
* Muy recomendado: realizar búsquedas en inglés
* Muy recomendado: mantener formateo del código (cuidado con: tabulaciones, lineas vacías)

## Análisis
- Crear una lista de pisos
El cliente preguntara si tiene algún piso más
Vendedor ofrecerá entre 3 y 6 pisos con estas caracteristicas:
- Calle se obtendra por teclado
- El número sera la ID 
- Los metros cuadrados número decimal entre 33,33 m2 y 88,20m2
- La planta se obtendra aleatoriamente entre 0 y 8 

El cliente preguntara si tiene ascensor y el vendedor le dara una respuesta entre "si" o "no"

- Luego se repetira todos los pisos
La planta debe de ir por cardinales
Los metros en pies cuadrados

- Cliente contestara dependiendo de las condiciones de los metros
### Modelo
Clase pisos:
    private String calle;
    private int numero;
    private int metrosc;
    private String planta;
    private String ascensor;
### Lógica de negocio

-Creamos la rama Main con las clases Piso, Ascensor y metros
Colocamos las variables:
    - text = para poder llamarlo 
    - id = Poder añadir los pisos 
Creamos una lista que entrara por teclado
-Recogemos la informacion recibida con la clase Scanner para poder ingresar los pisos


- Al final no añadi la clase Ascensor porque faltaban cosas
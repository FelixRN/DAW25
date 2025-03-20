# PracticaEntregable01

- Clases con PascalCase
- Métodos deben de ser verbos y estar en camelCase
- Variables descriptivas y estar en camelCase
- Uso de this

## Clase cliente

- Propiedades: nombre, precio(kg) y cantidad comprada
- Imprimir por pantalla Vendedor: ¿Quiere alguna furta más?
Cliente contesta el nombre de la fruta
El vendedor le responderá con un precio entre 0,50 euros y 10.00 euros
Cliente contestara con la cantidad en kg que quiere

Se finalizara la compra cuando se conteste "Eso es todo"
Se contestara el precio total de la compra y dependiendo del precio se imprimira por pantalla 

- Si está entre 0 kg y 10 kg (incluidos), “La compra es ligera”.
- Si está entre 10 kg y 50 kg (no incluidos), “Va a necesitar ayuda”.
- Si es igual o más de 50 kg, “Traiga la furgoneta”. 

A continuacion se imprimira el ticket
El cliente le pedirá que le de el ticket, que imprimirá por cada fruta sus campos y el precio total en euros y pesetas
(1). La conversión se hará con una función “convertEuroPeseta” de “MoneyUtils” (1)
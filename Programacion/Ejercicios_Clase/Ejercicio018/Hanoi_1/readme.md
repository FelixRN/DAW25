# Torres de Hanoi
Realiza un juego "Hanoi" en donde tendras que pasar todos los discos a la comunna destino y dejarlos como estaban, de mayor a menor
- Debes de tener un mínimo de 2 palos y máximo 3 
- Los discos los introducira el usuario por teclado
- Los discos estaran en el primer palo(Origen)
- Segundo palo(Auxiliar)
- Tercer palo(Destino)
- Los discos están colocados de mayor a menor tamaño en la columna origen
- Cada disco debera de tener un tamaño
- La regla: No debe de haber un disco de menor tamaño encima de otro
- Puedes hacer las combinaciones que quiereas pero siempre respetando la regla.

## Parte 1


- Creamos la clase Main donde llamaremos a la clase Scanner e introduciremos las propiedades donde se guardarn los datos:
```java
    Scanner scanner = new Scanner(System.in);
    int numeroTorres = 0;   
    int numeroDiscos = 0;
```
- Solicitamos el número de palos al usuario para el programa con su comprobación:
```java
// Usando el bucle doWhile podemos verificar la condición
    do {
        try {
            System.out.println("Introduce el número de palos de la torre (mínimo 2, máximo 3): ");
            numero = teclado.nextInt(); // Leemos el dato introducido

            if (numero < 2 || numero > 3) {
                System.out.println("Número inválido. Debe ser entre 2 y 3.");
                }
            } catch (Exception e) { //Si no se cumple la excepción lanzaremos un error
                System.out.println("Entrada inválida. Por favor, introduce un número.");
                teclado.nextLine(); // Con nextLine "limpiamos" el buffer que queda, para asegurarnos que en la siguiente ejecución y evitar un posible bucle infinito
            }
        } while (numero < 2 || numero > 3); // Repetimos el bucle hasta que sea válido
```
- Preguntaremos al usuario el número de discos que desea ingresar
```java
do {
        try {
            System.out.println("Introduce el número de discos (mínimo 1): ");
            numeroDiscos = teclado.nextInt();

            if (numeroDiscos < 1) {
                System.out.println("El número de discos debe ser al menos 1.");
            }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, introduce un número.");
                teclado.nextLine(); // Limpiar el buffer
            }
        } while (numeroDiscos < 1);

        teclado.close();
```
## Parte 2
- Creamos una clase para definir el funcionamiento del juego(Recursividad):

Creamos una función llamada **resolver** con las siguientes propiedades:
- 
- int numeroDisc
- String origen
- String auxiliar
- String destino

```java
public class Hanoi {
    public void resolver(int numeroDisc, String origen, String auxiliar, String destino) {
}
```
## **Funcion recursiva**

### Creamos una funcion **recursiva** para resolver el juego
- Movemos los discos desde una posición inicial llamada "origen" hasta el "destino" utilizando una torre intermetdia "auxiliar 
- Se imprime por pantalla cada movimiento que se ha hecho para solucionar el problema

```java
if (numeroDisc == 1) {
            System.out.println("- Mover disco de " + origen + " a " + destino);
        } else {
            resolver(numeroDisc - 1, origen, destino, auxiliar); // Paso 1
            System.out.println("- Mover disco de " + origen + " a " + destino); // Paso 2
            resolver(numeroDisc - 1, auxiliar, origen, destino); // Paso 3
        }
    }
```
## **Bucle**
- Creamos un bucle utilizando if-else para resolver el juego
```java
if (numeroTorres == 2) {
            System.out.println("Resolviendo con 2 torres (imposible sin usar trucos).");
        } else {
            System.out.println("Resolviendo con 3 torres:");
            torre.resolver(numeroDiscos, "origen", "auxiliar", "destino");
        }
        System.out.println("¡Felicidades! Has resuelto el problema de las Torres de Hanoi.");
    
```
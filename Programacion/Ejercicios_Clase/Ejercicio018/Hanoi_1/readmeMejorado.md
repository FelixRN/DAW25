# Torres de Hanoi - Resolucion del juego en Java

Para la resolución de este juego en Java se usara la recursividad y bloques para asegurar la ejecución correcta del juego y ofreciendo más de una manera de resolver el juego. Además de mover los discos respetando las reglas, también se permitira la entrada del usurio para hacerlo más dinámico en vez de simplemente correr el código.


## Reglas:
-
- Solo se puede mover un disco a la vez.
- Un disco más grande no puede colocarse encima de uno más grande.

El programa solo permite configurar:
- **Número de torres**: mínimo 2 y máximo 3 (introducido por el usuario).
- **Número de discos**: especificado por el usuario.

Objetivo del código:
1. Solicitar y validar las entradas del usuario para poder configurar el juego.
2. Resolver el juego de forma recursiva y otra utilizando bucles
3. Se finalizara con un mensaje de felicitacion cuando se complete la tarea

## Parte 1: Entrada y Validación
### Validando el número de torres que introducira el usuario
- Solicitamos el número de torres al usuario para el programa con su comprobación.
- UUsamos un bucle `do-while` para asegurarnos de que la entrada sea válida.
- Si el usuario introduce un valor inválido, se mostrara un mensaje de error.

```java
    Scanner teclado = new Scanner(System.in);
    int numeroTorres = 0;

    do {
        try {
            System.out.println("Introduce el número de palos de la torre (mínimo 2, máximo 3): ");
            numero = teclado.nextInt(); // Leemos el dato introducido.

            if (numero < 2 || numero > 3) {
                System.out.println("Número inválido. Debe ser entre 2 y 3.");
                }
            } catch (Exception e) { //Si no se cumple la excepción, se  lanzara un error.
                System.out.println("Entrada inválida. Por favor, introduce un número.");
                teclado.nextLine(); // Con nextLine() se leera lo que se introdujo como un String, y de esa manera podremos limpiar el buffer.
            }
        } while (numero < 2 || numero > 3); // Repetimos el bucle hasta que sea válido.
```
- De manera similar al código anterior, validaremos el número de discos introducidos sea de por lo menos 1.
```java
int numeroDiscos = 0;
do {
        try {
            System.out.println("Introduce el número de discos (mínimo 1): ");
            numeroDiscos = teclado.nextInt();

            if (numeroDiscos < 1) {
                System.out.println("El número de discos debe ser al menos 1.");
            }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, introduce un número.");
                teclado.nextLine(); 
            }
        } while (numeroDiscos < 1);

        teclado.close();
```
## Parte 2 - 1: Lógica del Juego utilizando el método **Recursivo**
### Creando y usando la clase "Hanoi"
- Creamos una clase para definir el funcionamiento del juego(Recursividad):
- Creamos una función llamada **resolver** con las siguientes propiedades:

```java
public class Hanoi {
    public void resolver(int numeroDisc, String origen, String auxiliar, String destino) {
}
```
### Creamos una funcion **recursiva** para resolver el juego
- Movemos los discos desde una posición inicial llamada "origen" hasta el "destino" utilizando una torre intermetdia "auxiliar .
- Se imprime por pantalla cada movimiento que se ha hecho para solucionar el problema.

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
## Parte 3 - 1: Ejecución utilizando el método **Recursivo**
1. Validamos la entrada del usuario.
2. Llamamos al método **resolver** de la clase **Hanoi** si hay 3 torres.
3. Si no hubiera 2 torres, mostraremos un mensaje indicando que el problema no se puede resolver.

```java
if (numeroTorres == 2) {
    System.out.println("Resolviendo con 2 torres (imposible sin usar trucos).");
    } else {
    System.out.println("Resolviendo con 3 torres:");
    torre.resolver(numeroDiscos, "origen", "auxiliar", "destino");
    }

System.out.println("¡Felicidades! Has resuelto el problema de las Torres de Hanoi.");
```


## Parte 2-1: Lógica del Juego **Bucle** If-Else
- Creamos la clase principal "Hanoi"
- Definimos las propiedades:
    - Torre: Representa una torre como una pila de discos.
- Definimos los métodos:
    1. resolver: Realiza el proceso iterativo
    2. moverDisco: Donde poseemos la lógica para mover discos entre torres.
    3. imprimirEstado: Nos mostrara el estado actual de las torres después de realizar cada movimiento.
### Método **resolver**
- Usaremos el metodod Math.pow() para calcular el total de movimientos exactos
```java
public class Hanoi{
    public void resolver(int numeroDisc, String origen, String auxiliar, String destino) {
        int movimientosTotales = (int) Math.pow(2, numeroDiscos) - 1; // Total de movimientos
    }
}
```
1. - Creamos las instancias de la clase **Torre** para representar las 3 torres:
```java
Torre origenTorre = new Torre(origen);
Torre auxiliarTorre = new Torre(auxiliar);
Torre destinoTorre = new Torre(destino);
```
2. - Definimos la torre inicial con los discos, se apilaran de mayor a menor
```java
for (int i = numeroDiscos; i >= 1; i--) {
    origenTorre.push(i);
}
```

3. - Si el número de discos introducio es par, el orden de las torres cambia para que el algoritmo funcione correctamente.
```java
Torre torre1 = origenTorre;
Torre torre2 = (numeroDiscos % 2 == 0) ? auxiliarTorre : destinoTorre;
Torre torre3 = (numeroDiscos % 2 == 0) ? destinoTorre : auxiliarTorre;
```
4.- Utlizaremos un bucle para realizar los movimientos necesarios: 
```java
for (int i = 1; i <= movimientosTotales; i++) {
    if (i % 3 == 1) { // Movemos el disco entre la torre 1 y 2
        moverDisco(torre1, torre2);
    } else if (i % 3 == 2) { // Movemos el disco entre la torre 1 y 3
        moverDisco(torre1, torre3);
    } else if (i % 3 == 0) { // Movemos el disco entre la torre 2 y 3
        moverDisco(torre2, torre3);
    }
    imprimirEstado(origenTorre, auxiliarTorre, destinoTorre);
}
```
## Parte 3 - 2: Clase torre
- Crearemos esta clase para que simule una "pila" utilizando la estructura de datos "Stack" en Java.

1. Propiedades
    - nombre: Nombre de la torre.
    - discos: Pila que almacena los discos.

2. Métodos Principales:
    - push(int disco): Añade un disco a la torre.
    - pop(): Retira el disco superior de la torre.
    - peek(): Muestra el disco superior sin retirarlo.
    - isEmpty(): Verifica si la torre está vacía.

- Sobreescribimos el método "toString" para poder imprimir el estado actual de los discos.
```java
@Override
public String toString() {
    return discos.toString();
}
```

## Parte 4: Ejecución utilizando **bucle**.
- Validamos si una torre está vacía usando el método .isEmpty (de Java) 
- Si ambas torres tienen discos, se movera el disco más pequeño hacia la torre contraria.
```java
if (origen.isEmpty() && !destino.isEmpty()) {
    origen.push(destino.pop());
} else if (!origen.isEmpty() && destino.isEmpty()) {
    destino.push(origen.pop());
} else if (origen.peek() > destino.peek()) {
    origen.push(destino.pop());
} else {
    destino.push(origen.pop());
}
```

## Visualización del Estado
- El método "imprimirEstado" muestra el contenido de cada torre después de cada movimiento. Lo que nos ayudara a poder tener una pre-visualización del progreso del juego:
```java
System.out.println("Origen: " + origen);
System.out.println("Auxiliar: " + auxiliar);
System.out.println("Destino: " + destino);
System.out.println("--------------------------------");
```




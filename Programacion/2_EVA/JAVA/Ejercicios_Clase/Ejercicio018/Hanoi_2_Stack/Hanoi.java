package Hanoi_2_Stack;

import java.util.Stack; // Importamos la clase Stack para manejar las torres como pilas

public class Hanoi {
    private Stack<Integer> origen;   // Pila que representa la torre de origen
    private Stack<Integer> auxiliar; // Pila que representa la torre auxiliar
    private Stack<Integer> destino;  // Pila que representa la torre destino

    // Constructor que inicializa las pilas y llena la torre de origen
    public Hanoi(int numeroDiscos) {
        origen = new Stack<>();   // Inicializamos la pila para la torre de origen
        auxiliar = new Stack<>(); // Inicializamos la pila para la torre auxiliar
        destino = new Stack<>();  // Inicializamos la pila para la torre destino

        // Añadimos los discos al origen, del más grande (mayor número) al más pequeño (menor número)
        for (int i = numeroDiscos; i >= 1; i--) {
            origen.push(i);
        }
    }

    
    // Método principal para resolver las Torres de Hanoi
    public void resolver(int numeroDisc, Stack<Integer> origen, Stack<Integer> auxiliar, Stack<Integer> destino, String nombreOrigen, String nombreAuxiliar, String nombreDestino) {
        // Caso base: si hay solo un disco, se mueve directamente
        if (numeroDisc == 1) {
            moverDisco(origen, destino, nombreOrigen, nombreDestino);
        } else {
            // Paso 1: Mover los n-1 discos desde "origen" a "auxiliar" usando "destino" como apoyo
            resolver(numeroDisc - 1, origen, destino, auxiliar, nombreOrigen, nombreDestino, nombreAuxiliar);

            // Paso 2: Mover el disco más grande directamente desde "origen" a "destino"
            moverDisco(origen, destino, nombreOrigen, nombreDestino);

            // Paso 3: Mover los n-1 discos desde "auxiliar" a "destino" usando "origen" como apoyo
            resolver(numeroDisc - 1, auxiliar, origen, destino, nombreAuxiliar, nombreOrigen, nombreDestino);
        }
    }

    // Método que realiza el movimiento de un disco entre dos pilas
    private void moverDisco(Stack<Integer> origen, Stack<Integer> destino, String nombreOrigen, String nombreDestino) {
        // Comprobamos que el movimiento sea válido:
        // 1. La pila de origen no debe estar vacía.
        // 2. El disco en "origen" debe ser menor que el disco en "destino", si "destino" no está vacío.
        if (!origen.isEmpty() && (destino.isEmpty() || origen.peek() < destino.peek())) {
            int disco = origen.pop();  // Quitamos el disco de la cima de la pila de origen
            destino.push(disco);       // Colocamos el disco en la cima de la pila de destino
            System.out.println("- Mover disco " + disco + " de " + nombreOrigen + " a " + nombreDestino);
        } else {
            // Si el movimiento no es válido, lanzamos una excepción
            throw new IllegalStateException("Movimiento inválido: No se puede colocar un disco más grande sobre uno más pequeño.");
        }
    }

    // Métodos para obtener las torres (sirven para acceder a las pilas desde otras clases)
    public Stack<Integer> getOrigen() {
        return origen;
    }

    public Stack<Integer> getAuxiliar() {
        return auxiliar;
    }

    public Stack<Integer> getDestino() {
        return destino;
    }
}



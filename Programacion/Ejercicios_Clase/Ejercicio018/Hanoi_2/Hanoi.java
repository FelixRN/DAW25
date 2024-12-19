package Hanoi_2;

public class Hanoi {
    private int[][] torres; // Matriz para representar las tres torres
    private int[] tope;    // Arreglo para rastrear el índice del tope de cada torre

    // Constructor: inicializa las torres y coloca los discos en la torre de origen
    public Hanoi(int numeroDiscos) {
        torres = new int[3][numeroDiscos]; // Tres torres con capacidad para todos los discos
        tope = new int[]{numeroDiscos - 1, -1, -1}; // El tope de la torre de origen está al final, las otras están vacías

        // Llena la torre de origen con los discos (del más grande al más pequeño)
        for (int i = 0; i < numeroDiscos; i++) {
            torres[0][i] = numeroDiscos - i; // Disco más grande en la posición 0
        }
    }

    // Método para verificar si el juego se ha completado
        private boolean juegoCompletado() {
        // El juego está completo si el número de discos en la torre de destino (torres[2]) es igual al total de discos
        return tope[0] == -1 && tope[1] == -1 && tope[2] == torres[2].length - 1;
        }          



    // Método principal para resolver las Torres de Hanoi
    // Método principal para resolver las Torres de Hanoi
public void resolver(int numeroDisc, int origen, int auxiliar, int destino) {
    if (numeroDisc == 1) {
        moverDisco(origen, destino);
        if (juegoCompletado()) {
            System.out.println("¡Felicidades! Has completado el juego.");
        }
    } else {
        resolver(numeroDisc - 1, origen, destino, auxiliar);
        moverDisco(origen, destino);
        if (juegoCompletado()) {
            System.out.println("¡Felicidades! Has completado el juego.");
        }
        resolver(numeroDisc - 1, auxiliar, origen, destino);
    }
}


    // Método para mover un disco entre dos torres
    private void moverDisco(int origen, int destino) {
        // Validar que haya discos en la torre de origen
        if (tope[origen] < 0) {
            throw new IllegalStateException("Movimiento inválido: La torre de origen está vacía.");
        }
    
        // Validar la regla de tamaño
        int disco = torres[origen][tope[origen]];
        if (tope[destino] >= 0 && torres[destino][tope[destino]] < disco) {
            throw new IllegalStateException("Movimiento inválido: No se puede colocar un disco más grande sobre uno más pequeño.");
        }
    
        // Mover el disco al destino
        torres[destino][++tope[destino]] = disco; // Incrementar el tope de destino y colocar el disco
        torres[origen][tope[origen]--] = 0;       // Quitar el disco del origen y decrementar su tope
    
        // Imprimir el movimiento
        System.out.println("- Mover disco " + disco + " de torre " + (origen + 1) + " a torre " + (destino + 1));
    
        // Llamar a imprimirTorres para mostrar el estado después del movimiento
        imprimirTorres();
    }

    // Método para imprimir el estado actual de las torres (opcional, para depuración)
    public void imprimirTorres() {
        System.out.println("Estado de las torres:");
        for (int i = 0; i < torres[0].length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print((torres[j][i] == 0 ? "." : torres[j][i]) + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    
}

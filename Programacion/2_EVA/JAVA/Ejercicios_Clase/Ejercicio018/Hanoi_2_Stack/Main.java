package Hanoi_2_Stack;

import java.util.Scanner; // Importamos la clase Scanner para leer la entrada del usuario

public class Main {
    public static void main(String[] args) {
        // Creamos una instancia de Scanner para leer el número de discos desde la consola
        Scanner teclado = new Scanner(System.in);

        // Pedimos al usuario que introduzca el número de discos
        System.out.println("Introduce el número de discos de la torre: ");
        int numero = teclado.nextInt(); // Leemos el número de discos
        teclado.close(); // Cerramos el Scanner para liberar recursos

        // Creamos una instancia de la clase Hanoi con el número de discos indicado por el usuario
        Hanoi torre = new Hanoi(numero);

        // Llamamos al método resolver para iniciar la resolución del problema
        // Pasamos las pilas y nombres de las torres para los movimientos
        torre.resolver(numero, torre.getOrigen(), torre.getAuxiliar(), torre.getDestino(), "origen", "auxiliar", "destino");
    }
}

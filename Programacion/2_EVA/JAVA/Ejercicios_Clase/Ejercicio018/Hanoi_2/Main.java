package Hanoi_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el número de discos de la torre: ");
        int numero = teclado.nextInt();
        teclado.close();

        // Crear una instancia de Hanoi con el número de discos
        Hanoi torre = new Hanoi(numero);

        // Mostrar el estado inicial de las torres (opcional)
        torre.imprimirTorres();

        // Resolver el problema de las Torres de Hanoi
        torre.resolver(numero, 0, 1, 2); // Usamos índices: 0 para origen, 1 para auxiliar, 2 para destino

        // Mostrar el estado final de las torres (opcional)
        torre.imprimirTorres();
    }
}



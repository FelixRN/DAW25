package Recursividad.Factorial;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa un número que quieres factorizar: ");
        int numero = scanner.nextInt();

        int numF = Factorizar.factorizar(numero);
        System.out.println("El resultado es: " + numF);
        scanner.close();
    }

    public static class Factorizar {
        public static int factorizar(int numero){
            if (numero <= 1) {
                return 1;
            }else{
                return numero*factorizar(numero-1);
            }
        }
    }
}

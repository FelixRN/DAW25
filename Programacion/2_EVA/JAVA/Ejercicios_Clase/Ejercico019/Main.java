package Ejercico019;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*      boolean isNumber = false;
        Scanner scanner = new Scanner(System.in); // Inicializar Scanner
        int num1 = 0;

        do {
            try {
                System.out.println("Introduce por teclado el primer número");
                num1 = scanner.nextInt(); // Leer un número entero
                isNumber = true; // Indicar que se introdujo un número correctamente
                System.out.println("El número introducido es el " + num1);
            } catch (Exception ex) {
                System.out.println("Error al leer el número. Asegúrate de introducir un número válido.");
                scanner.nextLine(); // Limpiar el buffer para evitar un bucle infinito
            }
        } while (!isNumber);

        isNumber = false;
        int num2 = 0;
        do {
            try {
                System.out.println("Introduce por teclado el segundo número");
                num2 = scanner.nextInt();
                isNumber = true;
                System.out.println("El número introducido es el " + num2);
            } catch (Exception ex) {
                System.out.println("Error al leer el número. Asegúrate de introducir un número válido.");
                scanner.nextLine();
            }
        } while (!isNumber);

System.out.println("Sumamos " + (num1 + num2));

        scanner.close(); // Cerrar el Scanner
        }
*/
        private static int KeyboardInt(String name){

        Scanner scanner = new Scanner(System.in);
            int num = 0;
            boolean isNumber = false;
            do{
                try{
                System.out.println("Introduce por teclado un " + name + ":");
                num = scanner.nextInt();
                isNumber = true;
                System.out.println("El " + name + " introducido es el " + num);
            } catch (Exception ex) {
                System.out.println("Error al leer el número. Asegúrate de introducir un número válido.");
                scanner.nextLine();
            }
        } while (!isNumber);
        return num;
        }
}
}


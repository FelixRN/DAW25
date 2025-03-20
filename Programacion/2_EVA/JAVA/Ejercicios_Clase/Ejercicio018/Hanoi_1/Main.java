package Hanoi_1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Instanciamos la clase Scanner para leer el número de discos
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número de discos de la torre: ");
        int numero = teclado.nextInt();
        teclado.close();

        // Crea una instancia de la clase Hanoi y llama al método "resolver"
        Hanoi torre = new Hanoi();
        torre.resolver(numero, "origen", "auxiliar", "destino");
    }
}

//public class Main {
//   public static void main(String[] args) {
//       Scanner teclado = new Scanner(System.in);
//        int numero = 0; // Inicializar variable para el número de discos
//
//        // Solicitar el número de discos con validación
//        do {
//            try {
//                System.out.println("Introduce el número de discos de la torre (mínimo 2, máximo 3): ");
//                numero = teclado.nextInt(); // Leer el número de discos
//                
//                if (numero < 2 || numero > 3) {
//                    System.out.println("Número inválido. Debe ser entre 2 y 3.");
//                }
//            } catch (Exception e) {
//                System.out.println("Entrada inválida. Por favor, introduce un número.");
//                teclado.nextLine(); // Limpiar el buffer
//            }
//        } while (numero < 2 || numero > 3); // Repetir hasta que el número sea válido
//
//        teclado.close();
//
//        // Crear una instancia de la clase Hanoi y llamar al método "resolver"
//        Hanoi torre = new Hanoi();
//        torre.resolver(numero, "origen", "auxiliar", "destino");
//    }
//}

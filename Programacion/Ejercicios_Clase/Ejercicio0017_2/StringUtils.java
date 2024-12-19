
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Factorial (Ejemplo previo)
        System.out.println("Ingresa un número para factorizarlo: ");
        int num1 = scanner.nextInt();
        int factorial = MathUtils.factorial(num1);
        System.out.println("El factorial de " + num1 + " es " + factorial);

        // Fibonacci
        System.out.println("\nAhora generaremos una secuencia de Fibonacci.");
        System.out.print("Ingresa el primer número de la secuencia: ");
        int fib1 = scanner.nextInt();

        System.out.print("Ingresa el segundo número de la secuencia: ");
        int fib2 = scanner.nextInt();

        System.out.print("¿Cuántos números deseas generar en la secuencia? ");
        int max = scanner.nextInt();

        fibonacci(fib1, fib2, max);
    }

    public static void fibonacci(int num1, int num2, int MAX) {
        System.out.println("\nSecuencia de Fibonacci:");
        System.out.print(num1 + " ");
        System.out.print(num2 + " ");

        for (int i = 2; i < MAX; i++) {
            int fibonacci = num1 + num2;
            System.out.print(fibonacci + " ");
            num1 = num2;
            num2 = fibonacci;
        }
        System.out.println(); // Salto de línea al finalizar la secuencia
    }
}

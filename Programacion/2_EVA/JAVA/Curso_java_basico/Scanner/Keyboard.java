package Scanner;
import java.util.Scanner;

public class Keyboard {
    private static Scanner scanner = new Scanner(System.in); // Inicialización correcta del Scanner
    
    public static String text() {
        return scanner.nextLine(); // Devuelve la línea ingresada
    }

    public static int nextInt() {
        int nInt = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer
        return nInt;
    }

    public static float nextFloat() {
        float nFloat = scanner.nextFloat();
        scanner.nextLine(); // Limpia el buffer
        return nFloat;
    }

    public static double nextDouble() {
        double nDouble = scanner.nextDouble();
        scanner.nextLine(); // Limpia el buffer
        return nDouble;
    }
}


import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        double dateF; //declaración de la variable;
        
    System.out.println("Esto es un convertidor de temperatura");
    System.out.println("Ingresa un número con decimales: ");

    Scanner scanner = new Scanner(System.in);
    //Capturar el número de entrada
    dateF = scanner.nextDouble();

    //Creamos el formato a decimal
    DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("¿En que unidad lo quieres cambiar, grados o farenheit?");
        String date = scanner.next();
        

        if (date.equalsIgnoreCase("grados")) {
            double celsius = (dateF - 32) * 5 / 9;
            System.out.println("La temperatura en grados Celsius es: " + df.format(celsius));
            
        }else if (date.equalsIgnoreCase("farenheit")) {
            double fahrenheit = (dateF * 9 / 5) + 32;
            System.out.println("La temperatura en Farenheit es: " + df.format(fahrenheit));
        } else{
            System.err.println("Unidad no reconocida");
        }
        scanner.close();
    }
}

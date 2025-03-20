import java.util.Scanner;

public class Ejercicio_calculadora {
    public static void main(java.lang.String[] args){
        System.out.println("Esta es una aplicación de calculadora");//-
        System.out.println("Ingresa un número: ");
        Scanner scanner = new Scanner(System.in);
        Byte num1 = scanner.nextByte(); //Trabajando con números de tipo Byte

        System.out.println("Ingresa el segundo número: ");
        Byte num2 = scanner.nextByte();
        //Byte suma = (byte) (num1 + num2);
        System.out.println("La suma de los 2 números es: ");
        System.out.println(num1 + num2);
        scanner.close();
    }
}



/**
 * Crear una calculadora que reciba
 * 2 números y luego imprima el resultado
 * de la suma de estos dos números
 */
package Recursividad.Contar_dígitos;

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingresa un número: ");
    int numero = scanner.nextInt();

    int digitos = ContarDigitos.contarDigitos(numero);
    System.out.println("El número de dígitos es: " + digitos);
    scanner.close();
}

    public static class ContarDigitos {
        public static int contarDigitos(int numero){ //Resivimos por parametro el número en cuestion
            
            numero = Math.abs(numero); //Asegurar que también funcione con negativos
            if (numero < 10) {
                return 1;
            }else{
                numero = numero/10;
                return 1+ contarDigitos(numero);
            }
        }
    }
}

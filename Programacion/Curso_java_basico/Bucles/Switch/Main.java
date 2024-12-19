package Switch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num1 = 7;
        int num2 = 10;
        controlSwitch(num1, num2);
        
                // Bloque del segundo switch
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingresa un número para el día de la semana (1-7):");
                int dia = scanner.nextInt(); // Leer como entero directamente
        
                switch (dia) {
                    case 1:
                        System.out.println("Hoy es lunes, debes estudiar.");
                        break;
                    case 2:
                        System.out.println("Hoy es martes, sigue trabajando.");
                        break;
                    case 3:
                        System.out.println("Hoy es miércoles, mitad de semana.");
                        break;
                    case 4:
                        System.out.println("Hoy es jueves, casi termina.");
                        break;
                    case 5:
                        System.out.println("Hoy es viernes, a relajarse pronto.");
                        break;
                    case 6:
                        System.out.println("Hoy es sábado, tiempo para ti.");
                        break;
                    case 7:
                        System.out.println("Hoy es domingo, descansa.");
                        break;
                    default:
                        System.out.println("Número inválido. Ingresa un número entre 1 y 7.");
                }
        
                scanner.close();
            }

    public static void controlSwitch(int num1, int num2) {
        System.out.println("Control Switch");
        switch(Integer.signum(num2 - num1)) {
            case -1: // num2(7) - num1(-2) = +5
                System.out.println("num1 ("+num1+") es mayor que num2 ("+num2+")");
                break;
            case 0: // num2(7) - num1(7) = 0
                System.out.println("num1 ("+num1+") es igual que num2 ("+num2+")");
                break;
            case 1: // num2(-2) - num1(7) = -9
                System.out.println("num1 ("+num1+") es menor que num2 ("+num2+")");
                break;
            default:
                System.out.println("Error al comparar num1 ("+num1+") y num2("+num2+")");
        }
    }
}


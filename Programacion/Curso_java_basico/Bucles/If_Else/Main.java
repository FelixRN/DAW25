package If_Else;

public class Main {
    public static void main(String[] args) {
        int num1 = 7;
        int num2 = 10;
        
        controlIfElse(num1, num2);
    }
    public static void controlIfElse(int num1, int num2) {
        System.out.println("control IfElse");
        if (num1 < num2) {
            System.out.println("num1 ("+num1+") es menor que num2 ("+num2+")");
        } else if (num1 > num2) {
            System.out.println("num1 ("+num1+") es mayor que num2 ("+num2+")");
        }  else if (num1 == num2) {
            System.out.println("num1 ("+num1+") es igual que num2 ("+num2+")");
        }  else  {
            System.out.println("Error al comparar num1 ("+num1+") y num2("+num2+")");
        } 
    //Exameple if
    int x = 2;
    if (x<10) {
        System.out.println("x en menor que 10");
        if (x < 5) {
            System.out.println("x es menor que 5");
            if (x < 2) {
            System.out.println("x es menor que 2");
            }
        }
        System.out.println("y es mayor");
    }  

    //Example if-else
        int z = 2;
        int y = 5;
        if (z < y) {
            System.out.println("y es mayor");
        } else {
            System.out.println("x es mayor");
        }
    }
}

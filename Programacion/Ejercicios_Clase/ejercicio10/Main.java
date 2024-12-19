public class Main {
    public static void main(String[] args) {
        int num1 = 7;
        int num2 = 10;
        controlIfElse(num1, num2);
        controlSwitch(num1, num2);
        controlTernary(num1, num2);
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
    }

    public static void controlSwitch(int num1, int num2) {
        System.out.println("control Switch");
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

    public static void controlTernary(int num1, int num2) {
        System.out.println("control Ternary");
        String comparationResult = (num1 > num2) ? "mayor" : ((num1 < num2) ? "menor" : "igual");
        System.out.println("num1 ("+num1+") es "+comparationResult+" que num2 ("+num2+")");
    }
}

package Ternary;

public class Main {
    public static void main(String[] args) {
        int num1 = 7;
        int num2 = 10;
        controlTernary(num1, num2);
    }
    public static void controlTernary(int num1, int num2) {
        System.out.println("control Ternary");
        String comparationResult = (num1 > num2) ? "mayor" : ((num1 < num2) ? "menor" : "igual");
        System.out.println("num1 ("+num1+") es "+comparationResult+" que num2 ("+num2+")");
    }

}

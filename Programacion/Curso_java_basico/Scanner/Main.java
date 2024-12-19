package Scanner;
public class Main{
    public static void main(String[] args) {
        System.out.println("Introduce double");
        double nDouble = Keyboard.nextDouble();
        System.out.println("El double introducido");

        System.out.println("Introduce un float");
        float nFloat = Keyboard.nextFloat();
        System.out.println("El float introducido es " + nFloat);

        System.out.println("Introduce entero");
        int nInt = Keyboard.nextInt();
        System.out.println("El entero introducido es " + nFloat);

        String text;
        do{
            System.out.println("Introduce texto");
            text = Keyboard.text();
            System.out.println("El texto introducdio es " + text);
        } while(!text.equals("Adios"));
        
    }
}
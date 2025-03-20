package DoWhile;

public class Main {
    public static void main(String[] args) {
        int min = 0;
        int max = 10;
//Examples::

        // Primer bucle do-while
        int i = min;
        do {
            System.out.println(i);
            i++;
        } while (i <= max); // Recorre de 'min' a 'max'

        // Segundo bucle do-while
        int v = 1;
        do {
            System.out.println("Hello " + v);
            v++;
        } while (v <= 3); // Se ejecuta 3 veces


        //While: check condition then execute
        //Do while: execute then check condition
        int m = 100; //i <=5 is false
        while (m <= 5) {
            System.out.println("Hello " + m);
            m++;
        }

        do {
            System.out.println("Hello " + m);
            m++;
        } while (m <= 5);

        //Tercer ejemplo While

        int x = 1;
        while (x <= 10) {
            System.out.println(x);
            x++; // x=x+2; si queremos que vaya de 2 en 2
        }

    }
}




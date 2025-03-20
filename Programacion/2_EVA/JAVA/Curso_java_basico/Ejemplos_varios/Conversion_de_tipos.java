import java.lang.String;

public class Conversion_de_tipos {
    public static void main(java.lang.String[] args){
        //Conversión implícita
        //byte a = 1;
        //double b = 15;
        //double c = a + b;

        //Conversión explícita
        int x = 15;
        double y = 15.015;
        int z = (int)(x + y); //Transformando el valor a entero
        //int z = x + (int) y ; Transformar únicamente el valor de y
        System.out.println(z);

        String j = "1.1";
        int k = 5;
        double l = Double.parseDouble(j) + k;
        System.out.println(l);

    }
}

public class Operadores_aritmeticos {
    public static void main(java.lang.String[] args){
       // int a = 2 + 2;
       // int b = 2 - 2;
       // int c = 2 * 2;
       // int m = 4 % 3; //Nos indica el resto de la operación de división
        //float d = 10f / 3f;
        //double e = 10.0 / 3.0;

        int x = 5;
        // int y = x++;
        x = x + 5; // = x += 5  - -= *= /=
        System.out.println(x);
        //System.out.println(y);

        /** Orden de las ejecuciones matemáticas:
         * Parentesis
         * Potencia
         * Multiplicacion
         * division
         * suma
         * resta
         */
        int r = (5 + 3) * 2;
        System.out.println(r);
    }
}

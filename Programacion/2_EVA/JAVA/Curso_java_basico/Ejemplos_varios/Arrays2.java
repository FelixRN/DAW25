import java.util.Arrays;

public class Arrays2 {
    public static void main(java.lang.String[] args){
        int[][] numeros = {{0, 1}, {2 ,3}};
        // Podemos cambiar por new int[][] para indicar las columnas y filas que va a tener
        // numeros[0][0] = 5; En la primera indicamos la fila a modificar y en el segundo la columna a modificar
        System.out.println(Arrays.deepToString(numeros));

        //int[][] numeros = new int[3][2];
        //numeros[1][1] = 5;

        //int[] numeros = new int[5];
        //int[] numeros = {0, 1, 2, 3 ,4};

        //numeros[0] = 5;
        //numeros[4] = 8;
        //System.out.println(Arrays.toString(numeros));
        //System.out.println(numeros.length); //Nos devuelve la lóngitud del array
        //Arrays.sort(numeros); //Nos ordena el array de menor a mayor
        //System.out.println(Arrays.toString(numeros));
    }
}

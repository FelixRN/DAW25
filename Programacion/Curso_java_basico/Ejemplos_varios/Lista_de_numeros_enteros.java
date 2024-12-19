import java.util.Arrays;
//Arrays
public class Lista_de_numeros_enteros {
    public static void main(java.lang.String[] args) {
        int[] num = {0, 1, 2, 3, 4};
        num[0] = 7;
        num[4] = 2;
        System.out.println(Arrays.toString(num));
        System.out.println(num.length);
        Arrays.sort(num);
        System.out.println(Arrays.toString(num));
    }
}
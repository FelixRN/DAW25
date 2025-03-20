package Ejercicios_Clase.Ejercicio017;

public class MathUtils {
    public static int factorial(int num) {

        // Si es negativo devolvemos códgo de error
        if (num < 0) {
            return -1;
        }
        // Condicion de salida
        else if (num == 0) {
            return 1;
        }
        int result = num * factorial(num - 1);

        // Resto
        return result;
    }
}

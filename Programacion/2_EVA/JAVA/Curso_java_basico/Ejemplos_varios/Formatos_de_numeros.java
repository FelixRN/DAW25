import java.lang.String;
import java.text.NumberFormat;
import java.util.Locale;

public class Formatos_de_numeros {
    public static void main(java.lang.String[] args){
        Locale locale = Locale.forLanguageTag("es-PE"); //Crear una instancia de la clase local
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale); //Clase abstracta (no se puede crear objetos)
        String result = numberFormat.format(1099.90);
        System.out.println(result);

        //Formatear un número en base a porcentaje
        NumberFormat porcentaje = NumberFormat.getPercentInstance();
        System.out.println(porcentaje.format(0.25));
    }
}

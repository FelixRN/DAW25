package Lista_Strings;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        //Creamos la lista entre los signos <> que sera el tipo de dato y luego el nombre de la lista (en este caso seria "Numeros")
//Lista de tipo String
        List<String> Paises;
        //Inicializamos una lista
        Paises = new ArrayList<>();

        //Agregamos paises
        Paises.add("Perú");
        Paises.add("Colombia");
        Paises.add("México");
        //Si queremos imprimir
        //Accedemos al tamaño de la lista en donde nos devolveria el valor de 3
        System.out.println(Paises.size());
        
        //Verificamos si tiene el texto que queremos comparar
        System.out.println(Paises.contains("Colombia"));
    }
}
    


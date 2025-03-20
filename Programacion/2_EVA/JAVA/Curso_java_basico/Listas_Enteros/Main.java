import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        //Creamos la lista entre los signos <> que sera el tipo de dato y luego el nombre de la lista (en este caso seria "Numeros")
//Lista de tipo enteros
        List<Integer> Numeros;
        //Inicializamos una lista
        Numeros = new ArrayList<>();

        //Agregamos un número
        Numeros.add(1);
        Numeros.add(15);
        Numeros.add(21);
        //Si queremos imprimir
        //Con get accedemos a la posicion de la lista, en este caso se encuentra en la posicion 0
        System.out.println(Numeros.get(0));
        System.out.println(Numeros.get(2));
        
    }
}
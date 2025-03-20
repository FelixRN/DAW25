package PracticaEntregable01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Creamos una lista
        List<Fruits> fruitsList;
        fruitsList = new ArrayList<Fruits>();

        //Instanciamos y añadimos la lista de 5 frutas
        fruitsList.add(new Fruits("Apple", 5));
        fruitsList.add(new Fruits("Orange", 3));
        fruitsList.add(new Fruits("Pear", 10));
        fruitsList.add(new Fruits("Watermelon", 13));
        fruitsList.add(new Fruits("Banana", 9));

        //Generamos un número entre 0.50 y 10.00 euros
        double min = 0.50;
        double max = 10.00;
        double randomNum = min + (Math.random() * (max - min));

        //Recorremos la lista
        for (int i = 0; i < fruitsList.size(); i++){
            Fruits fruits = fruitsList.get(i);
            //Conversación - venderdor
            System.out.println("¿Quiere alguna fruta más? ¿Apple, Orange, Pear, Watermelon o Banana?");
            Scanner scanner = new Scanner(System.in);
            String fruit1 = scanner.nextLine();


            System.out.println("¿Cuanto quieres? " + Math.round(randomNum));
            String fruit2 = scanner.nextLine();

        }


    }
}









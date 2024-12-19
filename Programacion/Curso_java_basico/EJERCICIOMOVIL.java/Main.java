package EJERCICIOMOVIL.java;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Crear lista de moviles
        List<Phone> phoneList;
        phoneList = new ArrayList<Phone>();

        //Instanciar y añadir a la lista 5 móviles
        Phone p1 = new Phone("Motorola", 9);
        Phone p2 = new Phone("Nokia", 1);
        Phone p3 = new Phone("Iphone", 7);
        Phone p4 = new Phone("Xiaomi", 8);
        Phone p5 = new Phone("Poco", 10);
        phoneList.add(p1);
        phoneList.add(p2);
        phoneList.add(p3);
        phoneList.add(p4);
        phoneList.add(p5);

        //Recorremos la lista
        for (int i = 0; i < phoneList.size(); i++){
            Phone phone = phoneList.get(i);
            //Comprobamos si tiene más de 8GB de RAM
            if(phone.getRamGB () > 8){
                //si SI lo "compramos"
                System.out.println("Compramos el movil de la marca" + phone.getName() + " y con ram de " + phone.getRamGB() + "GB");
            }
        }

    }
}

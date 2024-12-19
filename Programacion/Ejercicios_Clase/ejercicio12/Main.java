import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear lista de móviles
        List<Phone> phoneList;
        phoneList = new ArrayList<Phone>();

        // Instanciar y añadir a la lista 5 móviles
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

        // Recorremos la lista
        for(int i = 0; i < phoneList.size(); i++) {
            Phone phone = phoneList.get(i);
            // comprobamos si tiene más de 8GB de ram
            if(phone.getRamGB() > 8) {
                // si si lo "compramos"
                System.out.println("Compramos el movil de la marca "
                    + phone.getName() + " y con ram de " + phone.getRamGB() + " GB");
            }
        }
    }
}
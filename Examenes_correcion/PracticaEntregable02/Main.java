import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
        String text = "";
        int id = 1;
        List<Piso> pisoList;
        pisoList = new ArrayList<Piso>();

        //Agregar los pisos
    do{
        //Instanciamos
        Metros metros = new Metros();
        Planta planta = new Planta();
        Ascensor ascensor = new Ascensor();

        //Preguntar por el piso 
        System.out.println("Ingresa el nombre de los pisos(min 3): ");
        //Creamos la variable namePisos para guardar el dato 
        String namePiso = scanner.nextLine().trim();//Podríamos agregar .trim() para eliminar los espacios en los extremos

        //Validar que el nombre no esté vacío
        if (namePiso.isEmpty()) {
            System.out.println("ERROR El nombre del piso no puede estar vacío. Inténtalo nuevamente.");
            continue;
        }
        
        //Instanciamos el piso con las propiedades anteriormente creadas
        Piso newPisos = new Piso(namePiso,id, metros, planta, ascensor);
        //Agregamos el piso creado a la lista
        pisoList.add(newPisos);
        System.out.println("Piso añadido  " + newPisos);

        id++;
        //Preguntar si se desea continuar
        System.out.println("¿Quieres agregar otro piso? (si/no)");
        //Convertimos los caracteres en String con "toLowerCase"
        text = scanner.nextLine().trim().toLowerCase();
        if (text.isEmpty()) {
            System.out.println("ERROR El nombre del piso no puede estar vacío. Inténtalo nuevamente.");
            continue;
        }

        } while (!text.equals("no")); //No continuar mientras diga "no"


        //Conversacion con el cliente
do {
    System.out.println("Cliente: Estoy buscando un piso en " );
    String clientPisos = scanner.nextLine().trim();
    if (clientPisos .isEmpty()) {
        System.out.println("ERROR El nombre del piso no puede estar vacío. Inténtalo nuevamente.");
        continue;
    }
//Buscar el piso en la lista

boolean found = false;
for (Piso piso : pisoList){
    if (piso.getCalle().equalsIgnoreCase(clientPisos)) {
    System.out.println("Piso encontrado: " + piso);
    
    
    //Verificar las condiciones
//        if(piso.getYear() < 1900 && piso.getPrice() > 20){
//            System.out.println("Compro este libro");
//        } found = true;
//        System.out.println("No quiero este libro");
//        break; //Salir cuando se encuentre el libro
    }
}

//if (!found){
//    System.out.println("Ese piso no se encuentra disponible.");
//}
System.out.println("¿Deseas buscar otro piso? (si/no)");
text = scanner.nextLine().toLowerCase();
} while (!text.equals("no"));

scanner.close();
    }
}

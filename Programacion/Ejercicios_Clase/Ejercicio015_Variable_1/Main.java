import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //Lista de ls 5 libros
        
        List<Inventory> inventoryList;
        inventoryList = new ArrayList<Inventory>();
        Autor autor = new Autor();
        Year year = new Year();
        Price price = new Price();
        //Instanciar 5
        //Colocar los colores en hexadecimal
        Inventory I1 = new Inventory(1, "La metamorfosis",autor, year, price);
        Inventory I2 = new Inventory(2, "La torre oscura",autor, year, price);
        Inventory I3 = new Inventory(3, "Kafka en la orilla",autor, year, price);
        Inventory I4 = new Inventory(4, "Psicologia de ventas",autor, year, price);
        Inventory I5 = new Inventory(5, "45 leyes del poder",autor, year, price);

        inventoryList.add(I1);
        inventoryList.add(I2);
        inventoryList.add(I3);
        inventoryList.add(I4);
        inventoryList.add(I5);

    //Preguntamos que libro va **IMPORTANTE**
    System.out.println("¿Que libro deseas buscar?");
    Scanner scanner = new Scanner(System.in);
    String book = scanner.nextLine(); //nextLine() para capturar todo el título
    

     // Buscar en la lista **IMPORTANTE**
    boolean found = false;
        for (Inventory inventory : inventoryList) {
        if (inventory.getTitle().equalsIgnoreCase(book)) { // Comparación insensible a mayúsculas
        System.out.println("Libro encontrado, " + inventory);
        found = true;
        break; // Salir del bucle una vez encontrado
    }
}
    //Si el dato no fue encontrado **IMPORTANTE
    if (!found) {
        System.out.println("El libro no está en el inventario.");
    }

scanner.close();
        }
    }
//Recorrer lista
       //for (int i = 0; i < inventoryList.size(); i++){
            //Inventory Inventory = inventoryList.get(i);
            //Conversación - Cliente
           // System.out.println();

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";
        int id = 1;
        List<Book> bookList;
        bookList = new ArrayList<Book>();

        //Agregar libros al sistema
        do{
        //Instanciamos
        Autor autor = new Autor();
        Year year = new Year();
        Price price = new Price();

        //Preguntar por el libro
        System.out.println("Ingresa el nombre del libro: ");
        //Creamos la variable nameBook para guardar el dato
        String nameBook = scanner.nextLine().trim();//Podríamos agregar .trim() para eliminar los espacios en los extremos

        //Validar que el nombre no esté vacío
        if (nameBook.isEmpty()) {
            System.out.println("ERROR El nombre del libro no puede estar vacío. Inténtalo nuevamente.");
            continue;
        }
        //Instanciamos el libro con las propiedades anteriormente creadas
        Book newBook = new Book(id, nameBook, autor, year, price);
        //Agregamos el libro creado a la lista
        bookList.add(newBook);
        System.out.println("Libro añadido  " + newBook);

        id++;
        //Preguntar si se desea continuar
        System.out.println("¿Quieres agregar otro libro? (si/no)");
        //Convertimos los caracteres en String con "toLowerCase"
        text = scanner.nextLine().trim().toLowerCase();
        if (text.isEmpty()) {
            System.out.println("ERROR El nombre del libro no puede estar vacío. Inténtalo nuevamente.");
            continue;
        }

        } while (!text.equals("no")); //No continuar mientras diga "no"

    //Conversacion con el cliente
    do {
        System.out.println("Cliente: Estoy buscando el libro " );
        String clientBook = scanner.nextLine().trim();
        if (clientBook .isEmpty()) {
            System.out.println("ERROR El nombre del libro no puede estar vacío. Inténtalo nuevamente.");
            continue;
        }
        //Buscar el libro en la lista

    boolean found = false;
    for (Book book : bookList){
        if (book.getTitle().equalsIgnoreCase(clientBook)) {
            System.out.println("Libro encontrado: " + book);
            //Verificar las condiciones
            if(book.getYear() < 1900 && book.getPrice() > 20){
                System.out.println("Compro este libro");
            } found = true;
            System.out.println("No quiero este libro");
            break; //Salir cuando se encuentre el libro
        }
    }

    if (!found){
        System.out.println("Ese libro no se encuentra disponible.");
    }
    System.out.println("¿Deseas buscar otro libro? (si/no)");
    text = scanner.nextLine().toLowerCase();
    } while (!text.equals("no"));

    scanner.close();
}
}



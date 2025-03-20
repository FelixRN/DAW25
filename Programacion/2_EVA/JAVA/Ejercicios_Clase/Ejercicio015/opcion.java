import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public class opcion { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = ""; // Inicializar con un valor válido
        int id = 1;
        List<Book> bookList = new ArrayList<>();

        // Agregar libros al sistema
        do {
            // Instanciar propiedades del libro
            Autor autor = new Autor();
            Year year = new Year();
            Price price = new Price();

            // Preguntar por el libro
            String nameBook = ""; // Variable para guardar el nombre del libro
            do {
                System.out.println("Ingresa el nombre del libro: ");
                nameBook = scanner.nextLine().trim(); // Eliminar espacios en los extremos

                // Validar que el nombre no esté vacío o contenga solo espacios
                if (nameBook.isEmpty()) {
                    System.out.println("El nombre del libro no puede estar vacío. Inténtalo nuevamente.");
                }
            } while (nameBook.isEmpty()); // Repetir hasta que se ingrese un valor válido

            // Crear e instanciar el libro
            Book newBook = new Book(id, nameBook, autor, year, price);
            bookList.add(newBook);
            System.out.println("Libro añadido: " + newBook);

            id++;

            // Preguntar si desea continuar y validar la entrada
            do {
                System.out.println("¿Quieres agregar otro libro? (si/no)");
                text = scanner.nextLine().trim().toLowerCase();

                // Validación de entrada vacía o inválida
                if (text.isEmpty()) {
                    System.out.println("La respuesta no puede estar vacía. Por favor ingresa 'si' o 'no'.");
                } else if (!text.equals("si") && !text.equals("no")) {
                    System.out.println("Respuesta inválida. Por favor ingresa 'si' o 'no'.");
                }

            } while (text.isEmpty() || (!text.equals("si") && !text.equals("no"))); // Validar respuesta válida

        } while (text.equals("si")); // Continuar si la respuesta es "si"

        // Conversación con el cliente
        do {
            System.out.println("Cliente: Estoy buscando el libro: ");
            String clientBook = scanner.nextLine().trim();

            // Buscar el libro en la lista
            boolean found = false;
            for (Book book : bookList) {
                if (book.getTitle().equalsIgnoreCase(clientBook)) {
                    System.out.println("Libro encontrado: " + book);
                    if (book.getYear() < 1900 && book.getPrice() > 20) {
                        System.out.println("Cliente: Compro este libro.");
                    } else {
                        System.out.println("Cliente: No quiero este libro.");
                    }
                    found = true;
                    break; // Salir del bucle al encontrar el libro
                }
            }

            if (!found) {
                System.out.println("Ese libro no se encuentra disponible.");
            }

            // Preguntar si desea buscar otro libro
            System.out.println("¿Deseas buscar otro libro? (si/no)");
            text = scanner.nextLine().toLowerCase();

        } while (!text.equals("no"));

        scanner.close();
    }
}



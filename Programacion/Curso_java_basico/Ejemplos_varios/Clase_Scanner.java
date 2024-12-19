import java.util.Scanner;

public class Clase_Scanner {
    public static void main(java.lang.String[] args){
    Scanner scanner = new Scanner(System.in); //Creamos una nueva instancia y le vamos a indicar un valor el cual se utilizara para saber de donde debe estar leyendo información, en este caso sería "System.in"

        System.out.println("Ingresa tu edad: ");
    //String valor = scanner.next(); //Usamos una instancia llamada "next" que evaluara las palabras separadas con un espacio como un "token" y este metodo de next tomara solo el primer "token"

        //String valor = scanner.nextLine();//Con esta intancia llamada "Line" nos devuelve los token sin importar los espacios

        Byte valor = scanner.nextByte(); //Trabajando con números de tipo Byte
        System.out.println("Tu edad es: ");
        System.out.println(valor);
        scanner.close();
    }

}

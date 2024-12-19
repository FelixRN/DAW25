package EJERCICIO07RESUELTO;

public class Main {
    public static void main(String[] args) {

        Level lvlEasy = new Level("Fácil");
        Exercise ex10 = new Exercise("Dame patatas", lvlEasy);
        System.out.println(ex10.toString());
    }
    
}

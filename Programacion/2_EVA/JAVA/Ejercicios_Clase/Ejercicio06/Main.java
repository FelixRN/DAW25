package EJERCICIO06;

public class Main {
    public static void main(String[] args) {

    Ejercicio classEjercicio = new Ejercicio(111, "Entidad relacion"); 
    Level classLevel = new Level(222, "izi"); 
    Content classContent = new Content(333, "pregunta parcial");
    Category classCategory = new Category(444, "ventas"); 

    System.out.println(classEjercicio.toString());
    System.out.println(classLevel.toString());
    System.out.println(classContent.toString());
    System.out.println(classCategory.toString());    
    
}   
}

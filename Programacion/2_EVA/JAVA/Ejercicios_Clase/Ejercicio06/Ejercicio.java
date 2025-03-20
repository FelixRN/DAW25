package EJERCICIO06;

public class Ejercicio {
    private int Id_Ejercicio;
    private String Type;
        
        public Ejercicio(int Id_Ejercicio, String Type){
                this.Id_Ejercicio = Id_Ejercicio;
                this.Type = Type;
            }
        public String toString(){
            return "Contenido ID:" + Id_Ejercicio + ", tipo " + Type;
        }
}















/*
public static void main(String[] args) {

        int tipo = (int)(Math.random() * 2);
        System.out.println("El tipo de ejercicio es: " + tipo);

        //Instancia de la clase exercice
        Exercice ejercicio = new Exercice();
        
        //Llamar al método
        ejercicio.mostrarTipoDeEjercicio(tipo);
    }
}

class Exercice {
    // Método
    public void mostrarTipoDeEjercicio(int tipo) {
        if (tipo > 1) {
            System.out.println("Modelo entidad relación");
        } else {
            System.out.println("Descripción de casos de uso");
        }
    }
}
*/ 
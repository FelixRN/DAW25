import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // lista de personas
        List<Person> people;
        people = new ArrayList<Person>();

        // Instanciar tres personas y añadirlas a la lista
        Person p1 = new Person("Federico", "Jimenez", false);
        Person p2 = new Person("Juan", "Martin", true);
        Person p3 = new Person("Aitor", "Menta", true);

        people.add(p1);
        people.add(p2);
        people.add(p3);

        // recorrer la lista
        for(int i = 0; i < people.size(); i++) {
            Person persona = people.get(i);
            // Imprimir si tiene gafas
            // Opción: por propiedades
            //System.out.println("La persona \"" + persona.getName()
            //    + " " + persona.getLastName() + ": "
            //    + (persona.getHasGlasses() ? "si tiene" : "no tiene"));
            // Opción: con "to string"
            System.out.println(persona.toString());
        }
    }
}

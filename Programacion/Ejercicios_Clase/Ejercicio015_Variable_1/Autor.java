import java.util.Random;

public class Autor {
    private String autor;

    //Constructor
    public Autor(){
        this.autor = generateName();
    }

    public void setAutor(String autor){
        this.autor = autor;
    } 
    
    public String getAutor(){
        return autor;
    }



//Método para generar el número aleatorio entre 1 y 5
private String generateName(){
    int min = 1;
    int max = 5;
Random random = new Random();
    int randomNum = random.nextInt(max - min + 1) + min;

    switch (randomNum){
        case 1:
        return "Frank Kafka";

        case 2:
        return "Stephen King";

        case 3:
        return "Haruki Murakami";

        case 4:
        return "Brian Tracy";

        case 5:
        return "Robert Greene";

        default:
            return "Desconocido";
    }
    
}
@Override
    public String toString(){
        return "" + autor;
    }
}

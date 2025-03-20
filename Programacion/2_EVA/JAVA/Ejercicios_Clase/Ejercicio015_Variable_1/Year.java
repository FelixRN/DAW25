import java.util.Random;

public class Year {
    private int year;

    //Constructor
    public Year(){
        this.year = generateYear();
    }

    public void setYear(int year){
    this.year = year;
    } 
    //Devuelve el valor del atributo
    public int getYear(){
    return year;
    }
    //Método para generar el número aleatorio entre 1 y 5

    private int generateYear(){
        int min = 1800;
        int max = 2024;
    Random randomY = new Random();
    int randomYear = randomY.nextInt(max - min +1) + min;

    return randomYear;

    }
    @Override
    public String toString(){
        return "" + year;
    }

}

import java.util.Random;

public class Planta {
    private int planta;

    //Constructor
    public Planta(){
        this.planta = generatePlanta();
    }

    public void setPlanta(int planta){
    this.planta = planta;
    } 
    //Devuelve el valor del atributo
    public int getPlanta(){
    return planta;
    }
    //Método para generar el número aleatorio entre 0 y 8

    private int generatePlanta(){
        int min = 0;
        int max = 8;
    Random randomP = new Random();
    int randomPlanta = randomP.nextInt(max - min +1) + min;

    return randomPlanta;

    }
    @Override
    public String toString(){
        return "" + planta;
    }

}
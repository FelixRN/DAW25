import java.util.Random;

public class Price {
    private float price;

    //Contrusctor
    public Price(){
        this.price = generatePrice();
    }

    public void setPrice(float price){
        this.price = price;
    }
    //Devolver el valor
    public float getPrice(){
        return price;
    }

    //Método para generara un num entre 15 y 30

    private float generatePrice(){
        float min = 15f;
        float max = 30f;

        Random random = new Random();
        
        //No se permite especificar directamente como (max - min +1)
        float generatePrice = random.nextFloat() * (max - min) + min;
        //Si no fuera tipo float reemplazar la f por 0
        return Math.round(generatePrice * 100.0) / 100.f;

}
@Override
public String toString(){
    return "" + price;
}
}
import java.util.Random;

public class Metros {
    private float metros;

    //Contrusctor
    public Metros(){
        this.metros = generateMetros();
    }

    public void setMetros(float metros){
        this.metros = metros;
    }
    //Devolver el valor
    public float getMetros(){
        return metros;
    }

    //Método para generara un num entre 33,33 y 88,20

    private float generateMetros(){
        float min = 33.33f;
        float max = 88.20f;

        Random random = new Random();
        
        //No se permite especificar directamente como (max - min +1)
        float generateMetros = random.nextFloat() * (max - min) + min;
        //Si no fuera tipo float reemplazar la f por 0
        return Math.round(generateMetros * 100.0) / 100.f;
}
@Override
public String toString(){
    return "" + metros;
}
}
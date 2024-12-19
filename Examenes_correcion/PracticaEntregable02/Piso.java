public class Piso{
    private String calle;
    private int id;
    private Metros metros;
    private Planta planta; 
    private Ascensor ascensor;

public Piso(String calle, int id, Metros metros, Planta planta, Ascensor ascensor){ 
        this.calle = calle;
        this.id = id;
        this.metros = metros;
        this.planta = planta;
        this.ascensor = ascensor;
    }

    public String getCalle(){
        return this.calle;
    }
    
    public int getId(){
        return this.id;
    }

    public float getMetros(){
        return this.metros.getMetros();
    }

    public int getPlanta(){
        //agregar get para recibir la información de la otra clase
        return this.planta.getPlanta();
    }

    public String getAscensor(){
        return this.ascensor.getAscensor();
    }

    @Override
    public String toString(){
        return "Los datos son los siguientes :  Calle " + calle + ", Id " + id + " ,metros: " + metros + " ,Planta " + planta + ascensor;
    }
}


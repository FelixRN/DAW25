package EJERCICIO06;

public class Level {
private int Id_Level;
private String Type;

    public Level(int Id_Level, String Type){
        this.Id_Level = Id_Level;
        this.Type = Type;
    }
public String toString(){
    return "Contenido ID:" + Id_Level + ", tipo " + Type;
}
}



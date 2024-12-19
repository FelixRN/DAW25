package EJERCICIO06;
public class Content {
    private int Id_Content;
    private String Type;
    
        public Content(int Id_Content, String Type){
            this.Id_Content = Id_Content;
            this.Type = Type;
        }
    public String toString(){
        return "Contenido ID:" + Id_Content + ", tipo " + Type;
    }
    }
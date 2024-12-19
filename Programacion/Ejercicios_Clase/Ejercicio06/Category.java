package EJERCICIO06;

public class Category {
    private int Id_Category;
    private String Type;
    
        public Category(int Id_Category, String Type){
            this.Id_Category = Id_Category;
            this.Type = Type;
        }
    public String toString(){
        return "Contenido ID:" + Id_Category + ", tipo " + Type;
    }
    }
    

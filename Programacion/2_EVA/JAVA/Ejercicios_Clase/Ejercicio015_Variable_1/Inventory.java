public class Inventory {
    private int id;
    private String title;
    private Autor autor;
    private Year year;
    private Price price;

    public Inventory(int id, String title, Autor autor, Year year, Price price){
        this.id = id;
        this.title = title;
        this.autor = autor;
        this.year = year;
        this.price = price;
    }

    public int getId(){
        return this.id;
    }
    
    public String getTitle(){
        return this.title;
    }

    @Override
    public String toString(){
        return "Los datos son los siguientes :  Id " + id + ", Título " + title + " ,autor: " + autor + " ,año de publicación: " + year + ", precio: " + price + " euros";
    }
}

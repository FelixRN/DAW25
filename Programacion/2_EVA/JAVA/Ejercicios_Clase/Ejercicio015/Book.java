public class Book {
    private int id;
    private String title;
    private Autor autor;
    private Year year;
    private Price price;

    public Book(int id, String title, Autor autor, Year year, Price price){
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

    public int getYear(){
        //agregar get para recibir la información de la otra clase
        return this.year.getYear();
    }
    public float getPrice(){
        return this.price.getPrice();
    }

    @Override
    public String toString(){
        return "Los datos son los siguientes :  Id " + id + ", Título " + title + " ,autor: " + autor + " ,año de publicación: " + year + ", precio: " + price + " euros";
    }
}

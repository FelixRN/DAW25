public class Product {
    private String name;
    private Price price;

    public Product(String name, Price price) {
        this.name = name;
        this.price = price;
    }
    
    // toString
    public String toString() {
        String result = "El producto " + this.name
            + " tiene precio de " + this.price.getValue();
        return result;
    }

    public String getName() {
        return this.name;
    }

    public int getPriceValue() {
        return this.price.getValue();
    }

    public String toStringForOrder() {
        String result = this.name +  " (" + this.price.getValue() + ") ";
        return result;
    }
}
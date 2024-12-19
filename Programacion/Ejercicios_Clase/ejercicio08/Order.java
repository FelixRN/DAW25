import java.util.List;
import java.util.ArrayList;

public class Order {
    private String deliveryDate;
    private List<Product> productList;
    private Transport transport;

    // constructor
    public Order(String deliveryDate, Product product, Transport transport){
        this.deliveryDate = deliveryDate;
        // Creamos la lista de productos
        this.productList = new ArrayList<Product>();
        // Añadimos un producto a la lista
        this.productList.add(product);
        this.transport = transport;
    }

    public void setTransporte(Transport transport) {
        this.transport = transport;
    }

    public void setAddProduct(Product newProduct) {
        this.productList.add(newProduct);
    }

    // toString
    public String toString() {
        String result = "El pedido llegara en fecha " + this.deliveryDate
            // Cuando es un único Product
            //+ " con el producto " + this.product.getName() +  " (" + this.product.getPriceValue() + ") "
            //+ " con el producto " + this.product.toStringForOrder()
            + " en el transporte " + this.transport.getType();

        // Recorremos la lista de productos desde la posición inicial 0 hasta el tamaño de la lista menos uno
        for(int i = 0; i < this.productList.size(); i++) {
            Product product = this.productList.get(i);
            // Añadimos al resultado el producto en una nueva linea ("\n")
            //result += "\n - "+ this.product.toStringForOrder();
            result = result + "\n - "+ product.toStringForOrder();
        }

        /*for(Product product : this.productList)
        {
            //result += "\n - "+ this.product.toStringForOrder();
            result = result + "\n - "+ product.toStringForOrder();
        }*/

        return result;
    }
    /*
    // Cuando es un único Product, con opciones
    public String toString() {
        String result = "El pedido llegara en fecha " + this.deliveryDate
            // Dependiendo de quien tiene la información y responsabilidad lo podemos hacer de dos maneras:
            // Opción 1
            + " con el producto " + this.product.getName() +  " (" + this.product.getPriceValue() + ") "
            // Opción 2
            //+ " con el producto " + this.product.toStringForOrder()
            + " en el transporte " + this.transport.getType();
        return result;
    }*/
}
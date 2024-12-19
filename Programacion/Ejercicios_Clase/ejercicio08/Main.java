public class Main {
    public static void main(String[] args) {
        Price price = new Price(199);
        System.out.println(price);

        Product product = new Product("keyboard", price);
        System.out.println(product);
        
        Transport transport = new Transport("van");
        System.out.println(transport);

        Order order = new Order("10/08/2456", product, transport);
        System.out.println(order);

        Transport newTransport = new Transport("dron");
        System.out.println(newTransport);

        order.setTransporte(newTransport);
        
        System.out.println(order);
        
        // Crear un nuevo productos
        Product product2 = new Product("mouse", price);
        // set para añadir el producto a la lista
        order.setAddProduct(product2);
        // Comprobar (imprimir que salgan los productos)
        System.out.println(order);
    }
}

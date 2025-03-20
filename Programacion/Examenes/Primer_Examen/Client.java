package PracticaEntregable01;

public class Client {
    private String clientName;
    private int price;
    private float amount;

    public Client(String clientName, int price, float amount){
    this.clientName = clientName;
    this.price = price;
    this.amount = amount;
}

public String getClientName() {
    return this.clientName;
}

public int getPrice() {
    return this.price;
}

public float getAmount() {
    return this.amount;
}

}

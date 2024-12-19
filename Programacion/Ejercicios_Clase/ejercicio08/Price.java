public class Price {
    private int value;

    public Price(int value) {
        this.value = value;
    }

    // toString
    public String toString() {
        String result = "El precio es de " + this.value;
        return result;
    }

    public int getValue() {
        return this.value;
    }
}
public class Transport {
    private String type;
    
    public Transport(String type) {
        this.type = type;
    }
    
    // toString
    public String toString() {
        String result = "El transporte es con " + this.type;
        return result;
    }

    public String getType() {
        return this.type;
    }
}
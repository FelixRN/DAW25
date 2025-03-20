public class Phone {
    private String name;
    private int ramGB;

    public Phone(String name, int ramGB) {
        this.name = name;
        this.ramGB = ramGB;
    }

    public String getName() {
        return this.name;
    }

    public int getRamGB() {
        return this.ramGB;
    }
}

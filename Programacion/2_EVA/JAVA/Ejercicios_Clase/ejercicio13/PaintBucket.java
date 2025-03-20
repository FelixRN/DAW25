public class PaintBucket {
    private float liters;
    private String brand;
    private String colorName;

    public PaintBucket(float liters, String brand, String colorName) {
        this.liters = liters;
        this.brand = brand;
        this.colorName = colorName;
    }

    public float getLiters() {
        return this.liters;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getColorName() {
        return this.colorName;
    }
}

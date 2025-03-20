
package com.project02.model.entities;

public class Car {
    private int id;
    private String brand;
    private String model;
    private float consume;
    private int emissions;
    private String imagen;

    public Car(int id, String brand, String model, float consume, int emissions, String imagen) {
        super();
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.consume = consume;
        this.emissions = emissions;
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Car Id=" + id + ", marca=" + brand + ", modelo=" + model + ", consumo=" + consume + ", emision="
                + emissions + ", imagen=" + imagen;
    }

    @Override
    public Car clone() {
        return new Car(this.id, this.brand, this.model, this.consume, this.emissions, this.imagen);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getConsume() {
        return consume;
    }

    public void setConsume(float consume) {
        this.consume = consume;
    }

    public int getEmissions() {
        return emissions;
    }

    public void setEmissions(int emissions) {
        this.emissions = emissions;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


}
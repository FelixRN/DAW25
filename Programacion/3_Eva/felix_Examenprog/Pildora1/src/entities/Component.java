package entities;

import java.util.UUID;

public class Component {
	    private String id;
	    private String name;
	    private String description;
	    private double price;
	    private int stock;
	    
	    public Component(String id, String name, String description, double price, int stock) {
	        this.id = id;
	        this.name = name;
	        this.description = description;
	        this.price = price;
	        this.stock = stock;
	    }
	    
	    // Constructor alternativo que genera un ID único automáticamente
	    public Component(String name, String description, double price, int stock) {
	        this.id = generateUniqueId();
	        this.name = name;
	        this.description = description;
	        this.price = price;
	        this.stock = stock;
	    }
	    
	    private String generateUniqueId() {
	        return UUID.randomUUID().toString().substring(0, 8);
	    }
	    
	    // Getters y setters
	    public String getId() {
	        return id;
	    }
	    
	    public void setId(String id) {
	        this.id = id;
	    }
	    
	    public String getName() {
	        return name;
	    }
	    
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public String getDescription() {
	        return description;
	    }
	    
	    public void setDescription(String description) {
	        this.description = description;
	    }
	    
	    public double getPrice() {
	        return price;
	    }
	    
	    public void setPrice(double price) {
	        this.price = price;
	    }
	    
	    public int getStock() {
	        return stock;
	    }
	    
	    public void setStock(int stock) {
	        this.stock = stock;
	    }
	    
	    @Override
	    public String toString() {
	        return "ID: " + id + " | Nombre: " + name + " | Precio: " + price + "€ | Stock: " + stock;
	    }
	}


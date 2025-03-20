package entities;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private String userId;
    private Map<Component, Integer> items;
    
    public ShoppingCart(String userId) {
        this.userId = userId;
        this.items = new HashMap<>();
    }
    
    public void addItem(Component component, int quantity) {
        // Si ya existe, aumentar la cantidad
        if (items.containsKey(component)) {
            items.put(component, items.get(component) + quantity);
        } else {
            items.put(component, quantity);
        }
    }
    
    public void removeItem(Component component) {
        items.remove(component);
    }
    
    public Map<Component, Integer> getItems() {
        return items;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public double getTotal() {
        double total = 0;
        for (Map.Entry<Component, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}
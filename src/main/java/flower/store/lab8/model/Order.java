package flower.store.lab8.model;

import flower.store.lab8.payment.Payment;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Order {
    private List<Item> items;
    private Payment paymentStrategy;
    
    public Order(List<String> list) {
        this.items = new ArrayList<>();
    }
    
    public void addItem(Item item) {
        items.add(item);
    }
    
    public void removeItem(Item item) {
        items.remove(item);
    }
    
    public double calculateTotalPrice() {
        return items.stream()
                .mapToDouble(Item::getPrice)
                .sum();
    }
    
    public boolean processOrder() {
        double totalPrice = calculateTotalPrice();
        return paymentStrategy.pay(totalPrice);
    }
}

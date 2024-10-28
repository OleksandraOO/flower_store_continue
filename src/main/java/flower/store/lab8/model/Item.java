package flower.store.lab8.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private Flower flower;
    private int quantity;
    
    public double getPrice() {
        return flower.getPrice() * quantity;
    }
}

package flower.store.lab8.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Flower {
    private String name;
    private String color;
    private double price;
    private boolean available;
}
package flower.store.lab8.service;

import flower.store.lab8.model.Flower;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlowerService {
    private final List<Flower> flowers = new ArrayList<>();

    public FlowerService() {
        flowers.add(new Flower("Rose", "Red", 15.99, true));
        flowers.add(new Flower("Tulip", "Yellow", 10.99, true));
        flowers.add(new Flower("Lily", "White", 12.99, true));
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }
}

package flower.store.lab8.delivery;

import flower.store.lab8.model.Order;
import org.springframework.stereotype.Component;

@Component
public class PostDeliveryStrategy implements Delivery {
    private static final double BASE_COST = 5.0;
    private static final double COST_PER_ITEM = 2.0;

    @Override
    public boolean deliver(Order order) {
        System.out.println("Delivering order via Post service");
        return true;
    }

    @Override
    public double getDeliveryCost(Order order) {
        return BASE_COST + (COST_PER_ITEM * order.getItems().size());
    }
}

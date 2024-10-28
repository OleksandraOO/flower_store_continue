package flower.store.lab8.delivery;

import flower.store.lab8.model.Order;

public interface Delivery {
    boolean deliver(Order order);
    double getDeliveryCost(Order order);
}

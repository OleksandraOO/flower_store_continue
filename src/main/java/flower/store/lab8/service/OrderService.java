package flower.store.lab8.service;

import flower.store.lab8.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public boolean processOrder(Order order) {
        return order.processOrder();
    }
}

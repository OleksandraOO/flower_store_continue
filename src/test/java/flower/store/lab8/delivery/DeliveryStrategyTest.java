package flower.store.lab8.delivery;

import flower.store.lab8.model.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Collections;

class DeliveryStrategyTest {

    @Test
    void testDHLDelivery() {
        DHLDeliveryStrategy dhlDelivery = new DHLDeliveryStrategy();
        Order order = new Order(Collections.singletonList("item1"));
        
        assertTrue(dhlDelivery.deliver(order));
        assertEquals(13.0, dhlDelivery.getDeliveryCost(order));
    }

    @Test
    void testPostDelivery() {
        PostDeliveryStrategy postDelivery = new PostDeliveryStrategy();
        Order order = new Order(Collections.singletonList("item1"));
        
        assertTrue(postDelivery.deliver(order));
        assertEquals(7.0, postDelivery.getDeliveryCost(order));
    }
}

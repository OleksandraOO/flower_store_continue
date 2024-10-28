package flower.store.lab8.controller;

import flower.store.lab8.delivery.Delivery;
import flower.store.lab8.model.Order;
import flower.store.lab8.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final Payment creditCardPayment;
    private final Payment payPalPayment;
    private final Delivery postDelivery;
    private final Delivery dhlDelivery;

    @Autowired
    public OrderController(
            @Qualifier("creditCardPaymentStrategy") Payment creditCardPayment,
            @Qualifier("payPalPaymentStrategy") Payment payPalPayment,
            @Qualifier("postDeliveryStrategy") Delivery postDelivery,
            @Qualifier("dhlDeliveryStrategy") Delivery dhlDelivery) {
        this.creditCardPayment = creditCardPayment;
        this.payPalPayment = payPalPayment;
        this.postDelivery = postDelivery;
        this.dhlDelivery = dhlDelivery;
    }

    @PostMapping("/process")
    public ResponseEntity<String> processOrder(@RequestBody Order order, 
                                             @RequestParam String paymentMethod,
                                             @RequestParam String deliveryMethod) {
        Payment payment = "creditcard".equalsIgnoreCase(paymentMethod) ? 
                         creditCardPayment : payPalPayment;
        Delivery delivery = "post".equalsIgnoreCase(deliveryMethod) ? 
                          postDelivery : dhlDelivery;

        boolean paymentSuccess = payment.pay(order.calculateTotalPrice());
        if (!paymentSuccess) {
            return ResponseEntity.badRequest().body("Payment failed");
        }

        boolean deliverySuccess = delivery.deliver(order);
        if (!deliverySuccess) {
            return ResponseEntity.badRequest().body("Delivery failed");
        }

        return ResponseEntity.ok("Order processed successfully");
    }
}

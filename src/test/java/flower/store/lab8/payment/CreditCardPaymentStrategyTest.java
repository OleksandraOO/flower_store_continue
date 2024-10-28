package flower.store.lab8.payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CreditCardPaymentStrategyTest {

    @Test
    void testCreditCardPayment() {
        CreditCardPaymentStrategy payment = new CreditCardPaymentStrategy("1234567890123456", "123", "12/25");
        assertTrue(payment.pay(100.0));
    }
}

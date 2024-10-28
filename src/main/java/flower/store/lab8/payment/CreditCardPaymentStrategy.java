package flower.store.lab8.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardPaymentStrategy implements Payment {
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    @Override
    public boolean pay(double price) {
        System.out.println("Paying " + price + " using Credit Card");
        return true;
    }
}

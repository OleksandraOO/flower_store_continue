package flower.store.lab8.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PayPalPaymentStrategy implements Payment {
    private String email;
    private String password;

    @Override
    public boolean pay(double price) {
        System.out.println("Paying " + price + " using PayPal");
        return true;
    }
}

package flower.store.lab8.payment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreditCardPaymentEndpoint() throws Exception {
        mockMvc.perform(post("/payment/credit-card")
                .param("price", "100.0")
                .param("cardNumber", "1234567890123456")
                .param("cvv", "123")
                .param("expiryDate", "12/25"))
                .andExpect(status().isOk())
                .andExpect(content().string("Payment successful"));
                
    }
}

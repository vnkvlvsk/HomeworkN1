package pt1.HomeworkN3.strategy;

import java.math.BigDecimal;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Оплата через PayPal: " + amount + " руб.");
    }
}

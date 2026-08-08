package pt1.HomeworkN3.strategy;

import java.math.BigDecimal;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Оплата картой: " + amount + " руб.");
    }
}

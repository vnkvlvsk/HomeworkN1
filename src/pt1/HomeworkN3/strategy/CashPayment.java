package pt1.HomeworkN3.strategy;

import java.math.BigDecimal;

public class CashPayment implements PaymentStrategy {
    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Оплата наличными: " + amount + " руб.");
    }
}

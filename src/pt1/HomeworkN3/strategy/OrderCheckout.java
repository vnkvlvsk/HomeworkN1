package pt1.HomeworkN3.strategy;

import java.math.BigDecimal;

public class OrderCheckout {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay(BigDecimal amount) {
        strategy.pay(amount);
    }
}

package pt1.HomeworkN3;

import pt1.HomeworkN3.adapter.LegacyGatewayAdapter;
import pt1.HomeworkN3.adapter.ModernPaymentGateway;
import pt1.HomeworkN3.builder.Order;
import pt1.HomeworkN3.chain.JuniorSupport;
import pt1.HomeworkN3.chain.SeniorSupport;
import pt1.HomeworkN3.chain.SupportHandler;
import pt1.HomeworkN3.chain.TeamLead;
import pt1.HomeworkN3.decorator.CheeseTopping;
import pt1.HomeworkN3.decorator.MargheritaPizza;
import pt1.HomeworkN3.decorator.MushroomTopping;
import pt1.HomeworkN3.decorator.Pizza;
import pt1.HomeworkN3.proxy.LoggingOrderServiceProxy;
import pt1.HomeworkN3.proxy.OrderService;
import pt1.HomeworkN3.strategy.CashPayment;
import pt1.HomeworkN3.strategy.CreditCardPayment;
import pt1.HomeworkN3.strategy.OrderCheckout;
import pt1.HomeworkN3.strategy.PayPalPayment;

import java.math.BigDecimal;

public class PatternsRunners {

    public static void main(String[] args) {
        runStrategy();
        runChainOfResponsibility();
        runBuilder();
        runProxy();
        runDecorator();
        runAdapter();
    }

    public static void runStrategy() {
        System.out.println("=== Стратегия ===");
        OrderCheckout checkout = new OrderCheckout();
        checkout.setStrategy(new CreditCardPayment());
        checkout.pay(BigDecimal.valueOf(1000));
        checkout.setStrategy(new PayPalPayment());
        checkout.pay(BigDecimal.valueOf(500));
        checkout.setStrategy(new CashPayment());
        checkout.pay(BigDecimal.valueOf(300));
    }

    public static void runChainOfResponsibility() {
        System.out.println("\n=== Цепочка обязанностей ===");
        SupportHandler junior = new JuniorSupport();
        SupportHandler senior = new SeniorSupport();
        SupportHandler tl = new TeamLead();
        junior.setNext(senior);
        senior.setNext(tl);

        junior.handle(1);
        junior.handle(2);
        junior.handle(3);
    }

    public static void runBuilder() {
        System.out.println("\n=== Билдер ===");
        Order order = Order.builder()
                .customerName("Иван")
                .item("Ноутбук")
                .quantity(1)
                .address("ул. Ленина, 5")
                .build();
        System.out.println(order);
    }

    public static void runProxy() {
        System.out.println("\n=== Прокси ===");
        OrderService service = new LoggingOrderServiceProxy();
        service.placeOrder("Мышка");
    }

    public static void runDecorator() {
        System.out.println("\n=== Декоратор ===");
        Pizza pizza = new MargheritaPizza();
        System.out.println(pizza.getDescription() + " — " + pizza.getPrice() + " руб.");
        pizza = new CheeseTopping(pizza);
        pizza = new MushroomTopping(pizza);
        System.out.println(pizza.getDescription() + " — " + pizza.getPrice() + " руб.");
    }

    public static void runAdapter() {
        System.out.println("\n=== Адаптер ===");
        ModernPaymentGateway gateway = new LegacyGatewayAdapter();
        gateway.pay(250.0);
    }
}

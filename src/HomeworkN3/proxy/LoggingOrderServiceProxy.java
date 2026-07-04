package HomeworkN3.proxy;

public class LoggingOrderServiceProxy implements OrderService {
    private OrderService realService = new RealOrderService();

    @Override
    public void placeOrder(String item) {
        System.out.println("Лог: начало оформления заказа");
        realService.placeOrder(item);
        System.out.println("Лог: заказ оформлен");
    }
}

package HomeworkN3.proxy;

public class RealOrderService implements OrderService {
    @Override
    public void placeOrder(String item) {
        System.out.println("Оформляем заказ: " + item);
    }
}

package HomeworkN3.adapter;

public class LegacyPaymentGateway {
    public void makePayment(int amountInCents) {
        System.out.println("Старый шлюз: оплата " + amountInCents + " копеек");
    }
}

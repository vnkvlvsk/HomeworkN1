package HomeworkN3.adapter;

public class LegacyGatewayAdapter implements ModernPaymentGateway {
    private LegacyPaymentGateway legacy = new LegacyPaymentGateway();

    @Override
    public void pay(double amountInRubles) {
        int kopecks = (int) (amountInRubles * 100);
        legacy.makePayment(kopecks);
    }
}

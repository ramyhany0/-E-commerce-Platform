public class BankTransferPaymentGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing bank transfer payment of amount: " + amount);
    }
}

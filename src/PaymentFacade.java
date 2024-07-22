public class PaymentFacade {
    private final PaymentGateway creditCardPaymentGateway;
    private final PaymentGateway payPalPaymentGateway;
    private final PaymentGateway bankTransferPaymentGateway;

    public PaymentFacade() {
        this.creditCardPaymentGateway = new CreditCardPaymentGateway();
        this.payPalPaymentGateway = new PayPalPaymentGateway();
        this.bankTransferPaymentGateway = new BankTransferPaymentGateway();
    }

    public void pay(String method, double amount) {
        switch (method.toLowerCase()) {
            case "credit-card":
                creditCardPaymentGateway.processPayment(amount);
                break;
            case "paypal":
                payPalPaymentGateway.processPayment(amount);
                break;
            case "bank-transfer":
                bankTransferPaymentGateway.processPayment(amount);
                break;
            default:
                throw new IllegalArgumentException("Unknown payment method");
        }
    }
}

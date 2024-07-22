public class OnlineOrder extends Order {
    public OnlineOrder(String orderId, double amount) {
        super(orderId, amount);
    }

    @Override
    public void processOrder() {
        System.out.println("Processing online order with ID: " + orderId + " and amount: " + amount);
    }
}

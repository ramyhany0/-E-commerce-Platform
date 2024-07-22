public class InStorePickupOrder extends Order {
    public InStorePickupOrder(String orderId, double amount) {
        super(orderId, amount);
    }

    @Override
    public void processOrder() {
        System.out.println("Processing in-store pickup order with ID: " + orderId + " and amount: " + amount);
    }
}

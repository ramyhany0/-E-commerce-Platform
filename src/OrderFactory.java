public class OrderFactory {
    public static Order createOrder(String type, String orderId, double amount) {
        if (type.equalsIgnoreCase("online")) {
            return new OnlineOrder(orderId, amount);
        } else if (type.equalsIgnoreCase("In Store")) {
            return new InStorePickupOrder(orderId, amount);
        }
        throw new IllegalArgumentException("Unknown order type");
    }
}

import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        ProductCatalog catalog = ProductCatalog.getInstance();
        catalog.addProduct(new Product.ProductBuilder("SanDisk Flash")
                .setColor("Yellow")
                .setSize("4 inch")
                .setWeight(0.01)
                .addFeature("RAM", "--")
                .addFeature("Storage", "64GB")
                .build());
        catalog.addProduct(new Product.ProductBuilder("KingStone Flash")
                .setColor("White")
                .setSize("4 inch")
                .setWeight(0.01)
                .addFeature("RAM", "--")
                .addFeature("Storage", "128GB")
                .build());
        catalog.addProduct(new Product.ProductBuilder("SmartWatch")
                .setColor("Red")
                .setSize("4.4 inch")
                .setWeight(0.1)
                .addFeature("RAM", "1GB")
                .addFeature("Storage", "4GB")
                .build());
        catalog.addProduct(new Product.ProductBuilder("Laptop")
                .setColor("Silver")
                .setSize("15 inch")
                .setWeight(2.5)
                .addFeature("RAM", "16GB")
                .addFeature("Storage", "512GB SSD")
                .build());
        catalog.addProduct(new Product.ProductBuilder("Smartphone")
                .setColor("Black")
                .setSize("6 inch")
                .setWeight(0.2)
                .addFeature("RAM", "8GB")
                .addFeature("Storage", "128GB")
                .build());

        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();

        while (true) {
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Product Catalog:");
                    for (Product product : catalog.getProducts()) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.println("Enter product name to add to cart:");
                    String productName = scanner.nextLine();
                    Product selectedProduct = catalog.getProducts().stream()
                            .filter(p -> p.toString().contains(productName))
                            .findFirst()
                            .orElse(null);
                    if (selectedProduct != null) {
                        cart.addProduct(selectedProduct);
                        System.out.println("Product added to cart.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    System.out.println("Cart:");
                    for (Product product : cart.getProducts()) {
                        System.out.println(product);
                    }
                    break;
                case 4:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        System.out.println("Enter order type (online/In Store):");
                        String orderType = scanner.nextLine();
                        Order order = OrderFactory.createOrder(orderType, "ORD" + System.currentTimeMillis(), calculateTotal(cart.getProducts()));
                        order.processOrder();

                        System.out.println("Enter payment method (credit-card/paypal/bank-transfer):");
                        String paymentMethod = scanner.nextLine();
                        PaymentFacade paymentFacade = new PaymentFacade();
                        paymentFacade.pay(paymentMethod, calculateTotal(cart.getProducts()));

                        cart.clear();
                    }
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static double calculateTotal(List<Product> products) {
        double total = 0;
        for (Product product : products) {
            total += product.toString().contains("Laptop") ? 1200.0 : 800.0; // Simplified pricing logic
        }
        return total;
    }
}

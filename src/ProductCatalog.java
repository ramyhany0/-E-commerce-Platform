import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    private static ProductCatalog instance;
    private final List<Product> products;

    private ProductCatalog() {
        products = new ArrayList<>();
    }

    public static synchronized ProductCatalog getInstance() {
        if (instance == null) {
            instance = new ProductCatalog();
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}

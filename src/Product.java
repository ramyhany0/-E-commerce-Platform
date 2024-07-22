import java.util.HashMap;
import java.util.Map;

public class Product {
    private final String name;
    private final String color;
    private final String size;
    private final double weight;
    private final Map<String, String> additionalFeatures;

    private Product(ProductBuilder builder) {
        this.name = builder.name;
        this.color = builder.color;
        this.size = builder.size;
        this.weight = builder.weight;
        this.additionalFeatures = builder.additionalFeatures;
    }

    public static class ProductBuilder {
        private final String name;
        private String color;
        private String size;
        private double weight;
        private final Map<String, String> additionalFeatures = new HashMap<>();

        public ProductBuilder(String name) {
            this.name = name;
        }

        public ProductBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public ProductBuilder setSize(String size) {
            this.size = size;
            return this;
        }

        public ProductBuilder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public ProductBuilder addFeature(String key, String value) {
            this.additionalFeatures.put(key, value);
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', color='" + color + "', size='" + size + "', weight=" + weight + ", additionalFeatures=" + additionalFeatures + "}";
    }
}

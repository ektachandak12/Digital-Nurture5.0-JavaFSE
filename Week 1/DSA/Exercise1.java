import java.util.HashMap;
import java.util.Map;

public class Exercise1 {
    public static class Product {
        private int productId;
        private String productName;
        private int quantity;
        private double price;

        public Product(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        public int getProductId() { return productId; }
        public String getProductName() { return productName; }
        public int getQuantity() { return quantity; }
        public double getPrice() { return price; }

        public void setProductName(String productName) { this.productName = productName; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
        public void setPrice(double price) { this.price = price; }

        @Override
        public String toString() {
            return "ID: " + productId + ", Name: " + productName +
                    ", Qty: " + quantity + ", Price: " + price;
        }
    }


    public static class Inventory {
        // HashMap chosen for O(1) average time lookup/add/update/delete by productId
        private Map<Integer, Product> products;

        public Inventory() {
            products = new HashMap<>();
        }

        // Add product - O(1) average
        public boolean addProduct(Product product) {
            if (products.containsKey(product.getProductId())) {
                System.out.println("Product ID already exists: " + product.getProductId());
                return false;
            }
            products.put(product.getProductId(), product);
            return true;
        }

        // Update product - O(1) average
        public boolean updateProduct(int productId, String name, int quantity, double price) {
            Product product = products.get(productId);
            if (product == null) {
                System.out.println("Product not found: " + productId);
                return false;
            }
            product.setProductName(name);
            product.setQuantity(quantity);
            product.setPrice(price);
            return true;
        }

        // Delete product - O(1) average
        public boolean deleteProduct(int productId) {
            if (!products.containsKey(productId)) {
                System.out.println("Product not found: " + productId);
                return false;
            }
            products.remove(productId);
            return true;
        }

        // Retrieve product - O(1) average
        public Product getProduct(int productId) {
            return products.get(productId);
        }

        // Display all products - O(n)
        public void displayAll() {
            if (products.isEmpty()) {
                System.out.println("Inventory is empty.");
                return;
            }
            for (Product p : products.values()) {
                System.out.println(p);
            }
        }
    }

        public static void main(String[] args) {
            Inventory inventory = new Inventory();

            // Add products
            inventory.addProduct(new Product(101, "Laptop", 10, 55000.0));
            inventory.addProduct(new Product(102, "Mouse", 50, 500.0));
            inventory.addProduct(new Product(103, "Keyboard", 30, 1200.0));

            System.out.println("---- Initial Inventory ----");
            inventory.displayAll();

            // Update a product
            inventory.updateProduct(102, "Wireless Mouse", 40, 750.0);

            System.out.println("\n---- After Update ----");
            inventory.displayAll();

            // Delete a product
            inventory.deleteProduct(103);

            System.out.println("\n---- After Delete ----");
            inventory.displayAll();

            // Retrieve a specific product
            System.out.println("\n---- Lookup Product 101 ----");
            System.out.println(inventory.getProduct(101));
        }


}

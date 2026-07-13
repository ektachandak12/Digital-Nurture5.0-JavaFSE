public class Exercise2 {

    // Product Class
    static class Product {

        int productId;
        String productName;
        String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public void display() {
            System.out.println("Product ID : " + productId);
            System.out.println("Product Name : " + productName);
            System.out.println("Category : " + category);
        }
    }

    // Linear Search Method
    public static Product linearSearch(Product[] products, int id) {

        for (int i = 0; i < products.length; i++) {
            if (products[i].productId == id) {
                return products[i];
            }
        }

        return null;
    }

    // Binary Search Method
    public static Product binarySearch(Product[] products, int id) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (products[mid].productId == id) {
                return products[mid];
            }

            else if (products[mid].productId < id) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        return null;
    }

    // Main Method
    public static void main(String[] args) {

        // Array for Linear Search (Unsorted)
        Product[] productList = {
                new Product(105, "Laptop", "Electronics"),
                new Product(101, "Shoes", "Footwear"),
                new Product(109, "Watch", "Accessories"),
                new Product(103, "Mobile", "Electronics"),
                new Product(107, "Bag", "Fashion")
        };

        // Sorted Array for Binary Search
        Product[] sortedProductList = {
                new Product(101, "Shoes", "Footwear"),
                new Product(103, "Mobile", "Electronics"),
                new Product(105, "Laptop", "Electronics"),
                new Product(107, "Bag", "Fashion"),
                new Product(109, "Watch", "Accessories")
        };

        int searchId = 107;

        // Linear Search
        System.out.println("===== Linear Search =====");

        Product result1 = linearSearch(productList, searchId);

        if (result1 != null) {
            System.out.println("Product Found");
            result1.display();
        } else {
            System.out.println("Product Not Found");
        }

        System.out.println();

        // Binary Search
        System.out.println("===== Binary Search =====");

        Product result2 = binarySearch(sortedProductList, searchId);

        if (result2 != null) {
            System.out.println("Product Found");
            result2.display();
        } else {
            System.out.println("Product Not Found");
        }
    }
}
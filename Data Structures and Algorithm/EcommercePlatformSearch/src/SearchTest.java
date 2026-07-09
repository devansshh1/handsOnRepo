import java.util.Arrays;

public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P105", "Wireless Mouse", "Electronics"),
            new Product("P101", "Gaming Laptop", "Electronics"),
            new Product("P104", "Mechanical Keyboard", "Electronics"),
            new Product("P102", "Office Desk", "Furniture"),
            new Product("P103", "Ergonomic Chair", "Furniture")
        };

        System.out.println("Running Linear Search:");
        Product foundLinear = SearchAlgorithms.linearSearch(products, "P104");
        if (foundLinear != null) {
            System.out.println("Result: " + foundLinear);
        } else {
            System.out.println("Result: Product not found");
        }

        System.out.println("\nSorting product array for binary search...");
        Arrays.sort(products);

        System.out.println("\nSorted Products:");
        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("\nRunning Binary Search:");
        Product foundBinary = SearchAlgorithms.binarySearch(products, "P104");
        if (foundBinary != null) {
            System.out.println("Result: " + foundBinary);
        } else {
            System.out.println("Result: Product not found");
        }
    }
}

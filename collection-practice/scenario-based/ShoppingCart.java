import java.util.*;

public class ShoppingCart {

    public static void main(String[] args) {

        // HashMap → product -> price
        Map<String, Integer> priceMap = new HashMap<>();

        // Maintains insertion order
        Map<String, Integer> cartOrder = new LinkedHashMap<>();

        addItem(priceMap, cartOrder, "Apple", 50);
        addItem(priceMap, cartOrder, "Milk", 30);
        addItem(priceMap, cartOrder, "Bread", 40);

        System.out.println("Cart (Insertion Order):");
        System.out.println(cartOrder);

        // Sorted by price
        TreeMap<Integer, List<String>> sortedByPrice = new TreeMap<>();

        for (Map.Entry<String, Integer> entry : priceMap.entrySet()) {
            sortedByPrice.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        System.out.println("\nCart (Sorted by Price):");
        System.out.println(sortedByPrice);
    }

    static void addItem(Map<String, Integer> priceMap, Map<String, Integer> cartOrder, String product, int price) {

        priceMap.put(product, price);
        cartOrder.put(product, price);
    }
}


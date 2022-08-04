package utils;

import model.Product;

import java.util.Map;

public class InventoryProvider {

    public static Map<String, Double> inventory = Map.of(
            "A001", 10.00,
            "A002", 20.00,
            "A003", 15.00,
            "A004", 30.00,
            "A005", 5.00,
            "A006", 25.00,
            "A007", 10.00
    );

    public static Product getProductById(String id) {
        return new Product(id, inventory.get(id));
    }
}

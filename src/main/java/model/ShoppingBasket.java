package model;

import discount.IDiscount;
import utils.DiscountsProvider;
import utils.InventoryProvider;

import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {

    Map<String, Item> items = new HashMap<>();

    public void scan(String productId) {
        if (items.containsKey(productId)) {
            items.get(productId).incrementQuantity();
        } else {
            Item item = new Item(InventoryProvider.getProductById(productId), 1);
            items.put(productId, item);
        }
    }

    public double calculateTotalPrice() {
        double sum = 0.0;
        Map<String, IDiscount> currentDiscounts = DiscountsProvider.getCurrentDiscounts();
        for (var entry : items.entrySet()) {
            var productId = entry.getKey();
            Item item = entry.getValue();
            if (currentDiscounts.containsKey(productId)) {
                sum += currentDiscounts.get(productId).applyDiscount(item);
            } else {
                sum += item.getPricePerUnit() * item.getQuantity();
            }
        }
        return sum;
    }

    public Map<String, Item> getItems() {
        return items;
    }
}

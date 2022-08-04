package utils;

import discount.BuyXGetYDeal;
import discount.IDiscount;
import discount.PercentageDiscount;

import java.util.Map;

public class DiscountsProvider {

    public static Map<String, IDiscount> currentDiscounts = Map.of(
            "A003", new BuyXGetYDeal(1, 2),
            "A004", new PercentageDiscount(10),
            "A005", new PercentageDiscount(20),
            "A007", new BuyXGetYDeal(2, 3)
    );

    public static Map<String, IDiscount> getCurrentDiscounts() {
        return currentDiscounts;
    }
}

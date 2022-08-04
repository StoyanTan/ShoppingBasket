package discount;

import model.Item;

public class PercentageDiscount implements IDiscount{

    private int percentage;

    public PercentageDiscount(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(Item item) {
        return item.getPricePerUnit() * item.getQuantity() * (100 - percentage) / 100;
    }
}

package discount;

import model.Item;

public class BuyXGetYDeal implements IDiscount {

    private int buy;
    private int get;

    public BuyXGetYDeal(int buy, int get){
        this.buy = buy;
        this.get = get;
    }

    @Override
    public double applyDiscount(Item item) {
        return item.getPricePerUnit() * Math.ceil((double) item.getQuantity() / get * buy);
    }
}

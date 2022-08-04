import model.Item;
import model.ShoppingBasket;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingBasketTest {

    @Test
    public void test_01_addItemToBasket() {
        var basket = new ShoppingBasket();
        String productId = "A001";
        basket.scan(productId);

        Item items = basket.getItems().get(productId);
        assertEquals(1, items.getQuantity());
    }

    @Test
    public void test_02_noDiscounts() {
        var basket = new ShoppingBasket();
        String productId1 = "A001";
        String productId6 = "A006";
        basket.scan(productId1);
        basket.scan(productId6);

        assertEquals(35.0, basket.calculateTotalPrice());

    }

    @Test
    public void test_03_addBuy1Get1Free(){
        var basket = new ShoppingBasket();
        String idBuy1Get1 = "A003";
        basket.scan(idBuy1Get1);
        basket.scan(idBuy1Get1);
        // Two products at the price for one
        assertEquals(15.0, basket.calculateTotalPrice());
        basket.scan(idBuy1Get1);
        // Three products at the price for two
        assertEquals(30.0, basket.calculateTotalPrice());
    }

    @Test
    public void test_04_addBuy2Get1Free(){
        var basket = new ShoppingBasket();
        String idBuy2Get3 = "A007";
        basket.scan(idBuy2Get3);
        basket.scan(idBuy2Get3);
        assertEquals(20.0, basket.calculateTotalPrice());
        basket.scan(idBuy2Get3);
        // Three products at the price for two
        assertEquals(20.0, basket.calculateTotalPrice());
        basket.scan(idBuy2Get3);
        // Four products at the price for three
        assertEquals(30.0, basket.calculateTotalPrice());
    }

    @Test
    public void test_05_tenPercentDiscount(){
        var basket = new ShoppingBasket();
        String idPercentage = "A004";
        basket.scan(idPercentage);
        assertEquals(27.0, basket.calculateTotalPrice());
    }

    @Test
    public void test_06_twentyPercentDiscount(){
        var basket = new ShoppingBasket();
        String idPercentage = "A005";
        basket.scan(idPercentage);
        assertEquals(4.0, basket.calculateTotalPrice());
    }

    @Test
    public void test_07_calculateTotalDifferentDiscounts(){
         var basket = new ShoppingBasket();
         var idNoDiscount = "A001";
         var idPercentage = "A004";
         var idBuy1Get1 = "A003";

         basket.scan(idNoDiscount);
         basket.scan(idPercentage);
         basket.scan(idBuy1Get1);
         basket.scan(idBuy1Get1);

         Map<String, Item> items = basket.getItems();
         assertEquals(1, items.get(idNoDiscount).getQuantity());
         assertEquals(1, items.get(idPercentage).getQuantity());
         assertEquals(2, items.get(idBuy1Get1).getQuantity());
         assertEquals(52.0, basket.calculateTotalPrice());
    }
}

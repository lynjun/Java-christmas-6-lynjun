package christmas;

import christmas.util.Menu;

import java.util.HashMap;
import java.util.Map;

public class Price {
    private final HashMap<Menu, Integer> order;
    private static int totalPrice = 0;

    public Price(HashMap<Menu, Integer> order) {
        this.order = order;
    }

    public int beforePrice(){
        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();
            totalPrice += menu.getPrice() * quantity;
        }
        return totalPrice;
    }

}

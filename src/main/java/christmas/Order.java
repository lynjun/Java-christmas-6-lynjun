package christmas;

import christmas.util.Menu;
import christmas.validate.Validation;

import java.util.HashMap;

public class Order {
    private static HashMap<Menu,Integer> orderedMenu = new HashMap<>();

    public Order(String[] menu) {
        orderedMenu = Validation.validatedMenu(menu);

    }

    public HashMap<Menu,Integer> getOrder(){
        return orderedMenu;
    }

}

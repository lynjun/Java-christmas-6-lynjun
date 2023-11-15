package christmas.validate;

import christmas.util.ErrorMessage;
import christmas.util.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Validation {
    public static void validateRange(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException(ErrorMessage.DATE_ERROR.getMessage());
        }
    }

    public static HashMap<Menu, Integer> validatedMenu(String[] menu) {
        HashMap<Menu, Integer> orderedMenu = new HashMap<>();
        for (String s : menu) {
            addToOrderedMenu(s, orderedMenu);
        }
        duplicatedMenu(menu.length, orderedMenu.size());
        validateCategory(orderedMenu);
        validateOrderOverCount(orderedMenu);
        return orderedMenu;
    }

    private static void addToOrderedMenu(String s, HashMap<Menu, Integer> orderedMenu) {
        String[] split = s.split("-");

        int quantity = validateOrderCount(split[1]);

        if (quantity <= 0) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMessage());
        }
        orderedMenu.put(Menu.valueOf(split[0]), quantity);
    }

    private static int validateOrderCount(String quantity){
        try {
            return Integer.parseInt(quantity);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMessage());
        }
    }

    private static void duplicatedMenu(int menuCnt, int OrderCnt) {
        if (menuCnt != OrderCnt) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMessage());
        }
    }

    private static void validateCategory(HashMap<Menu, Integer> orderMap) {

        List<String> category = new ArrayList<>();
        for (Menu menu : orderMap.keySet()) {
            category.add(menu.getCategory());
        }

        if (category.size() == 1 && category.get(0).equals("drink")) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMessage());
        }
    }

    private static void validateOrderOverCount(HashMap<Menu, Integer> orderedMenu) {
        int menuQuantity = 0;
        for (Integer value : orderedMenu.values()) {
            menuQuantity += value;
            if (menuQuantity > 20) {
                throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMessage());
            }
        }
    }
}
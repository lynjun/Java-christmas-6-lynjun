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
        HashMap<Menu, Integer> orderMap = new HashMap<>();
        for (String s : menu) {
            addTOrderMap(s, orderMap);
        }
        duplicatedMenu(menu.length, orderMap.size());
        validateCategory(orderMap);
        validateOrderOverCount(orderMap);
        return orderMap;
    }

    public static void addTOrderMap(String s, HashMap<Menu, Integer> orderMap) {
        String[] split = s.split("-");

        int quantity = validateOrderCount(split[1]);

        if (quantity <= 0) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMessage());
        }
        orderMap.put(Menu.valueOf(split[0]), quantity);
    }

    private static int validateOrderCount(String count){
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMessage());
        }
    }

    public static void duplicatedMenu(int menuCnt, int OrderCnt) {
        if (menuCnt != OrderCnt) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMessage());
        }
    }

    public static void validateCategory(HashMap<Menu, Integer> orderMap) {

        List<String> category = new ArrayList<>();
        for (Menu menu : orderMap.keySet()) {
            category.add(menu.getCategory());
        }

        if (category.size() == 1 && category.get(0).equals("drink")) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMessage());
        }
    }

    private static void validateOrderOverCount(HashMap<Menu, Integer> orderMap) {
        int sum = 0;
        for (Integer value : orderMap.values()) {
            sum += value;
            if (sum > 20) {
                throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMessage());
            }
        }
    }
}
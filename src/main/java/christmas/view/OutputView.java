package christmas.view;

import christmas.util.Menu;

import java.util.Map;

public class OutputView {

    public static void printOrderedMenu(Map<Menu, Integer> orderMap) {
        System.out.println("\n"+"<주문 메뉴>");

        for (Map.Entry<Menu, Integer> entry : orderMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + "개");
        }
    }

}

package christmas.service;

import christmas.Order;
import christmas.Price;
import christmas.model.Date;
import christmas.util.Menu;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.HashMap;


public class OrderService {

    static HashMap<Menu, Integer> orderedMenu;
    static int totalPrice;
    static Price price;

    public static int setDate() {
        String day = InputView.inputDate();
        try {
            Date date = new Date(day);
            return date.getDay();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setDate();
        }
    }

    public static HashMap<Menu, Integer> setMenu() {
        String[] menu = InputView.inputMenu();
        try {
            Order order = new Order(menu);
            orderedMenu = order.getOrder();
            return orderedMenu;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return setMenu();
        }
    }

    public static void printMenu(){
        OutputView.printOrderedMenu(orderedMenu);
    }

    public static int setBeforePrice() {
        price = new Price(orderedMenu);

        totalPrice = price.beforePrice();

        OutputView.printTotalPrice(totalPrice);

        return totalPrice;
    }

    public static void afterPrice(int totalDiscount) {
        OutputView.printAfterPrice(price.afterPrice(totalDiscount));
    }

}

package christmas.service;

import christmas.Order;
import christmas.Price;
import christmas.model.Date;
import christmas.util.Menu;
import christmas.view.OutputView;

import java.util.HashMap;

import static christmas.view.InputView.*;
import static christmas.view.OutputView.*;

public class OrderService {

    static HashMap<Menu, Integer> orderedMenu;
    static int totalPrice;
    static Price price;

    public static int setDate() {
        String day = inputDate();
        try {
            Date date = new Date(day);
            return date.getDay();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setDate();
        }
    }

    public static HashMap<Menu, Integer> setMenu() {
        String[] menu = inputMenu();
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

        printTotalPrice(totalPrice);

        return totalPrice;
    }

}

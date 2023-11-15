package christmas.controller;

import christmas.service.OrderService;
import christmas.util.Menu;

import java.util.HashMap;

public class OrderController {
    private int day;
    private HashMap<Menu,Integer> menu;

    public OrderController() {
        setMenu();
    }

    private void setMenu() {
        // 방문 날짜
        day = OrderService.setDate();
        // 주문할 메뉴와 개수
        menu = OrderService.setMenu();
    }
}
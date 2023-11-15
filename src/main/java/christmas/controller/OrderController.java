package christmas.controller;

import christmas.service.OrderService;

public class OrderController {
    private int day;

    public OrderController() {
        setMenu();
    }

    private void setMenu() {
        // 방문 날짜
        day = OrderService.setDate();
    }
}

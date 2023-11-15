package christmas.controller;

import christmas.service.DiscountService;
import christmas.service.OrderService;
import christmas.util.Menu;

import java.util.HashMap;

public class OrderController {
    private int day;
    private HashMap<Menu,Integer> menu;
    private int totalPrice;

    public OrderController() {
        setMenu();
    }

    private void setMenu() {
        // 방문 날짜
        day = OrderService.setDate();
        // 주문할 메뉴와 개수
        menu = OrderService.setMenu();
        // 주문된 메뉴 출력
        OrderService.printMenu();
        // 혜택 미리보기
        DiscountService.previewTheBenefits(day);
        //할인 전 총주문 금액, 증정 메뉴
        totalPrice = OrderService.setBeforePrice();
    }
}
package christmas.view;

import christmas.util.Menu;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    static DecimalFormat df = new DecimalFormat("###,###");

    private static final int eventPrice = 120000;

    public static void printOrderedMenu(Map<Menu, Integer> orderMap) {
        System.out.println("\n"+"<주문 메뉴>");

        for (Map.Entry<Menu, Integer> entry : orderMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + "개");
        }
    }

    public static void printBenefit(int day, String weekly,String dayOfTheWeek) {
        System.out.println("\n"+"12월 " + day+"일에 우테코 식당에서 받을 이벤트 혜택 미리보기!");
        if (day >= 1 && day <= 25) {
            System.out.println("크리스마스 디데이 할인");
        }

        if (weekly.equals("weekend")) {
            System.out.println("메인 메뉴 1개당 2023원 할인");
        }
        if (weekly.equals("weekday")) {
            System.out.println("디저트 메뉴 1개당 2023원 할인");
        }

        if(dayOfTheWeek.equals("Sun") || day==25){
            System.out.println("1000원 할인");
        }

        System.out.println("할인 전 총 주문금액이 12만원 이상일 시 샴페인 증정");
    }

    public static void printTotalPrice(int totalPrice) {
        System.out.println("\n"+"<할인 전 총주문 금액>");

        System.out.println(df.format(totalPrice) + "원");

        printEventMenu(totalPrice);
    }

    private static void printEventMenu(int totalPrice) {
        System.out.println("\n"+"<증정 메뉴>");

        if (totalPrice >= eventPrice) {
            System.out.println("샴페인 1개");
        }
        if (totalPrice < eventPrice) {
            System.out.println("없음");
        }
    }

    public static void printDdayDiscount(int dayDiscount) {
        System.out.println("\n"+"<혜택 내역>");

        if (dayDiscount > 0) {
            System.out.println("크리스마스 디데이 할인: -" + df.format(dayDiscount) + "원");
        }
    }

}

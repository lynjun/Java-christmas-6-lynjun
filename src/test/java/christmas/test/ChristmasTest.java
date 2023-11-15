package christmas.test;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.*;

import christmas.model.Date;
import christmas.service.DiscountService;
import christmas.util.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ChristmasTest extends NsTest {

    @Test
    public void 날짜_성공테스트() {
        Date date = new Date("1");

        int day = date.getDay();

        assertEquals(1,day);
    }

    @Test
    public void 날짜_예외테스트() {
        String date = "-1";

        assertThatThrownBy(() -> new Date(date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 중복 주문 시 예외발생")
    @Test
    public void 중복_주문_예외테스트() {
        String[] menu = "티본스테이크-1,티본스테이크-1".split(",");

        assertThatThrownBy(() -> new Order(menu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료만 주문 시 예외발생")
    @Test
    public void 음료_예외테스트() {
        String[] menu = "레드와인-1".split(",");

        assertThatThrownBy(() -> new Order(menu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("20개 이상 주문 시 예외 발생")
    @Test
    public void 주문_수량_예외테스트() {
        String[] menu = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1,해산물파스타-19".split(",");

        assertThatThrownBy(() -> new Order(menu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴판에 없는 메뉴 주문 시 예외발생")
    @Test
    public void 잘못된_주문_예외테스트() {
        String[] menu = "블루와인-1".split(",");

        assertThatThrownBy(() -> new Order(menu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("24일은 일요일 평일 이다.")
    @Test
    public void 평일_테스트() {
        Date date = new Date(24);

        String weekly = date.getWeekly();

        assertEquals("weekday",weekly);
    }

    @DisplayName("23일은 토요일 주말 이다.")
    @Test
    public void 주말_테스트() {
        Date date = new Date(23);

        String weekly = date.getWeekly();

        assertEquals("weekend",weekly);
    }

    @Test
    public void 크리스마스_디데이_할인_테스트() {
        int day = 24;
        int dayDiscount = DiscountService.dayDiscount(day);

        assertEquals(3300,dayDiscount);
    }

    @DisplayName("평일은 디저트 1개당 2023원 할인")
    @Test
    public void 평일_할인_테스트() {
        int day = 24;
        String[] menu = "티본스테이크-1,바비큐립-1,초코케이크-1,제로콜라-1".split(",");
        Order order = new Order(menu);
        HashMap<Menu, Integer> orderedMenu = order.getOrder();

        int weeklyDiscount = DiscountService.weeklyDiscount(orderedMenu, day);

        assertEquals(2023,weeklyDiscount);
    }

    @DisplayName("주말은 메인 메뉴 1개당 2023원 할인")
    @Test
    public void 주말_할인_테스트() {
        int day = 23;
        String[] menu = "티본스테이크-2,바비큐립-1,초코케이크-1,제로콜라-1".split(",");
        Order order = new Order(menu);
        HashMap<Menu, Integer> orderedMenu = order.getOrder();

        int weeklyDiscount = DiscountService.weeklyDiscount(orderedMenu, day);

        assertEquals(6069,weeklyDiscount);
    }

    @DisplayName("달력에 별 표시가 있으면 특별 할인")
    @Test
    public void 특별_할인_테스트() {
        int day = 10;
        int specialDiscount = DiscountService.specialDiscount(day);

        assertEquals(1000,specialDiscount);
    }

    @DisplayName("할인 전 총주문 금액이 12만원 이상 시 샴페인 증정")
    @Test
    public void 증정_이벤트_테스트() {
        String[] menu = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1".split(",");
        Order order = new Order(menu);
        HashMap<Menu, Integer> orderedMenu = order.getOrder();

        Price price = new Price(orderedMenu);
        int totalPrice = price.beforePrice();

        int giftEvent = DiscountService.giftEvent(totalPrice);

        assertEquals(25000,giftEvent);
    }

    @Test
    public void 총혜택_금액_테스트() {
        int day = 3;
        int dayDiscount = DiscountService.dayDiscount(day);

        String[] menu = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1".split(",");
        Order order = new Order(menu);
        HashMap<Menu, Integer> orderedMenu = order.getOrder();

        int weeklyDiscount = DiscountService.weeklyDiscount(orderedMenu, day);

        Price price = new Price(orderedMenu);
        int totalPrice = price.beforePrice();
        int giftEvent = DiscountService.giftEvent(totalPrice);

        int specialDiscount = DiscountService.specialDiscount(day);

        int totalAmountOfDiscount = dayDiscount + weeklyDiscount + giftEvent + specialDiscount;

        assertEquals(31246,totalAmountOfDiscount);
    }

    @Test
    public void 할인_후_예상_결제_금액_테스트() {
        int day = 3;
        int dayDiscount = DiscountService.dayDiscount(day);

        String[] menu = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1".split(",");
        Order order = new Order(menu);
        HashMap<Menu, Integer> orderedMenu = order.getOrder();

        int weeklyDiscount = DiscountService.weeklyDiscount(orderedMenu, day);

        Price price = new Price(orderedMenu);
        int totalPrice = price.beforePrice();
        int giftEvent = DiscountService.giftEvent(totalPrice);

        int specialDiscount = DiscountService.specialDiscount(day);

        int totalAmountOfDiscount = dayDiscount + weeklyDiscount + giftEvent + specialDiscount;

        assertEquals(31246,totalAmountOfDiscount);
    }

    @Test
    void 이벤트_배지_산트리_출력() {
        assertSimpleTest(() -> {
            run("2", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains("<12월 이벤트 배지>\n산타");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}

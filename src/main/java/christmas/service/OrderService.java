package christmas.service;

import christmas.Date;

import static christmas.view.InputView.*;

public class OrderService {

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

}

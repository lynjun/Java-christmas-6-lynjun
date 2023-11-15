package christmas.service;

import christmas.model.Date;
import christmas.util.Menu;
import christmas.view.OutputView;

import java.util.HashMap;

import static christmas.view.OutputView.*;

public class DiscountService {

    public static void previewTheBenefits(int day){
        Date date = new Date(day);
        String weekly = date.getWeekly();
        String dayOfTheWeek = date.getDayOfTheWeek();
        OutputView.printBenefit(day,weekly,dayOfTheWeek);
    }

    public static int dayDiscount(int day) {
        int dayDiscount = 0;
        if (day >= 1 && day <= 25) {
            dayDiscount = (day - 1) * 100 + 1000;
        }

        printDdayDiscount(dayDiscount);
        return dayDiscount;
    }

    public static int weeklyDiscount(HashMap<Menu, Integer> order, int day) {
        Date date = new Date(day);

        String dayCategory = date.getWeekly();
        String menuCategory = getTargetCategory(dayCategory);

        int dessertCount = countMenuByCategory(order, menuCategory);
        int weeklyDiscount = dessertCount * 2023;

        if (weeklyDiscount > 0) {
            OutputView.printDayOfWeekDiscount(weeklyDiscount, dayCategory);
        }

        return weeklyDiscount;
    }

    public static String getTargetCategory(String dayCategory) {
        if (dayCategory.equals("weekday")) {
            return "dessert";
        }
        if (dayCategory.equals("weekend")) {
            return "main";
        }
        return "";
    }

    private static int countMenuByCategory(HashMap<Menu, Integer> order, String category) {
        int dessertCount = 0;
        for (Menu menu : order.keySet()) {
            String menuCategory = menu.getCategory();
            if (menuCategory.equals(category)) {
                int quantity = order.get(menu);
                dessertCount += quantity;
            }
        }
        return dessertCount;
    }
}
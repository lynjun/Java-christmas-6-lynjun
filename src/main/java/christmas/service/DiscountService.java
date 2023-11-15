package christmas.service;

import christmas.Date;
import christmas.util.Menu;
import christmas.view.OutputView;

import java.util.HashMap;

public class DiscountService {

    private static final int specialPrice = 1000;
    private static final int giftPrice = 25000;
    private static final int eventPrice = 120000;

    public static void previewTheBenefits(int day){
        Date date = new Date();
        String weekly = date.getWeekly(day);
        String dayOfTheWeek = date.getDayOfTheWeek(day);
        OutputView.printBenefit(day,weekly,dayOfTheWeek);
    }

    public static int dayDiscount(int day) {
        int dayDiscount = 0;
        if (day >= 1 && day <= 25) {
            dayDiscount = (day - 1) * 100 + 1000;
        }

        OutputView.outputDdayDiscount(dayDiscount);
        return dayDiscount;
    }

    public static int weeklyDiscount(HashMap<Menu, Integer> order, int day) {
        Date date = new Date();

        String dayCategory = date.getWeekly(day);
        String targetCategory = getTargetCategory(dayCategory);

        int dessertCount = countMenuByCategory(order, targetCategory);
        int weeklyDiscount = dessertCount * 2023;

        if (weeklyDiscount > 0) {
            OutputView.outputDayOfWeekDiscount(weeklyDiscount, dayCategory);
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

    public static int specialDiscount(int day) {
        Date date = new Date();
        String dayOfTheWeek = date.getDayOfTheWeek(day);

        if (dayOfTheWeek.equals("Sun") || day == 25) {
            OutputView.outputSpecialDiscount(specialPrice);
            return specialPrice;
        }
        return 0;
    }

    public static int giftEvent(int totalPrice) {

        if (totalPrice >= eventPrice) {
            OutputView.outputGiftEvent(giftPrice);
            return giftPrice;
        }

        return 0;
    }

    public static int totalDiscount(int dayDiscount, int weeklyDiscount, int specialDiscount, int giftPrice) {
        int totalAmountOfDiscount = dayDiscount + weeklyDiscount + specialDiscount + giftPrice;

        OutputView.printDiscount(totalAmountOfDiscount);
        OutputView.printTotalDiscount(totalAmountOfDiscount);
        return totalAmountOfDiscount;
    }


}

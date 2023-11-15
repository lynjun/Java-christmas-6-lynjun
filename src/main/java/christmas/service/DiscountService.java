package christmas.service;

import christmas.model.Date;
import christmas.view.OutputView;

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
}
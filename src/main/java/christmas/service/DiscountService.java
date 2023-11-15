package christmas.service;

import christmas.model.Date;
import christmas.view.OutputView;

public class DiscountService {

    public static void previewTheBenefits(int day){
        Date date = new Date(day);
        String weekly = date.getWeekly();
        String dayOfTheWeek = date.getDayOfTheWeek();
        OutputView.printBenefit(day,weekly,dayOfTheWeek);
    }
}
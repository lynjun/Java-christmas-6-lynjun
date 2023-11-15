package christmas.model;

import christmas.util.Weekly;
import christmas.validate.Validation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Date {
    private int day;

    public Date(String date) {
        convertStringToInteger(date);
        Validation.validateRange(day);
    }

    public Date(int day) {
        this.day = day;
    }

    private void convertStringToInteger(String date) {
        try {
            day = Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public int getDay(){
        return day;
    }

    public String getWeekly(){
        LocalDate date = LocalDate.of(2023, 12, day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        String displayName = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US);

        Weekly weekly = Weekly.valueOf(displayName);

        return weekly.getWeekly();
    }

    public String getDayOfTheWeek(){
        LocalDate date = LocalDate.of(2023, 12, day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        return dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US);
    }

}
package christmas.model;


public class Date {
    private int day;

    public Date(String date) {
        convertStringToInteger(date);
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

}

package christmas.util;

public enum Weekly {
    Mon("weekday"),
    Tue("weekday"),
    Wed("weekday"),
    Thu("weekday"),
    Fri("weekend"),
    Sat("weekend"),
    Sun("weekday");

    private final String weekly;

    Weekly(String weekly) {
        this.weekly = weekly;
    }

    public String getWeekly() {
        return weekly;
    }

}

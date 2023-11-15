package christmas.util;

public enum Menu {
    양송이수프(6500,"appetizer"),
    타파스(5500,"appetizer"),
    시저샐러드(8000,"appetizer"),
    티본스테이크(55000,"main"),
    바비큐립(54000,"main"),
    해산물파스타(35000,"main"),
    크리스마스파스타(25000,"main"),
    초코케이크(15000,"dessert"),
    아이스크림(5000,"dessert"),
    제로콜라(3000,"drink"),
    레드와인(60000,"drink"),
    샴페인(25000,"drink");

    private final int price;
    private final String category;

    Menu(int price, String category) {
        this.price = price;
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}

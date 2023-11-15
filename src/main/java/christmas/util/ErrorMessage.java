package christmas.util;

public enum ErrorMessage {
    DATE_ERROR("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ORDER_ERROR("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String errorMessage;
    private static final String startErrorMessage = "[ERROR] ";


    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return startErrorMessage + this.errorMessage;
    }
}

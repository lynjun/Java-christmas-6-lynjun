package christmas.validate;

import christmas.util.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Validation {
    public static void validateRange(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
package springbook.user.domain;

import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

public enum Level {
    BASIC(1),
    SILVER(1),
    GOLD(1);

    int value;

    Level(int value) {
        this.value = value;
    }

    public int intValue() {
        return value;
    }

    public static Level valueOf(int value) {
        switch (value) {
            case 1: return BASIC;
            case 2: return SILVER;
            case 3: return GOLD;
            default:
                throw new AssertionError("Unknown Level:" + value);
        }
    }
}

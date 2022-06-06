package practice.chap09.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {

    @Test
    void validator() {
        String a1 = "abcd";
        Validator validator = new Validator(new IsAllLowerCase());;
        assertTrue(validator.validate(a1));
    }

    @Test
    void validator2() {
        String allNumber = "12";
        Validator validator = new Validator(new IsNumeric());
        assertTrue(validator.validate(allNumber));
    }

    @Test
    void validator3() {
        String a1 = "abcdd";
        Validator validator = new Validator((String s) -> s.matches("[a-z]+"));
        assertTrue(validator.validate(a1));
    }
}

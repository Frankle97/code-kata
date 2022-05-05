package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    StringCalculator cal;

    @BeforeEach
    public void before() {
        cal = new StringCalculator();
    }

    @Test
    @DisplayName("입력 문자열이 NULL 또는 빈 값이라면 0을 반환한다")
    public void inputNullOrEmptyThenReturnZero() {
        assertEquals(0, cal.add(null));
        assertEquals(0, cal.add(""));
        assertEquals(0, cal.add(" "));
    }

    @Test
    @DisplayName("입력 문자열에 음수가 있다면 RuntimeException 반환")
    public void negativeNumberThenThrowRuntimeException() {
        assertThrows(RuntimeException.class, () -> cal.add("1,2,-1"));
    }

    @Test
    @DisplayName("입력 문자열이 하나라면")
    public void inputSolo() {
        assertEquals(3, cal.add("3"));
    }

    @Test
    @DisplayName("쉼표 구분자")
    public void addDelimiterComma() {
        assertEquals(6, cal.add("2,4"));
        assertEquals(20, cal.add("9,11"));
    }

    @Test
    @DisplayName("콜론 구분자")
    public void addDelimiterColons() {
        assertEquals(6, cal.add("2:4"));
        assertEquals(20, cal.add("9:11"));
    }

    @Test
    @DisplayName("쉼표, 콜론 혼합 구분자")
    public void addDelimiterCommaAndColons() {
        assertEquals(10, cal.add("1,2:3:4"));
        assertEquals(10, cal.add("1:2:3,4"));
    }

    @Test
    @DisplayName("커스텀 구분자")
    public void addCustomDelimiter() {
        assertEquals(6, cal.add("//;\n1;2;3"));
    }

}
package practice.chap02;

import org.junit.jupiter.api.Test;

import java.util.List;

public class PrettyPrintAppleTest {
    public static void prettyPrintApple(List<Apple> inventory, ApplePrinter applePrinter) {
        for (Apple apple : inventory) {
            System.out.println(applePrinter.print(apple));
        }
    }

    @Test
    public void printApple() {
        List<Apple> apples = List.of(new Apple(100, "red"), new Apple(200, "green"));
        prettyPrintApple(apples, new AppleCalcWeightPrinter());
        prettyPrintApple(apples, new AppleWeightPrinter());
    }
}

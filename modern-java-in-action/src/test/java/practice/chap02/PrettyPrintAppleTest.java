package practice.chap02;

import org.junit.jupiter.api.Test;
import practice.apple.Apple;
import practice.apple.Apples;

import java.util.List;

public class PrettyPrintAppleTest {
    public static void prettyPrintApple(Apples apples, ApplePrinter applePrinter) {
        List<Apple> appleList = apples.apples();
        for (Apple apple : appleList) {
            System.out.println(applePrinter.print(apple));
        }
    }

    @Test
    public void printApple() {
        Apples apples = new Apples();
        prettyPrintApple(apples, new AppleCalcWeightPrinter());
        prettyPrintApple(apples, new AppleWeightPrinter());
    }
}

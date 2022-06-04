package practice.chap02;

public class AppleWeightPrinter implements ApplePrinter {
    @Override
    public String print(Apple apple) {
        String str = apple.weight() > 150 ? "heavy" : "light";
        return "A " + str + " " + apple.color() + " apple";
    }
}

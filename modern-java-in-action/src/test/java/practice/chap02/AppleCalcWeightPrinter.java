package practice.chap02;

public class AppleCalcWeightPrinter implements ApplePrinter {
    @Override
    public String print(Apple apple) {
        return "An apple of " + apple.weight() + "g";
    }
}

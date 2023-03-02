package practice.chap02.apple;

public class AppleWeightPrinter implements AppleFormatter {
    @Override
    public String print(Apple apple) {
        return "Weight is = " + apple.getWeight();
    }

}

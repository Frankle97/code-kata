package practice.chap02.apple;

public class AppleColorPrinter implements AppleFormatter{
    @Override
    public String print(Apple apple) {
        return "Color is = " + apple.getColor();
    }
}

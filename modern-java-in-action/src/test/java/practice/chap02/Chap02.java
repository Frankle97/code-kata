package practice.chap02;

import java.util.ArrayList;
import java.util.List;

import static practice.chap02.Chap02.Color.GREEN;
import static practice.chap02.Chap02.Color.RED;

public class Chap02 {

    private static class Apple {
        private Color color;

        public Apple(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "color=" + color +
                    '}';
        }
    }

    enum Color {
        RED, GREEN
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(GREEN));
        apples.add(new Apple(RED));
        List<Apple> result = filterGreenApples(apples);
        for (Apple apple : result) {
            System.out.println("apple = " + apple);
        }
    }

    private static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }


}

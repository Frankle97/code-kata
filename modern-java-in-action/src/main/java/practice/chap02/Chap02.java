package practice.chap02;

import practice.chap02.apple.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static practice.chap02.apple.Color.GREEN;
import static practice.chap02.apple.Color.RED;


public class Chap02 {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(RED, 350));
        apples.add(new Apple(GREEN, 150));
        apples.add(new Apple(RED, 220));
        apples.sort(Comparator.comparingInt(Apple::getWeight));
        for (Apple apple : apples) {
            System.out.println("apple = " + apple);
        }
    }

    private static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.print(apple);
            System.out.println(output);
        }
    }

    private static List<Apple> filterApplesByColor(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


}

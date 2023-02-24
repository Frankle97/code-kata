package practice.chap02;

import practice.chap02.apple.Apple;
import practice.chap02.apple.Color;

import java.util.ArrayList;
import java.util.List;

import static practice.chap02.apple.Color.GREEN;
import static practice.chap02.apple.Color.RED;


public class Chap02 {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(GREEN));
        apples.add(new Apple(RED));
        List<Apple> result = filterApplesByColor(apples, RED);
        for (Apple apple : result) {
            System.out.println("apple = " + apple);
        }
    }

    private static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }


}

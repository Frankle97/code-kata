package practice.chap03;

import org.junit.jupiter.api.Test;
import practice.apple.Apple;
import practice.apple.Apples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorTest {

    @Test
    public void appleComparator() {
        List<Apple> apples = new Apples().apples();
        List<String> collect = apples.stream()
            .filter(a -> a.weight() <= 100)
            .sorted(Comparator.comparingInt(Apple::weight))
            .map(Apple::color)
            .collect(Collectors.toList());

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(6);
        Integer reduce = list.stream().reduce(1, Integer::sum);
        System.out.println("reduce = " + reduce);
    }
}

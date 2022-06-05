package practice.chap03;

import org.junit.jupiter.api.Test;
import practice.apple.Apple;
import practice.apple.Apples;

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
        System.out.println("collect = " + collect);
    }
}

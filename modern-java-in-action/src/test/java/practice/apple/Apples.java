package practice.apple;

import java.util.List;

public class Apples {
    private final List<Apple> apples;

    public Apples() {
        this.apples = List.of(new Apple(100, "red"), new Apple(200, "green"));
    }

    public List<Apple> apples() {
        return apples;
    }
}

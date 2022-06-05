package practice.apple;

public class Apple {
    private final int weight;
    private final String color;

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public int weight() {
        return this.weight;
    }

    public String color() {
        return this.color;
    }

}

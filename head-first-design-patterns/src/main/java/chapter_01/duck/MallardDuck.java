package chapter_01.duck;

public class MallardDuck {

    private final Duck duck;

    public MallardDuck(Duck duck) {
        this.duck = duck;
    }

    public void performFly() {
        duck.performFly();
    }

    public void performQuack() {
        duck.performQuack();
    }
}

package chapter_01.duck;

import chapter_01.duck.fly.FlyWithWings;
import chapter_01.duck.quack.MuteQuack;

public class DuckApplication {
    public static void main(String[] args) {
        final MallardDuck mallardDuck = new MallardDuck(new FlyWithWings(), new MuteQuack());
        mallardDuck.performFly();
        mallardDuck.performQuack();
        mallardDuck.performFly();
    }
}

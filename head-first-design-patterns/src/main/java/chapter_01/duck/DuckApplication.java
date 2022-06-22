package chapter_01.duck;

import chapter_01.duck.fly.FlyNoWay;
import chapter_01.duck.quack.MuteQuack;

public class DuckApplication {
    public static void main(String[] args) {
        final MallardDuck mallardDuck = new MallardDuck(new Duck(new FlyNoWay(), new MuteQuack()));
        mallardDuck.performFly();
        mallardDuck.performQuack();
    }
}

package chapter_01.duck;

import chapter_01.duck.fly.FlyBehavior;
import chapter_01.duck.quack.QuackBehavior;

public class MallardDuck extends Duck {

    public MallardDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }

    @Override
    protected void performFly() {
        super.performFly();
    }
}

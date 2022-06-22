package chapter_01.duck;

import chapter_01.duck.fly.FlyBehavior;
import chapter_01.duck.quack.QuackBehavior;

public class RubberDuck extends Duck {
    public RubberDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }
}

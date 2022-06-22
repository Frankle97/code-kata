package chapter_01.duck.fly;

public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("날개짓을 하며 날아요.");
    }
}

package practice.chap09.observer;

public class ChosunTimes implements Observer{
    @Override
    public void notify(String feed) {
        System.out.println("ChosunTimes = " + feed);
    }
}

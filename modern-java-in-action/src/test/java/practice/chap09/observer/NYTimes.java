package practice.chap09.observer;

public class NYTimes implements Observer{
    @Override
    public void notify(String feed) {
        System.out.println("NYTimes = " + feed);
    }
}

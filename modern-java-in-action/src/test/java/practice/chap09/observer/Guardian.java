package practice.chap09.observer;

public class Guardian implements Observer{
    @Override
    public void notify(String feed) {
        System.out.println("Guardian = " + feed);
    }
}

package practice.chap09.observer;

import java.util.ArrayList;
import java.util.List;

public class Feed implements Subject {
    private final List<Observer> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void notifyToObservers(String feed) {
        observerList.forEach(v -> v.notify(feed));
    }
}

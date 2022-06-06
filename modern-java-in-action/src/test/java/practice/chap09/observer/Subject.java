package practice.chap09.observer;

public interface Subject {
    void registerObserver(Observer observer);
    void notifyToObservers(String feed);
}

package practice.chap09.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FeedTest {

    private Feed feed;

    @BeforeEach
    void setUp() {
        this.feed = new Feed();
        feed.registerObserver(new ChosunTimes());
        feed.registerObserver(new NYTimes());
        feed.registerObserver(new Guardian());
    }

    @Test
    void feed() {
        feed.notifyToObservers("피드");
    }

    @Test
    void feedLambda() {
        feed.registerObserver((String feed) -> System.out.println("언노운 = " + feed));
        feed.notifyToObservers("피드11");
    }
}

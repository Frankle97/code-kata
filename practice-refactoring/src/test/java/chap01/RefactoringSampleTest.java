package chap01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RefactoringSampleTest {

    private List<Performance> performances;
    private static Invoices invoices;
    private static Map<String, Play> plays;

    @BeforeEach
    void setUp() {
        performances = new ArrayList<>();
        performances.add(new Performance("hamlet", 55));
        performances.add(new Performance("as-like", 35));
        performances.add(new Performance("othello", 40));
        invoices = new Invoices("BigCo", performances);

        plays = new HashMap<>();
        plays.put("hamlet", new Play("Hamlet", "tragedy"));
        plays.put("as-like", new Play("As You Like It", "comedy"));
        plays.put("othello", new Play("Othello", "tragedy"));
    }

    @Test
    void isResultStringChanged() throws Exception {
        String result = "청구 내역 고객명 : BigCo\n" +
                "Hamlet: 65000원, 55석\n" +
                "As You Like It: 58000원, 35석\n" +
                "Othello: 50000원, 40석\n" +
                "총액: 173000원\n" +
                "적립 포인트: 47점\n";
        Assertions.assertEquals(result, RefactoringSample.statement(invoices, plays));
    }
}
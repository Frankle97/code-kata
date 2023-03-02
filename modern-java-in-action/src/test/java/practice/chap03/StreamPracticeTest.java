package practice.chap03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamPracticeTest {
    Trader raoul;
    Trader mario;
    Trader alan;
    Trader brian;

    List<Transaction> transactions;

    @BeforeEach
    void setUp() {
        this.raoul = new Trader("Raoul", "Cambridge");
        this.mario = new Trader("Mario", "Milan");
        this.alan = new Trader("Alan", "Cambridge");
        this.brian = new Trader("Brian", "Cambridge");

        this.transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    @Test
    @DisplayName("2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정렬")
    void quiz_1() {
        List<Transaction> list = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());

        List<Transaction> answer = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2011, 400));

        assertEquals(list, answer);
    }

    @Test
    @DisplayName("거래자가 근무하는 모든 도시를 중복 없이 나열")
    void quiz_2() {
        List<String> list = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());
        assertEquals(list, Arrays.asList("Cambridge", "Milan"));
    }

    @Test
    @DisplayName("케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬")
    void quiz_3() {
        List<Transaction> list = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .sorted(comparing(transactions -> transactions.getTrader().getName()))
                .collect(toList());

        assertEquals(list, Arrays.asList(
                new Transaction(alan, 2012, 950),
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400)
        ));
    }

    @Test
    @DisplayName("모든 거래자의 이름을 알파벳순으로 정렬하여 반환")
    void quiz_4() {
        List<Transaction> list = transactions.stream()
                .sorted(comparing(transaction -> transaction.getTrader().getName()))
                .collect(toList());

        assertEquals(list, Arrays.asList(
                new Transaction(alan, 2012, 950),
                new Transaction(brian, 2011, 300),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400)
        ));
    }

    @Test
    @DisplayName("밀라노에 거래자가 있는지 불리언 반환")
    void quiz_5() {
        boolean hasTraderInMilan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        assertTrue(hasTraderInMilan);
    }

    @Test
    @DisplayName("케임브리지에 거주하는 거래자의 모든 트랜잭션 값을 출력")
    void quiz_6() {
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("전체 트랜잭션 중 최댓값 구하기")
    void quiz_7() {
        Integer maxValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .orElseThrow(NoSuchElementException::new);

        assertEquals(maxValue, 1000);
    }

    @Test
    @DisplayName("전체 트랜잭션 중 최솟값 구하기")
    void quiz_8() {
        Integer minValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min)
                .orElseThrow(NoSuchElementException::new);

        assertEquals(minValue, 300);
    }

    @Test
    @DisplayName("전체 트랜잭션 값 합계 구하기")
    void quiz_9_additional() {
        Integer sumValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::sum)
                .orElseThrow(NoSuchElementException::new);

        assertEquals(sumValue, 4060);
    }
}

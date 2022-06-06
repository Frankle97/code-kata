package practice.chap05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

/**
 * 1. 2011년에 일어난 모든 트랜잭션을 찾아 오름차순으로 정리하시오.
 * 2. 거래자가 근무하는 모든 도시를 중복없이 나열하시오.
 * 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
 * 4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
 * 5. 밀라노에 거래자가 있는가?
 * 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
 * 7. 전체 트랜잭션 중 최댓값은 얼마인가?
 * 7. 전체 트랜잭션 중 최솟값은 얼마인가?
 */
public class StreamsAPITest {

    private List<Transaction> transactions;

    @BeforeEach
    void setUp() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alam", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2011, 710),
            new Transaction(mario, 2011, 700),
            new Transaction(alan, 2012, 950)
        );
    }

    @Test
    void case1() {
        List<Transaction> collect = transactions.stream()
            .filter(v -> v.getYear() == 2011)
            .sorted(comparingInt(Transaction::getValue))
            .collect(toList());
        print(collect);
    }

    @Test
    void case2() {
        List<String> collect = transactions.stream()
            .map(v -> v.getTrader().getCity())
            .distinct()
            .collect(toList());
        print(collect);
    }

    @Test
    void case3() {
        List<Transaction> collect = transactions.stream()
            .filter(v -> v.getTrader().getCity().equals("Cambridge"))
            .collect(toList());
        print(collect);
    }

    @Test
    void case4() {
        List<Transaction> collect = transactions.stream()
            .sorted(comparing(v -> v.getTrader().getName()))
            .collect(toList());
        print(collect);
    }

    @Test
    void case5() {
        boolean milan = transactions.stream()
            .anyMatch(v -> v.getTrader().getCity().equals("Milan"));
        System.out.println(milan);
    }

    @Test
    void case6() {
        List<Integer> cambridge = transactions.stream()
            .filter(v -> v.getTrader().getCity().equals("Cambridge"))
            .map(Transaction::getValue)
            .collect(toList());
        print(cambridge);
    }

    @Test
    void case7() {
        Integer reduce = transactions.stream()
            .map(Transaction::getValue)
            .reduce(0, Integer::max);
        System.out.println("reduce = " + reduce);
    }

    @Test
    void case8() {
        Optional<Integer> reduce = transactions.stream()
            .map(Transaction::getValue)
            .reduce((t1, t2) -> t1 < t2 ? t1 : t2);
        System.out.println("reduce = " + reduce.get());
    }

    @Test
    void getMaxMinValue() {
        long max = transactions.stream()
            .mapToLong(Transaction::getValue)
            .max()
            .orElse(0);

        int min = transactions.stream()
            .mapToInt(Transaction::getValue)
            .min()
            .orElse(0);

        System.out.println("max = " + max + ", min = " + min);
    }

    @Test
    void joiningString() {
        String collect = transactions.stream()
            .map(v -> v.getTrader().getName())
            .collect(joining(", "));
        System.out.println("collect = " + collect);
    }

    @Test
    void groupingByName() {
        Map<Integer, List<Transaction>> collect = transactions.stream()
            .collect(groupingBy(Transaction::getYear));
        System.out.println("collect = " + collect);

        Map<Integer, List<String>> listMap = transactions.stream()
            .collect(groupingBy(Transaction::getYear,
                mapping(v -> v.getTrader().getName(), toList())));
        System.out.println("listMap = " + listMap);

        Map<Integer, Transaction> collect1 = transactions.stream()
            .collect(groupingBy(Transaction::getYear,
                collectingAndThen(minBy(comparingInt(Transaction::getValue)), Optional::get)));
        System.out.println("collect1 = " + collect1);


    }

    @Test
    void groupingByValueLevel() {
        Map<String, List<Transaction>> collect = transactions.stream()
            .collect(groupingBy(
                v -> {
                    if (v.getValue() <= 500) return "low";
                    else if (v.getValue() >= 500) return "high";
                    else return "unknown";
                }));

        System.out.println("collect = " + collect);
    }


    private void print(List<?> collect) {
        for (Object transaction : collect) {
            System.out.println(transaction);
        }
    }
}

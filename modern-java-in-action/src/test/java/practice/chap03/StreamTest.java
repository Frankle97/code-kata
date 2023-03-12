package practice.chap03;

import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static org.junit.jupiter.api.Assertions.*;


class StreamTest {

    List<Dish> menu;
    List<Dish> specialMenu;

    @BeforeEach
    void setUp() {
        this.menu = asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beek", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        this.specialMenu = asList(
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER)
        );
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class 스트림_베이직 {

        @Test
        void 스트림을_사용하여_반복_코드_리팩토링() {
            // 기존 코드 (외부 반복)
            List<String> highCaloricDishes1 = new ArrayList<>();
            Iterator<Dish> iterator = specialMenu.iterator();
            while (iterator.hasNext()) {
                Dish dish = iterator.next();
                if (dish.getCalories() > 300) {
                    highCaloricDishes1.add(dish.getName());
                }
            }

            // Stream 활용 코드 (내부 반복)
            List<String> highCaloricDishes2 = specialMenu.stream()
                    .filter(dish -> dish.getCalories() > 300)
                    .map(Dish::getName)
                    .collect(toList());
            assertEquals(highCaloricDishes1, highCaloricDishes2);
        }

        @Test
        void 고유_요소_필터링() {
            List<Integer> numbers = asList(1, 2, 1, 3, 3, 2, 4);
            List<Integer> distinctNumbers = numbers.stream()
                    .filter(number -> number % 2 == 0)
                    .distinct()
                    .collect(toList());
            assertEquals(distinctNumbers, asList(2, 4));
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class 스트림_슬라이싱 {
        @Test
        void take_while() {
            List<Dish> filteredMenu = specialMenu.stream()
                    .filter(dish -> dish.getCalories() < 320)
                    .collect(toList());

            List<Dish> slicedMenu = specialMenu.stream()
                    .takeWhile(dish -> dish.getCalories() < 320)
                    .collect(toList());

            System.out.println("filteredMenu = " + filteredMenu);

            System.out.println("slicedMenu = " + slicedMenu);

            assertEquals(filteredMenu, slicedMenu);
        }

        @Test
        void quiz_5_1() {
            List<Dish> dishes = specialMenu.stream()
                    .filter(dish -> dish.getType() == Dish.Type.MEAT)
                    .limit(2)
                    .collect(toList());
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class 스트림_매핑 {
        @Test
        void map() {
            List<Integer> lengths = asList("Modern", "Java")
                    .stream()
                    .map(String::length)
                    .collect(toList());
            assertEquals(lengths, asList(6, 4));
        }

        @Test
        void flat_map() {
            List<String> words = asList("Hello", "World");
            List<String> strings = words.stream()
                    .map(word -> word.split(""))
                    .flatMap(Arrays::stream)
                    .distinct()
                    .collect(toList());
            assertEquals(strings, asList("H", "e", "l", "o", "W", "r", "d"));
        }

        @Test
        void quiz_5_2_1() {
            List<Integer> numbers = asList(1, 2, 3, 4, 5);
            List<Integer> squares = numbers.stream()
                    .map(n -> n * n)
                    .collect(toList());
            assertEquals(squares, asList(1, 4, 9, 16, 25));
        }

        @Test
        void quiz_5_2_3() {
            List<Integer> numbers1 = asList(1, 2, 3);
            List<Integer> numbers2 = asList(3, 4);
            List<int[]> pairs = numbers1.stream()
                    .flatMap(i -> numbers2.stream()
                            .map(j -> new int[]{i, j})
                    )
                    .collect(toList());
            System.out.println("pairs = " + pairs);
        }

        @Test
        void quiz_5_2_4() {
            List<Integer> numbers1 = asList(1, 2, 3);
            List<Integer> numbers2 = asList(3, 4);
            List<int[]> pairs = numbers1.stream()
                    .flatMap(i -> numbers2.stream()
                            .filter(j -> (i + j) % 3 == 0)
                            .map(j -> new int[]{i, j})
                    )
                    .collect(toList());
            System.out.println("pairs = " + pairs);
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class 스트림_리듀스 {
        List<Integer> numbers = asList(1, 2, 5, 10);

        @Test
        void sum() {
            Integer result = this.numbers.stream().reduce(0, Integer::sum);
            assertEquals(result, 18);
        }

        @Test
        void max() {
            Integer result = this.numbers.stream().reduce(0, Integer::max);
            assertEquals(result, 10);
        }

        @Test
        void min() {
            Integer result = this.numbers.stream().reduce(0, Integer::min);
            assertEquals(result, 0);
        }

        @Test
        void quiz_5_3() {
            long count = menu.stream()
                    .map(d -> 1)
                    .reduce(Integer::sum)
                    .orElseThrow(NoSuchElementException::new);
            assertEquals(count, menu.size());
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class 스트림_리듀싱과_요약 {
        @Test
        void 스트림값에서_최댓값과_최솟값_검색() {
            Dish dish = menu.stream()
                    .max(comparing(Dish::getCalories))
                    .orElseThrow(NoSuchFieldError::new);

            System.out.println("dish = " + dish.toString());
        }

        @Test
        void 요약_연산() {
            Integer totalLegacy = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
            System.out.println("totalLegacy = " + totalLegacy);

            int totalLegacy1 = menu.stream().mapToInt(Dish::getCalories).sum();
            System.out.println("totalLegacy1 = " + totalLegacy1);

            Integer total = menu.stream().collect(summingInt(Dish::getCalories));
            System.out.println("total = " + total);

            Double avg = menu.stream().collect(averagingInt(Dish::getCalories));
            System.out.println("avg = " + avg);

            IntSummaryStatistics summaryStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
            System.out.println("summaryStatistics = " + summaryStatistics);
        }

        @Test
        void 문자열_연결() {
            String joiningName = menu.stream().map(Dish::getName).collect(joining(", "));
            System.out.println("joiningName = " + joiningName);
        }

        @Test
        void 그룹화() {
            Map<Dish.Type, List<Dish>> collect = menu.stream().collect(groupingBy(Dish::getType));
            System.out.println("collect = " + collect);

            Map<CaloricLevel, List<Dish>> caloricLevelListMap = menu.stream().collect(
                    groupingBy(dish -> {
                        if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                        if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                        else return CaloricLevel.FAT;
                    }));
            System.out.println("caloricLevelListMap = " + caloricLevelListMap);
        }

        @Test
        void 그룹화된_요소_조작() {
            Map<Dish.Type, List<Dish>> map = menu.stream()
                    .filter(dish -> dish.getCalories() > 700)
                    .collect(groupingBy(Dish::getType));
            System.out.println("map = " + map);

            Map<Dish.Type, List<Dish>> collect = menu.stream()
                    .collect(groupingBy(Dish::getType, filtering(dish -> dish.getCalories() > 700, toList())));
            System.out.println("collect = " + collect);

            Map<Dish.Type, List<String>> collect1 = menu.stream()
                    .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
            System.out.println("collect1 = " + collect1);

            Map<Dish.Type, Integer> collect2 = menu.stream()
                    .collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
            System.out.println("collect2 = " + collect2);

            Map<Dish.Type, Set<CaloricLevel>> collect3 = menu.stream()
                    .collect(groupingBy(
                            Dish::getType, mapping(dish -> {
                                if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                else return CaloricLevel.FAT;
                            }, toSet())
                    ));
            System.out.println("collect3 = " + collect3);
        }

        @Test
        void 분할() {
            Map<Boolean, List<Dish>> collect = menu.stream().collect(partitioningBy(Dish::isVegetarian));
            System.out.println("collect = " + collect);

            Map<Boolean, Dish> collect1 = menu.stream()
                    .collect(partitioningBy(Dish::isVegetarian, collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
            System.out.println("collect1 = " + collect1);

            Map<Boolean, Map<Boolean, List<Dish>>> collect2 = menu.stream()
                    .collect(partitioningBy(Dish::isVegetarian,
                            partitioningBy(d -> d.getCalories() > 500)));
            System.out.println("collect2 = " + collect2);

            Map<Boolean, List<Integer>> collect3 = partitionPrimes(10);
            System.out.println("collect3 = " + collect3);
        }

        private boolean isPrime(int candidate) {
            int candidateRoot = (int) Math.sqrt((double) candidate);
            return IntStream.rangeClosed(2, candidateRoot)
                    .noneMatch(i -> candidate % i == 0);
        }

        private Map<Boolean, List<Integer>> partitionPrimes(int n) {
            return IntStream.rangeClosed(2, n).boxed()
                    .collect(partitioningBy(candidate -> isPrime(candidate)));
        }
    }

    private enum CaloricLevel {
        DIET,
        NORMAL,
        FAT
    }


}

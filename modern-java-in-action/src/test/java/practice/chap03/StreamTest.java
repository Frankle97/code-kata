package practice.chap03;

import org.junit.jupiter.api.*;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
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


}

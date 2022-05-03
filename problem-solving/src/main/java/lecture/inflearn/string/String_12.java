package lecture.inflearn.string;

import java.util.Scanner;

public class String_12 {
    private static final int MAX_COUNT = 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String next = sc.next();
        System.out.println(solution2(next, count));
    }

    private static String solution1(String next, int count) {
        StringBuilder sb = new StringBuilder();
        String[] strings = new String[count];
        for (int i = 1, j = 0; i <= count; i++, j++) {
            strings[j] = next.substring((j * MAX_COUNT), (i * MAX_COUNT));
        }

        for (String string : strings) {
            char[] chars = string.toCharArray();
            StringBuilder tmp = new StringBuilder();
            for (char aChar : chars) {
                if (aChar == '#') {
                    tmp.append("1");
                } else {
                    tmp.append('0');
                }
            }
            sb.append(Character.toString(Integer.valueOf(tmp.toString(), 2)));
        }

        return sb.toString();
    }

    private static String solution2(String next, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            String tmp = next.substring(0, MAX_COUNT)
                .replace('#', '1')
                .replace('*', '0');
            sb.append((char) Integer.parseInt(tmp, 2));
            next = next.substring(MAX_COUNT);
        }

        return sb.toString();
    }
}

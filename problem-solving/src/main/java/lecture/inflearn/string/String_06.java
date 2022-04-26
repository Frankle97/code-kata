package lecture.inflearn.string;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class String_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        System.out.println(solution2(line));
    }

    private static String solution1(String line) {
        Set<String> set = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = line.toCharArray();
        for (char aChar : chars) {
            set.add(String.valueOf(aChar));
        }
        for (String s : set) {
            sb.append(s);
        }
        return sb.toString();
    }

    private static String solution2(String line) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            if (line.indexOf(line.charAt(i)) == i) {
                sb.append(line.charAt(i));
            }
        }
        return sb.toString();
    }
}

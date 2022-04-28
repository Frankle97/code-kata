package lecture.inflearn.string;

import java.util.Scanner;

public class String_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution1(str));
    }

    private static String solution(String str) {
        int length = str.length();
        str = str.toUpperCase();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt((length - i - 1))) {
                return "NO";
            }
        }
        return "YES";
    }

    private static String solution1(String str) {
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(tmp)) {
            return "YES";
        }
        return "NO";
    }
}

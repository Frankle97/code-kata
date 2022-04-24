package lecture.inflearn.string;

import java.util.Scanner;

public class String_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution2(str));
    }

    private static String solution1(String str) {
        char[] chars = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;
        while (lt < rt) {
            int ascii = chars[lt];
            if (ascii >= 65 && ascii <= 122) {
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
            }
            lt++;
            rt--;
        }
        return String.valueOf(chars);
    }

    private static String solution2(String str) {
        char[] s = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;
        if (lt < rt) {
            if (!Character.isAlphabetic(s[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(s[rt])) {
                rt--;
            } else {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }
        return String.valueOf(s);
    }
}
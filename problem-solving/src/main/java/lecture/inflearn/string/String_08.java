package lecture.inflearn.string;

import java.util.Scanner;

public class String_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(solution2(input));
    }

    private static String solution2(String str) {
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String s = new StringBuilder(str).reverse().toString();
        if (str.equals(s)) {
            return "YES";
        }
        return "NO";
    }
}

package lecture.inflearn.string;

import java.util.Scanner;

public class String_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        System.out.println(solution(str, c));
    }

    public static int solution(String str, char c) {
        int count = 0;
        for (char s : str.toCharArray()) {
            if (Character.toUpperCase(s) == Character.toUpperCase(c)) {
                count++;
            }
        }
        return count;
    }
}

package lecture.inflearn.string;

import java.util.Scanner;

public class String_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        String[] split = next.split(" ");
        System.out.println(solution1(split[0], split[1].charAt(0)));
    }

    private static String solution1(String s, char c) {
        StringBuilder sb = new StringBuilder();
        int[] answer = new int[s.length()];
        int p = 1000;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                p = 0;
            } else {
                p++;
            }
            answer[i] = p;
        }
        p = 1000;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }

        for (int j : answer) {
            sb.append(j).append(" ");
        }

        return sb.toString();
    }
}

package lecture.inflearn.string;

import java.util.Scanner;

public class String_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        System.out.println(solution1(next));
    }

    private static String solution1(String next) {
        next += " ";
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < next.length(); i++) {
            if (count == 1) {
                sb.append(next.charAt(i));
            }
            if (i == next.length() - 1) {
                sb.append(count);
                break;
            }
            if (next.charAt(i) == next.charAt(i + 1)) {
                count++;
            } else if (count != 1 && next.charAt(i) != next.charAt(i + 1)) {
                sb.append(count);
                count = 1;
            }
        }

        return sb.toString();
    }

    private static String solution2(String next) {
        String answer = "";
        next = next + " ";
        int count = 0;
        for (int i = 0; i < next.length(); i++) {
            if (next.charAt(i) == next.charAt(i + 1)) {
                count++;
            } else {
                answer += next.charAt(i);
                if (count > 1) {
                    answer += String.valueOf(count);
                    count = 1;
                }
            }
        }
        return answer;
    }
}

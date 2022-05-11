package lecture.inflearn.array;

import java.util.Scanner;

public class Array_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < scores.length; i++) {
            scores[i] =sc.nextInt();
        }
        System.out.println(solution(scores, n));
    }

    private static String solution(int[] scores, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int rank = 1;
            int score = scores[i];
            for (int j = 0; j < scores.length; j++) {
                if (score < scores[j]) {
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }
        return sb.toString();
    }
}

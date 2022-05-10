package lecture.inflearn.array;

import java.util.Scanner;

public class Array_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        System.out.println(solution(input));
    }

    private static int solution(int[] input) {
        int score = 0;
        int points = 0;
        for (int i : input) {
            if (i == 1) {
                points += 1;
                score += points;
            } else if (i == 0) {
                points = 0;
            }
        }
        return score;
    }
}

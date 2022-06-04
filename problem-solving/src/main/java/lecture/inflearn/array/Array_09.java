package lecture.inflearn.array;

import java.util.Scanner;

public class Array_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, arr));
    }

    private static int solution(int n, int[][] arr) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
            if (max < sum) {
                max = sum;
            }
            sum = 0;

            for (int k = 0; k < arr[i].length; k++) {
                sum += arr[k][i];
            }
            if (max < sum) {
                max = sum;
            }
            sum = 0;

            for (int p = 0; p < arr[i].length; p++) {
                sum += arr[p][p];
            }
            if (max < sum) {
                max = sum;
            }
            sum = 0;

            for (int u = n; u > arr[i].length; u--) {
                sum += arr[u][u];
            }
            if (max < sum) {
                max = sum;
            }
        }

        return max;
    }
}

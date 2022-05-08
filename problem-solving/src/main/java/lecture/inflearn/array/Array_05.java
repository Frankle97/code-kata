package lecture.inflearn.array;

import java.util.Scanner;

public class Array_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int cnt = 0;
        int[] arr = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                cnt++;
                for (int j = 0; j <= n; j += i) {
                    arr[j] = 1;
                }
            }
        }
        return cnt;
    }
}

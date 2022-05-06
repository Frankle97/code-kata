package lecture.inflearn.array;

import java.util.Scanner;

public class Array_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    private static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int tmp1 = 1;
        int tmp2 = 1;
        sb.append(tmp1).append(" ");
        sb.append(tmp2).append(" ");
        for (int i = 2; i < n; i++) {
            int tmp3 = tmp1 + tmp2;
            sb.append(tmp3).append(" ");
            tmp1 = tmp2;
            tmp2 = tmp3;
        }
        return sb.toString();
    }
}

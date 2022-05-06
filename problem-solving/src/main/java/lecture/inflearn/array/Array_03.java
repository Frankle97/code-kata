package lecture.inflearn.array;

import java.util.Scanner;

public class Array_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] first = new int[n];
        int[] second = new int[n];
        for (int i = 0; i < n; i++) {
            first[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            second[i] = sc.nextInt();
        }
        System.out.println(solution1(n, first, second));
    }

    private static String solution1(int n, int[] first, int[] second) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int a = first[i];
            int b = second[i];
            if (a == b) {
                sb.append("D");
            } else if (a == 1 && b == 3) {
                sb.append("A");
            } else if (a == 2 && b == 1) {
                sb.append("A");
            } else if (a == 3 && b == 2) {
                sb.append("A");
            } else {
                sb.append("B");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

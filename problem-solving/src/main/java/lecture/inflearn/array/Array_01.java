package lecture.inflearn.array;

import java.util.Scanner;

public class Array_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] intArray = new int[n];
        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            intArray[i] = Integer.parseInt(s[i]);
        }
        System.out.println(solution1(intArray));
    }

    private static String solution1(int[] intArray) {
        StringBuilder sb = new StringBuilder();
        sb.append(intArray[0]).append(" ");
        for (int i = 1; i < intArray.length; i++) {
            int prevNum = intArray[i - 1];
            int currentNum = intArray[i];
            if (currentNum >= prevNum) {
                sb.append(currentNum).append(" ");
            }
        }
        return sb.toString();
    }
}

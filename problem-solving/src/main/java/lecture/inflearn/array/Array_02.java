package lecture.inflearn.array;

import java.util.Scanner;

public class Array_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] intArray = new int[n];
        for (int i = 0; i < n; i++) {
            intArray[i] = sc.nextInt();
        }
        System.out.println(solution1(intArray, n));
    }

    private static int solution1(int[] intArray, int n) {
        int count = 1;
        int longestNum = intArray[0];
        for (int i = 1; i < n; i++) {
            int currentNum = intArray[i];
            if (currentNum > longestNum) {
                longestNum = currentNum;
                count++;
            }
        }
        return count;
    }


}

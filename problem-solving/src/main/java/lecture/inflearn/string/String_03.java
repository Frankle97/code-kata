package lecture.inflearn.string;

import java.util.Scanner;

public class String_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.nextLine()));
    }

    private static String solution(String str) {
        String[] strArr = str.split(" ");
        int k = 0;
        int length = 0;
        for (int i = 0; i < strArr.length; i++) {
            int strLength = strArr[i].length();
            if (length < strLength) {
                k = i;
                length = strLength;
            }
        }
        return strArr[k];
    }
}

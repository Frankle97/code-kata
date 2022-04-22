package lecture.inflearn.string;

import java.util.Scanner;

public class String_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String[] arr = getArr(sc, count);
        System.out.println(solution3(arr));
    }

    private static String[] getArr(Scanner sc, int count) {
        String[] arr = new String[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }
        return arr;
    }

    private static String solution1(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            for (int j = str.length() - 1; j >= 0; j--) {
                sb.append(str.charAt(j));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String solution2(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            String str = new StringBuilder(s).reverse().toString();
            sb.append(str).append("\n");
        }
        return sb.toString();
    }

    private static String solution3(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            char[] chars = s.toCharArray();
            int lt = 0; // 문자의 first index
            int rt = s.length() - 1;    //문자의 last index
            while (lt < rt) {
                char tmp = chars[lt];   // 마지막 요소를 임시 char에 넣는다.
                chars[lt] = chars[rt]; // 문자 배열의 마지막 요소를 첫번째 공간에 대입한다.
                chars[rt] = tmp; // 문자 배열의 첫번째 요소를 마지막 공간에 대입한다.
                lt++;   // first index +1
                rt--;   // last index +
            }
            sb.append(String.valueOf(chars)).append("\n");
        }
        return sb.toString();
    }

}

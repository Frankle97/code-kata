package lecture.inflearn.string;

import java.util.Scanner;

public class String_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        String[] split = next.split(" ");
        System.out.println(solution1(split[0], split[1]));
    }

    private static String solution1(String line, String e) {
        StringBuilder sb = new StringBuilder();
        char point = e.charAt(0);
        char[] charArray = line.toCharArray();
        int[] intArray = new int[line.length()];
        int tmp = 0;
        for (int i = 0; i < charArray.length; i++) {
            int count = 0;
            for (int j = tmp; j < charArray.length; j++) {
                char c = charArray[j];
                if (point == c) {
                    tmp = j;
                    if (count == 0) {
                        tmp++;
                    }
                    intArray[i] = count;
                    break;
                } else {
                    count++;
                }
            }
        }
        for (int j : intArray) {
            sb.append(j).append(" ");
        }

        return sb.toString();
    }
}

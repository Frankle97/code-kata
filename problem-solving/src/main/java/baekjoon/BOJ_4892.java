package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4892 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n0 = Integer.parseInt(st.nextToken());
            if (n0 == 0) break;

            int n1 = 3 * n0;
            boolean even = n1 % 2 == 0;
            int n2;
            if (even) {
                n2 = n1 / 2;
            } else {
                n2 = (n1 + 1) / 2;
            }
            int n3 = 3 * n2;
            int n4 = n3 / 9;
            if (even) {
                sb.append(count++).append(".").append(" even ").append(n4).append("\n");
            } else {
                sb.append(count++).append(".").append(" odd ").append(n4).append("\n");
            }
        }
        System.out.print(sb);
    }
}

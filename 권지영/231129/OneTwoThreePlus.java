import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * 2023.11.29
 * BAEKJOON 9095번:1, 2, 3 더하기
 * 메모리 : 14196 KB
 * 시간 : 120 ms
 * */

public class OneTwoThreePlus {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int max = 3;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if (max < n) max = n;
            list.add(n);
        }

        int[] dp = new int[max + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < max + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int n : list) {
            sb.append(dp[n]).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
import java.io.*;
import java.util.Arrays;

/*
 * 2023.11.15
 * BAEKJOON 1912번:연속합
 * 메모리 : 25652 KB
 * 시간 : 284 ms
 * */

public class ContinuousSum {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        int[] arr = new int[n];
        int[] maxSum = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }

        maxSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxSum[i] = Math.max(maxSum[i - 1] + arr[i], arr[i]);
        }

        bw.write(Arrays.stream(maxSum).max().getAsInt() + "");

        br.close();
        bw.close();
    }
}

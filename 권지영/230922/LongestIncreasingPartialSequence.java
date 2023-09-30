import java.io.*;
import java.util.Arrays;

/*
 * 2023.09.22
 * BAEKJOON 11053:가장 긴 증가하는 부분 수열
 * 메모리 : 14724 KB
 * 시간 : 148 ms
 * */

public class LongestIncreasingPartialSequence {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        int[] a = new int[n + 1];
        int[] subA = new int[n + 1];
        a[0] = 0;
        for (int i = 0; i < n; i++) {
            a[i + 1] = Integer.parseInt(strs[i]);
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) subA[i] = Math.max(subA[j] + 1, subA[i]);
            }
        }
        Arrays.sort(subA);
        bw.write(subA[n] + "");
        br.close();
        bw.close();
    }
}
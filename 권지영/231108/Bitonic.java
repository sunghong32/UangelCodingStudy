import java.io.*;
import java.util.Arrays;

/*
 * 2023.11.08
 * BAEKJOON 11054번:가장 긴 바이토닉 부분 수열
 * 메모리 : 16644 KB
 * 시간 : 156 ms
 * */

public class Bitonic {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(str[i]);
        }
        int[] left = new int[n];
        int[] right = new int[n];
        int[] total = new int[n];

        for (int i = 0; i < n; i++) {
            left[i] = 1;

            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && left[i] < left[j] + 1) {
                    left[i] = left[j] + 1;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            right[i] = 1;

            for (int j = n - 1; j > i; j--) {
                if (a[j] < a[i] && right[i] < right[j] + 1) {
                    right[i] = right[j] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            total[i] = left[i] + right[i] - 1;
        }

        bw.write(Arrays.stream(total).max().getAsInt() + "");
        br.close();
        bw.close();
    }
}

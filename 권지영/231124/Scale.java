import java.io.*;
import java.util.Arrays;

/*
 * 2023.11.24
 * BAEKJOON 2437번:저울
 * 메모리 : 14472 KB
 * 시간 : 136 ms
 * */

public class Scale {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(strs[i]);
        }
        Arrays.sort(weight);

        int total = 1;
        for (int i = 0; i < n; i++) {
            if (total < weight[i]) break;
            total += weight[i];
        }

        bw.write(total + "");
        br.close();
        bw.close();
    }
}
import java.io.*;

/*
 * 2023.12.04
 * BAEKJOON 25644번:최대 상승
 * 메모리 : 38624 KB
 * 시간 : 384 ms
 * */

public class MaximumRise {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        int[] stocks = new int[n];
        for (int i = 0; i < n; i++) {
            stocks[i] = Integer.parseInt(strs[i]);
        }
        int min = stocks[0];
        int benefit = 0;

        for (int i = 1; i < n; i++) {
            int temp = stocks[i];
            if(min>temp) min = temp;
            else if(benefit < temp-min) benefit = temp-min;
        }
        bw.write(benefit+"");
        br.close();
        bw.close();
    }
}
import java.io.*;

/*
 * 2023.12.29
 * BAEKJOON 1007번:벡터 매칭
 * 메모리 : 16420 KB
 * 시간 : 240 ms
 * */

public class VectorMatching {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static double answer;
    static int[][] point;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        String[] strs;
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            point = new int[n][2];
            int sumX = 0, sumY = 0;
            for (int j = 0; j < n; j++) {
                strs = br.readLine().split(" ");
                int x = Integer.parseInt(strs[0]);
                int y = Integer.parseInt(strs[1]);
                point[j][0] = x;
                point[j][1] = y;
                sumX += x;
                sumY += y;
            }
            answer = Double.MAX_VALUE;
            getVector(0, 0, sumX, sumY);
            bw.write(answer+"\n");
        }
        br.close();
        bw.close();
    }

    static void getVector(int cnt, int prev, int x, int y) {
        if (cnt == n / 2) {
            answer = Math.min(answer, Math.sqrt((double) x * x + (double) y * y));
            return;
        }
        for (int i = prev; i < n; i++)
            getVector(cnt + 1, i + 1, x - 2 * point[i][0], y - 2 * point[i][1]);
    }
}
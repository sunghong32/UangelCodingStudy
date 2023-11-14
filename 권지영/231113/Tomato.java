import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 2023.11.13
 * BAEKJOON 7576번:토마토
 * 메모리 : 149944 KB
 * 시간 : 1024 ms
 * */

public class Tomato {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<int[]> queue = new LinkedList<>();
    static int m, n;
    static String[][] box;

    public static void main(String[] args) throws IOException {
        String[] strs = br.readLine().split(" ");
        m = Integer.parseInt(strs[0]);
        n = Integer.parseInt(strs[1]);
        box = new String[n][m];
        for (int i = 0; i < n; i++) {
            strs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                box[i][j] = strs[j];
                if (strs[j].equals("1")) queue.add(new int[]{i, j, 0});
            }
        }

        getDay();
        br.close();
        bw.close();

    }

    static void getDay() throws IOException {
        int day = 0;
        while (!queue.isEmpty()) {
            int[] oneXY = queue.poll();
            int x = oneXY[0];
            int y = oneXY[1];
            day = oneXY[2];
            for (int i = 0; i < 4; i++) {
                int tx = x, ty = y;
                if (i == 0) tx = tx + 1;
                else if (i == 1) tx = tx - 1;
                else if (i == 2) ty = ty + 1;
                else ty = ty - 1;

                if (tx < 0 || ty < 0 || tx >= n || ty >= m) continue;
                if (box[tx][ty].equals("0")) {
                    box[tx][ty] = "1";
                    queue.add(new int[]{tx, ty, day + 1});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j].equals("0")) {
                    bw.write("-1");
                    return;
                }
            }
        }

        bw.write(day + "");
    }
}
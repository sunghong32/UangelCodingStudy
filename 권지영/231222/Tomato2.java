import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 2023.12.22
 * BAEKJOON 7569번:토마토
 * 메모리 : 147576 KB
 * 시간 : 972 ms
 * */

public class Tomato2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<int[]> queue = new LinkedList<>();
    static int m, n, h;
    static String[][][] box;

    public static void main(String[] args) throws IOException {
        String[] strs = br.readLine().split(" ");
        m = Integer.parseInt(strs[0]);
        n = Integer.parseInt(strs[1]);
        h = Integer.parseInt(strs[2]);
        box = new String[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                strs = br.readLine().split(" ");
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = strs[k];
                    if (strs[k].equals("1")) queue.add(new int[]{i, j, k, 0});
                }
            }
        }

        getDay();
        br.close();
        bw.close();

    }

    static void getDay() throws IOException {
        int day = 0;
        while (!queue.isEmpty()) {
            int[] oneXYZ = queue.poll();
            int z = oneXYZ[0];
            int x = oneXYZ[1];
            int y = oneXYZ[2];
            day = oneXYZ[3];
            for (int i = 0; i < 6; i++) {
                int tx = x, ty = y, tz = z;
                if (i == 0) tx = tx + 1;
                else if (i == 1) tx = tx - 1;
                else if (i == 2) ty = ty + 1;
                else if (i == 3) ty = ty - 1;
                else if (i == 4) tz = tz + 1;
                else tz = tz - 1;

                if (tx < 0 || ty < 0 || tz < 0 || tx >= n || ty >= m || tz >= h) continue;
                if (box[tz][tx][ty].equals("0")) {
                    box[tz][tx][ty] = "1";
                    queue.add(new int[]{tz, tx, ty, day + 1});
                }
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k].equals("0")) {
                        bw.write("-1");
                        return;
                    }
                }
            }
        }

        bw.write(day + "");
    }
}
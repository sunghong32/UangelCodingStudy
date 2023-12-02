import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

/*
 * 2023.12.01
 * BAEKJOON 1194번:달이 차오른다, 가자.
 * 메모리 : 16912 KB
 * 시간 : 160 ms
 * */

public class MoonRisingLetsGo {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] maze;
    private static int[] dx = {-1, 0, 0, 1};
    private static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        maze = new char[n][m];
        Pos start = null;
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                char cur = chars[j];
                if (cur == '0') start = new Pos(i, j, 0, 0);
                maze[i][j] = cur;
            }
        }

        boolean[][][] isVisit = new boolean[64][n][m];
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(start);
        isVisit[0][start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tx = cur.x + dx[i];
                int ty = cur.y + dy[i];
                int cnt = cur.cnt + 1;
                int key = cur.key;

                if (tx < 0 || tx >= n || ty < 0 || ty >= m || isVisit[key][tx][ty] || maze[tx][ty] == '#') continue;
                if (maze[tx][ty] == '1') {
                    bw.write(cnt + "");
                    br.close();
                    bw.close();
                    return;
                }
                isVisit[key][tx][ty] = true;

                char shape = maze[tx][ty];
                if (shape >= 'a' && shape <= 'f' && (key & (1 << shape - 'a')) == 0) {
                    queue.add(new Pos(tx, ty, cnt, key));
                    key |= 1 << shape - 'a';
                    isVisit[key][tx][ty] = true;
                    queue.add(new Pos(tx, ty, cnt, key));
                    continue;
                }
                if (shape >= 'A' && shape <= 'F' && (key & (1 << (shape - 'A'))) == 0) continue;
                queue.add(new Pos(tx, ty, cnt, key));
            }
        }

        bw.write(-1 + "");
        br.close();
        bw.close();
    }
}

class Pos {
    int x, y, cnt, key;

    public Pos(int x, int y, int cnt, int key) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.key = key;
    }
}
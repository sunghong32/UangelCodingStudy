import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class zelda {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] cave;
    static int[][] rupy;

    public static void main(String[] args) throws IOException {
        int n;
        int a = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            cave = new int[n][n];
            rupy = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] temp = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    cave[i][j] = Integer.parseInt(temp[j]);
                    rupy[i][j] = 150000;
                }
            }
            rupy[0][0] = cave[0][0];
            findMinCost(n);

            bw.append("Problem ").append(String.valueOf(a)).append(": ").append(String.valueOf(rupy[n - 1][n - 1])).append("\n");
            a++;
        }
        bw.close();
        br.close();
    }

    static void findMinCost(int n) {
        Deque<XY> deque = new ArrayDeque<>();
        deque.add(new XY(0, 0));
        while (!deque.isEmpty()) {
            XY xy = deque.poll();
            XY moveXY = null;
            for (int i = 0; i < 4; i++) {
                switch (i) {
                    case 0:
                        moveXY = new XY(xy.x - 1, xy.y);//상
                        break;
                    case 1:
                        moveXY = new XY(xy.x + 1, xy.y);//하
                        break;
                    case 2:
                        moveXY = new XY(xy.x, xy.y - 1);//좌
                        break;
                    case 3:
                        moveXY = new XY(xy.x, xy.y + 1);//우
                        break;
                }

                if (moveXY.x < 0 || moveXY.y < 0 || moveXY.x > n - 1 || moveXY.y > n - 1) continue;
                if (rupy[moveXY.x][moveXY.y] <= rupy[xy.x][xy.y] + cave[moveXY.x][moveXY.y]) continue;
                rupy[moveXY.x][moveXY.y] = rupy[xy.x][xy.y] + cave[moveXY.x][moveXY.y];
                deque.add(new XY(moveXY.x, moveXY.y));
            }
        }
    }

    static class XY {
        int x;
        int y;

        XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

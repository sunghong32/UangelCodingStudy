import java.io.*;

/*
 * 2024.01.10
 * BAEKJOON 1799:비숍
 * 메모리 : 18332 KB
 * 시간 : 284 ms
 * */

public class Bishop {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] chessboard;
    static int count = 0;

    public static int[] dx = {-1, 1, 1, -1};
    public static int[] dy = {1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        chessboard = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                chessboard[i][j] = Integer.parseInt(str[j]);
            }
        }

        int answer = 0;
        findBishop(0, 0);
        answer += count;
        count = 0;
        findBishop(1, 0);
        answer += count;

        bw.write(answer + "");
        br.close();
        bw.close();
    }

    public static void findBishop(int index, int cnt) {
        if (index >= n * n) {
            count = Math.max(cnt, count);
            return;
        }
        int x = index / n;
        int y = index % n;
        int plus;
        if (n % 2 == 1) plus = 2;
        else if (index % n == n - 1) plus = 1;
        else if (index % n == n - 2) plus = 3;
        else plus = 2;

        if (chessboard[x][y] == 0) {
            findBishop(index + plus, cnt);
            return;
        }

        if (isValid(x, y)) {
            chessboard[x][y] = 2;
            findBishop(index + plus, cnt + 1);
            chessboard[x][y] = 1;
        }

        findBishop(index + plus, cnt);
    }

    public static boolean isValid(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int amt = 1;
            while (true) {
                int X = x + amt * dx[d];
                int Y = y + amt * dy[d];
                if (X < 0 || Y < 0 || X >= n || Y >= n)
                    break;
                if (chessboard[X][Y] == 2) return false;
                amt++;
            }
        }
        return true;
    }
}
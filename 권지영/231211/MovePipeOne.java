import java.io.*;

/*
 * 2023.12.11
 * BAEKJOON 17070번:파이프 옮기기 1
 * 메모리 : 20260 KB
 * 시간 : 248 ms
 * */

public class MovePipeOne {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int answer = 0;
    static int[][] home;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        home = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                home[i][j] = Integer.parseInt(strs[j]);
            }
        }
        move(0, 1, 0);

        bw.write(answer + "");
        br.close();
        bw.close();
    }

    static void move(int x, int y, int direction) {
        if (x == n - 1 && y == n - 1) {
            answer++;
            return;
        }

        switch (direction) {
            case 0: //가로
                if (y + 1 < n && home[x][y + 1] == 0) move(x, y + 1, 0);
                break;
            case 1: //세로
                if (x + 1 < n && home[x + 1][y] == 0) move(x + 1, y, 1);
                break;
            case 2: //대각선
                if (y + 1 < n && home[x][y + 1] == 0) move(x, y + 1, 0);
                if (x + 1 < n && home[x + 1][y] == 0) move(x + 1, y, 1);
                break;
        }
        if (x + 1 < n && y + 1 < n && home[x + 1][y] == 0 && home[x][y + 1] == 0 && home[x + 1][y + 1] == 0)
            move(x + 1, y + 1, 2);
    }
}
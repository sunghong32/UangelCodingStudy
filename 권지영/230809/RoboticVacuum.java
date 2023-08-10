import java.io.*;
import java.util.StringTokenizer;

/*
 * 2023.08.09
 * BAEKJOON 14503번:로봇 청소기
 * 메모리 : 14456 KB
 * 시간 : 136 ms
 * */

public class RoboticVacuum {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        st = new StringTokenizer(str);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] room = new int[n][m];

        str = br.readLine();
        st = new StringTokenizer(str);
        // {r, c, d}
        int[] robotInfo = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        for (int i = 0; i < n; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(robotInfo, room);

        bw.write(String.valueOf(count));
        bw.close();
        br.close();
    }

    //0 : 청소 x
    //1 : 벽
    //2 : 청소 o
    static void clean(int[] robotInfo, int[][] room) {
        int r = robotInfo[0];
        int c = robotInfo[1];
        if (room[r][c] == 0) {
            room[r][c] = 2;
            count++;
        }
        if (isRemainAround(r, c, room)) { //청소할게 남아있는 경우
            int d = robotInfo[2];
            if (d - 1 == -1) robotInfo[2] = 3;
            else robotInfo[2] = d - 1;

            switch (robotInfo[2]) {
                case 0:
                    if (room[r - 1][c] == 0) robotInfo[0]--;
                    break;
                case 1:
                    if (room[r][c + 1] == 0) robotInfo[1]++;
                    break;
                case 2:
                    if (room[r + 1][c] == 0) robotInfo[0]++;
                    break;
                default:
                    if (room[r][c - 1] == 0) robotInfo[1]--;
                    break;
            }

            clean(robotInfo, room);
        } else { //청소 다 했을 경우
            switch (robotInfo[2]) {
                case 0:
                    if (room[r + 1][c] == 1) return;
                    else robotInfo[0]++;
                    break;
                case 1:
                    if (room[r][c - 1] == 1) return;
                    else robotInfo[1]--;
                    break;
                case 2:
                    if (room[r - 1][c] == 1) return;
                    else robotInfo[0]--;
                    break;
                default:
                    if (room[r][c + 1] == 1) return;
                    else robotInfo[1]++;
                    break;
            }
            clean(robotInfo, room);
        }
    }

    static boolean isRemainAround(int r, int c, int[][] room) {
        if (r > 0) {
            if (room[r - 1][c] == 0) return true;
        }

        if (c > 0) {
            if (room[r][c - 1] == 0) return true;
        }

        return room[r + 1][c] == 0 || room[r][c + 1] == 0;
    }
}

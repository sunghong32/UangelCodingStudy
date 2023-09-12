import java.io.*;

/*
 * 2023.09.11
 * BAEKJOON 1520번:내리막 길
 * 메모리 : 39956 KB
 * 시간 : 408 ms
 * */

public class DownHill {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map, routeCnt;
    static int m;
    static int n;

    public static void main(String[] args) throws IOException {
        String[] firstLine = br.readLine().split(" ");
        m = Integer.parseInt(firstLine[0]);
        n = Integer.parseInt(firstLine[1]);
        map = new int[m][n];
        routeCnt = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] tempStr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tempStr[j]);
                routeCnt[i][j] = -1;
            }
        }

        //0,0에서 시작 -> m-1,n-1에서 끝
        int cnt = findRoute(0, 0);
        bw.write(cnt + "");
        br.close();
        bw.close();
    }

    static int findRoute(int x, int y) {
        if((x == (m - 1)) && (y == (n - 1))) return 1;
        if(routeCnt[x][y] != -1) return routeCnt[x][y]; //계산이 된 좌표라면
        routeCnt[x][y] = 0;
        int curH = map[x][y];
        int nextX = 0;
        int nextY = 0;

        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0: { //상
                    nextX = x - 1;
                    nextY = y;
                    break;
                }
                case 1: { //하
                    nextX = x + 1;
                    nextY = y;
                    break;
                }
                case 2: { //좌
                    nextX = x;
                    nextY = y - 1;
                    break;
                }
                case 3: { //우
                    nextX = x;
                    nextY = y + 1;
                    break;
                }
            }
            if (nextX < 0 || nextY < 0 || nextX > m - 1 || nextY > n - 1) continue;
            if (map[nextX][nextY] < curH) {  //다음 높이가 현재 높이보다 낮으면
                routeCnt[x][y] += findRoute(nextX, nextY);
            }
        }
        return routeCnt[x][y];
    }
}
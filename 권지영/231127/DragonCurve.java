import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * 2023.11.27
 * BAEKJOON 15685번:드래곤 커브
 * 메모리 : 14604 KB
 * 시간 : 140 ms
 * */

public class DragonCurve {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        boolean[][] coordinates = new boolean[101][101];

        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().split(" ");
            int x = Integer.parseInt(strs[0]);
            int y = Integer.parseInt(strs[1]);
            int d = Integer.parseInt(strs[2]);
            int g = Integer.parseInt(strs[3]);

            List<int[]> Curve = new ArrayList<>();
            //0세대
            Curve.add(new int[]{x, y});

            switch (d) {
                case 0:
                    Curve.add(new int[]{x + 1, y});
                    break;
                case 1:
                    Curve.add(new int[]{x, y - 1});
                    break;
                case 2:
                    Curve.add(new int[]{x - 1, y});
                    break;
                case 3:
                    Curve.add(new int[]{x, y + 1});
                    break;
            }

            //1세대 이후 ~
            for (int j = 0; j < g; j++) {
                //끝점 찾기
                int lastIdx = Curve.size() - 1;
                int[] lastDot = Curve.get(lastIdx);
                //시계방향 90도
                for (int k = lastIdx - 1; k >= 0; k--) {
                    int[] standDot = Curve.get(k);
                    int tx = lastDot[0] + lastDot[1] - standDot[1];
                    int ty = standDot[0] - lastDot[0] + lastDot[1];
                    Curve.add(new int[]{tx, ty});
                }
            }

            for (int[] temp : Curve) {
                coordinates[temp[0]][temp[1]] = true;
            }
        }
        //1X1 정사각형 판단
        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (coordinates[i][j] && coordinates[i + 1][j] && coordinates[i][j + 1] && coordinates[i + 1][j + 1])
                    answer++;
            }
        }
        bw.write(answer + "");
        br.close();
        bw.close();
    }
}
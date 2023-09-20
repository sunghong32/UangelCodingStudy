import java.io.*;
import java.util.Arrays;

/*
 * 2023.09.20
 * BAEKJOON 17779번:게리맨더링 2
 * 메모리 : 20148 KB
 * 시간 : 424 ms
 * */

public class Gerrymandering {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] city;
    static int[][] area;
    static int[] population = new int[5];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int answer = 100*20*20;

        city = new int[n][n];
        area = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(strs[j]);
            }
        }

        for (int x = 1; x < n + 1; x++) {
            for (int y = 1; y < n + 1; y++) {
                for (int d1 = 1; d1 < y; d1++) {
                    for (int d2 = 1; d2 <= n-y; d2++) {
                        if (x + d1 + d2 >= n) continue;
                        if (y + d2 >= n) continue;
                        divideArea(x, y, d1, d2);

                        for(int i=0; i<n; i++){
                            for(int j=0; j<n; j++){
                                population[area[i][j]-1] += city[i][j];
                                area[i][j] = 0;
                            }
                        }

                        Arrays.sort(population);
                        answer = Math.min(answer, population[4] - population[0]);
                        Arrays.fill(population,0);
                    }
                }
            }
        }

        bw.write(answer+"");
        br.close();
        bw.close();
    }

    static void divideArea(int x, int y, int d1, int d2) {
        //경계선
        for (int i = 0; i < d1 + 1; i++) {
            area[x - 1 + i][y - 1 - i] = 5;
            area[x - 1 + d2 + i][y - 1 + d2 - i] = 5;
        }
        for (int i = 0; i < d2 + 1; i++) {
            area[x - 1 + i][y - 1 + i] = 5;
            area[x - 1 + d1 + i][y - 1 - d1 + i] = 5;
        }

        int n = area.length;

        //내부 채우기
        for (int i = 0; i < n; i++) {
            int flag = -1;
            for (int j = 0; j < n; j++) {
                if (flag == -1 && area[i][j] == 5) {
                    flag = j + 1;
                } else if (flag != -1 && area[i][j] == 5) {
                    for (int k = flag; k <= j; k++) {
                        area[i][k] = 5;
                    }
                }
            }
        }

        // 1,2,3,4 구역 나누기
        for (int r = 1; r < n + 1; r++) {
            for (int c = 1; c < n + 1; c++) {
                if (area[r - 1][c - 1] != 5) {
                    if (r < x + d1 && c <= y) area[r - 1][c - 1] = 1;
                    else if (r <= x + d2 && c > y && c <= n) area[r - 1][c - 1] = 2;
                    else if (r >= x + d1 && r <= n && c < y - d1 + d2) area[r - 1][c - 1] = 3;
                    else if (r > x + d2 && r <= n && c >= y - d1 + d2 && c <= n) area[r - 1][c - 1] = 4;
                }
            }
        }
    }
}


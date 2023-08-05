import java.io.*;

/*
 * 2023.08.04
 * BAEKJOON 2447번:별 찍기 - 10
 * 메모리 : 34452 KB
 * 시간 : 412 ms
 * */

public class DrawStar {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][n];

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                arr[i][j] = " ";
            }
        }
        drawStar(n, arr, 0, 0);

        for(String[] strs : arr){
            for(String str : strs){
               bw.write(str);
            }
            bw.write("\n");
        }
        bw.close();
        br.close();
    }

    static void drawStar(int n, String[][] arr, int x, int y) {
        if (n == 1) {
            arr[x][y] = "*";
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != 1 || j != 1) {
                    int size = n / 3;
                    drawStar(size, arr, x + i * size, y + j * size);
                }
            }
        }
    }
}
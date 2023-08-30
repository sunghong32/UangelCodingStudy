import java.io.*;

/*
 * 2023.08.30
 * BAEKJOON 2630번:색종이 만들기
 * 메모리 : 16860 KB
 * 시간 : 176 ms
 * */

public class MakingColoredPaper {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[][] paper;
    static int white;
    static int blue;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        paper = new String[n][n];
        String str;

        for (int i = 0; i < n; i++) {
            str = br.readLine();
            int j = 0;
            for (String s : str.split(" ")) {
                paper[i][j] = s;
                j++;
            }
        }

        splitPaper(0, 0, n);

        bw.write(white + "\n");
        bw.write(blue + "");
        br.close();
        bw.close();
    }

    static void splitPaper(int x, int y, int size) {
        if (isOneColor(x, y, size)) return;

        size = size / 2;

        splitPaper(x, y, size);
        splitPaper(x, y + size, size);
        splitPaper(x + size, y, size);
        splitPaper(x + size, y + size, size);

    }

    static boolean isOneColor(int x, int y, int size) {
        String color = paper[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (!paper[i][j].equals(color)) {
                    return false;
                }
            }
        }

        if (color.equals("0")) white++;
        else blue++;

        return true;
    }

}
import java.io.*;

/*
 * 2023.08.01
 * BAEKJOON 1992번:쿼드트리
 * 메모리 : 14528 KB
 * 시간 : 140 ms
 * */

public class QuadTree {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringBuilder sb = new StringBuilder();
  static int[][] video;

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    video = new int[n][n];

    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      for (int j = 0; j < n; j++) {
        video[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
      }
    }

    quadTree(0, 0, n);
    bw.write(sb.toString());
    bw.close();
    br.close();
  }

  static void quadTree(int x, int y, int size) {
    if (isComp(x, y, size)) {
      sb.append(video[x][y]);
      return;
    }
    size = size / 2;
    sb.append("(");

    quadTree(x, y, size);
    quadTree(x, y + size, size);
    quadTree(x + size, y, size);
    quadTree(x + size, y + size, size);

    sb.append(")");
  }

  static boolean isComp(int x, int y, int size) {
    int standard = video[x][y];

    for (int i = x; i < x + size; i++) {
      for (int j = y; j < y + size; j++) {
        if (standard != video[i][j]) return false;
      }
    }
    return true;
  }
}
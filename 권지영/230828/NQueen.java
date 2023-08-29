import java.io.*;

/*
 * 2023.08.28
 * BAEKJOON 9663번:N-Queen
 * 메모리 : 18484 KB
 * 시간 : 8836 ms
 * */

public class NQueen {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n;
  static boolean[][] chessboard;
  static int count = 0;

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      chessboard = new boolean[n][n];
      chessboard[0][i] = true;
      findRoute(chessboard, 1);
    }
    bw.write(count + "");
    br.close();
    bw.close();
  }

  static void findRoute(boolean[][] chessboard, int depth) {
    if (depth == n) {
      count++;
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!isAttacked(i, chessboard, depth)) {
        chessboard[depth][i] = true;
        findRoute(chessboard, depth + 1);
        chessboard[depth][i] = false;
      }
    }
  }

  static boolean isAttacked(int m, boolean[][] chessboard, int depth) {
    // 세로
    for (int i = 0; i < depth; i++) {
      if (chessboard[i][m]) return true;
    }

    // 대각선
    for (int k = 1; k < n; k++) {
      if ((depth - k >= 0) && (m - k >= 0)) {
        if (chessboard[depth - k][m - k]) return true;
      }
      if ((depth + k < n) && (m + k < n)) {
        if (chessboard[depth + k][m + k]) return true;
      }
      if ((depth - k >= 0) && (m + k < n)) {
        if (chessboard[depth - k][m + k]) return true;
      }
      if ((depth + k < n) && (m - k >= 0)) {
        if (chessboard[depth + k][m - k]) return true;
      }
    }

    return false;
  }
}

import java.io.*;

/*
 * 2023.10.09
 * BAEKJOON 4256번:트리
 * 메모리 : 40384 KB
 * 시간 : 396 ms
 * */

public class FindTree {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringBuilder sb;
  static int[] preOrder;
  static int[] inOrder;
  static int preIndex;

  public static void main(String[] args) throws IOException {
    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      preOrder = new int[n];
      inOrder = new int[n];
      preIndex = 0;
      sb = new StringBuilder();
      String[] temps = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        preOrder[j] = Integer.parseInt(temps[j]);
      }
      temps = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        inOrder[j] = Integer.parseInt(temps[j]);
      }
      findTree(0, n - 1);
      bw.write(sb.append("\n").toString());
    }
    br.close();
    bw.close();
  }

  static void findTree(int start, int end) {
    if (start > end) return;
    int root = preOrder[preIndex];
    preIndex++;
    int inIndex = 0;
    for (int i = start; i <= end; i++) {
      if (inOrder[i] == root) {
        inIndex = i;
        break;
      }
    }
    findTree(start, inIndex - 1);
    findTree(inIndex + 1, end);
    sb.append(root).append(" ");
  }
}

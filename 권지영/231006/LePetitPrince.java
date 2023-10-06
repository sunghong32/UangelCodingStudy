import java.io.*;

/*
 * 2023.10.06
 * BAEKJOON 1004번:어린 왕자
 * 메모리 : 16548 KB
 * 시간 : 164 ms
 * */


public class LePetitPrince {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      String[] strs = br.readLine().split(" ");
      int x1 = Integer.parseInt(strs[0]);
      int y1 = Integer.parseInt(strs[1]);
      int x2 = Integer.parseInt(strs[2]);
      int y2 = Integer.parseInt(strs[3]);
      int n = Integer.parseInt(br.readLine());
      int cnt = 0;
      for (int j = 0; j < n; j++) {
        strs = br.readLine().split(" ");
        int cx = Integer.parseInt(strs[0]);
        int cy = Integer.parseInt(strs[1]);
        int r = Integer.parseInt(strs[2]);
        boolean is1In, is2In;
        // 점이 내부에 있는 지 외부에 있는지
        is1In = Math.pow(Math.abs(x1 - cx), 2) + Math.pow(Math.abs(y1 - cy), 2) < r * r;
        is2In = Math.pow(Math.abs(x2 - cx), 2) + Math.pow(Math.abs(y2 - cy), 2) < r * r;

        // 둘중에 하나 외부
        if ((is1In && !is2In) || (is2In && !is1In)) {
          cnt++;
        }
      }

      sb.append(cnt).append("\n");
    }
    bw.write(sb.toString());
    br.close();
    bw.close();
  }
}

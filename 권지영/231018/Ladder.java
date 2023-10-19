import java.io.*;

/*
 * 2023.10.18
 * BAEKJOON 2022번:사다리
 * 메모리 : 14648 KB
 * 시간 : 136 ms
 * */

public class Ladder {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    String[] strs = br.readLine().split(" ");
    double x = Double.parseDouble(strs[0]);
    double y = Double.parseDouble(strs[1]);
    double c = Double.parseDouble(strs[2]);
    double l = 0;
    double r = Math.max(x, y);

    while (true) {
      double d = (l + r) / 2;
      double m = Math.sqrt(Math.pow(x, 2) - Math.pow(d, 2));
      double n = Math.sqrt(Math.pow(y, 2) - Math.pow(d, 2));
      double newC = (m * n) / (m + n);

      if (Math.abs(newC - c) <= 0.001) {
        bw.write(String.format("%.3f", d));
        br.close();
        bw.close();
        return;
      }
      if (newC > c) l = d;
      else r = d;
    }
  }
}

import java.io.*;

/*
 * 2023.08.02
 * BAEKJOON 9012번:괄호
 * 메모리 : 14224 KB
 * 시간 : 128 ms
 * */

public class Parenthesis {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      String str = br.readLine();
      sb.append(isVPS(str) ? "YES" : "NO");
      sb.append("\n");
    }

    bw.write(sb.toString());
    br.close();
    bw.close();
  }

  static boolean isVPS(String str) {
    // 개수 파악 (짝이 안맞으면 VPS X)
    int count = 0;
    for (char c : str.toCharArray()) {
      if (c == '(') count++;
      else count--;

      if (count < 0) return false;
    }
    if (count != 0) return false;
    return true;
  }
}
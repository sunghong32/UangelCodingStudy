import java.io.*;
import java.util.*;

/*
 * 2023.10.16
 * BAEKJOON 7490번:0 만들기
 * 메모리 : 33892 KB
 * 시간 : 408 ms
 * */
public class MakeZero {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n;
  static List<String> answer;
  static StringBuilder sb;
  // +는 더하기, -는 빼기, 공백은 숫자를 이어 붙임
  public static void main(String[] args) throws IOException {
    int t = Integer.parseInt(br.readLine());
    sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      answer = new ArrayList<>();
      n = Integer.parseInt(br.readLine());
      findRoute(1, "1");
      Collections.sort(answer);
      for (String s : answer) {
        sb.append(s).append("\n");
      }
      sb.append("\n");
    }
    bw.write(sb.toString());
    br.close();
    bw.close();
  }

  static void findRoute(int num, String str) {
    if (num == n) {
      String newStr = str.replaceAll(" ", "");
      if (findSum(newStr)) answer.add(str);
      return;
    }

    findRoute(num + 1, str + "+" + (num + 1));
    findRoute(num + 1, str + "-" + (num + 1));
    findRoute(num + 1, str + " " + (num + 1));
  }

  static boolean findSum(String str) {
    StringTokenizer st = new StringTokenizer(str, "-|+", true);
    int sum = Integer.parseInt(st.nextToken());
    while (st.hasMoreTokens()) {
      String s = st.nextToken();
      if (s.equals("+")) sum += Integer.parseInt(st.nextToken());
      else sum -= Integer.parseInt(st.nextToken());
    }

    if (sum == 0) return true;
    return false;
  }
}

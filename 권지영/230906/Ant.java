import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 2023.09.06
 * BAEKJOON 4307번:개미
 * 메모리 : 42368 KB
 * 시간 : 712 ms
 * */

public class Ant {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringBuilder sb = new StringBuilder();
  static List<Integer> antLoc = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    solution();
  }

  static void solution() throws IOException {
    int t = Integer.parseInt(br.readLine());
    String[] str;
    int l;
    int n;
    for (int i = 0; i < t; i++) {
      str = br.readLine().split(" ");
      l = Integer.parseInt(str[0]);
      n = Integer.parseInt(str[1]);
      antLoc.clear();
      for (int j = 0; j < n; j++) {
        antLoc.add(Integer.parseInt(br.readLine()));
      }
      Collections.sort(antLoc);
      findMinMaxTime(l);
    }
    sb.deleteCharAt(sb.length() - 1);
    bw.write(sb.toString()+"");
    br.close();
    bw.close();
  }

  static void findMinMaxTime(int l) {
    int left = 0;
    int right = l;
    int halfLength = l / 2;
    // 빨리 떨어지는 시간
    for (int loc : antLoc) {
      if (loc <= halfLength) { // 왼쪽 막대 최댓값 찾기
        if (left < loc) left = loc;
      } else { // 오른쪽 막대 최솟값 찾기
        if (right > loc) right = loc;
      }
    }
    sb.append(Math.max(left, l - right)).append(" ");

    left = l/2;
    right = l/2;
    // 천천히 떨어지는 시간
    for (int loc : antLoc) {
      if (loc <= halfLength) { // 왼쪽 막대 최솟값 찾기
        if (left > loc) left = loc;
      } else { // 오른쪽 막대 최댓값 찾기
        if (right < loc) right = loc;
      }
    }
    sb.append(Math.max(l - left, right)).append("\n");
  }
}
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 2023.09.04
 * BAEKJOON 1094번:막대기
 * 메모리 : 14436 KB
 * 시간 : 132 ms
 * */

public class Stick {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static List<Integer> sticks = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    solution();
  }

  static void solution() throws IOException {
    int x = Integer.parseInt(br.readLine());
    int sum = 64;
    sticks.add(64);

    while (sum != x) {
      int min = Collections.min(sticks);
      sticks.remove(sticks.indexOf(min));
      sticks.add(min / 2);
      sum = sticks.stream().mapToInt(Integer::intValue).sum();
      if (sum < x) sticks.add(min / 2);
    }

    bw.write(sticks.size() + "");
    br.close();
    bw.close();
  }
}

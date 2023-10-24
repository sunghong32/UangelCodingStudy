import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * 2023.10.23
 * BAEKJOON 17140번:이차원 배열과 연산
 * 메모리 : 20920 KB
 * 시간 : 228 ms
 * */

public class ArraysAndOperations {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int[][] arr = new int[101][101];
  static int r, c, k;
  static int row = 3;
  static int col = 3;

  public static void main(String[] args) throws IOException {
    String[] strs = br.readLine().split(" ");
    r = Integer.parseInt(strs[0]);
    c = Integer.parseInt(strs[1]);
    k = Integer.parseInt(strs[2]);

    for (int i = 0; i < 3; i++) {
      strs = br.readLine().split(" ");
      for (int j = 0; j < 3; j++) {
        arr[i + 1][j + 1] = (Integer.parseInt(strs[j]));
      }
    }

    bw.write(checkTime() + "");
    br.close();
    bw.close();
  }

  static int checkTime() {
    for (int time = 0; time <= 100; time++) {
      if (arr[r][c] == k) {
        return time;
      }
      chooseRC();
    }
    return -1;
  }

  static void chooseRC() {
    if (row >= col) sort("R");
    else sort("C");
  }

  static void sort(String sortingName) {
    if (sortingName.equals("R")) {
      for (int i = 1; i <= row; i++) {
        PriorityQueue<Number> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int j = 1; j <= col; j++) {
          int n = arr[i][j];
          if (n == 0) continue;
          if (map.containsKey(n)) map.put(n, map.get(n) + 1);
          else map.put(n, 1);
        }

        map.forEach((k, v) -> pq.add(new Number(k, v)));

        int index = 1;
        while (!pq.isEmpty()) {
          Number n = pq.poll();
          arr[i][index++] = n.num;
          arr[i][index++] = n.count;
        }
        col = Math.max(col, index);
        while (index < 100) {
          arr[i][index++] = 0;
          arr[i][index++] = 0;
        }
      }
    } else {
      for (int i = 1; i <= col; i++) {
        PriorityQueue<Number> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int j = 1; j <= row; j++) {
          int n = arr[j][i];
          if (n == 0) continue;
          if (map.containsKey(n)) map.put(n, map.get(n) + 1);
          else map.put(n, 1);
        }

        map.forEach((k, v) -> pq.add(new Number(k, v)));

        int index = 1;
        while (!pq.isEmpty()) {
          Number n = pq.poll();
          arr[index++][i] = n.num;
          arr[index++][i] = n.count;
        }
        row = Math.max(row, index);
        while (index < 100) {
          arr[index++][i] = 0;
          arr[index++][i] = 0;
        }
      }
    }
  }

  static class Number implements Comparable<Number> {
    int num;
    int count;

    Number(int n, int c) {
      this.num = n;
      this.count = c;
    }

    public int compareTo(Number n) {
      if (this.count > n.count) {
        return 1;
      } else if (this.count == n.count) {
        return this.num - n.num;
      } else {
        return -1;
      }
    }
  }
}

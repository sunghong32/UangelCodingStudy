import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * 2023.09.01
 * BAEKJOON 1446번:지름길
 * 메모리 : 15976 KB
 * 시간 : 320 ms
 * */

public class Shortcut {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static boolean[] isPassShortCuts;
  static List<Path> shortcuts = new ArrayList<>();
  static int d;
  static int result;

  public static void main(String[] args) throws IOException {
    solution();
  }

  static void solution() throws IOException {
    String[] strs = br.readLine().split(" ");
    int n = Integer.parseInt(strs[0]);
    d = Integer.parseInt(strs[1]);
    result = d;

    int start;
    int end;
    int length;
    for (int i = 0; i < n; i++) {
      String[] tempArr = br.readLine().split(" ");
      start = Integer.parseInt(tempArr[0]);
      end = Integer.parseInt(tempArr[1]);
      length = Integer.parseInt(tempArr[2]);
      Path path = new Path(start, end, length);
      if (start > d || end > d || (end - start < length)) continue;
      shortcuts.add(path);
    }

    isPassShortCuts = new boolean[shortcuts.size()];
    findShortestDistance(0, 0);
    bw.write(result + "");
    br.close();
    bw.close();
  }

  static void findShortestDistance(int now, int total) {
    if (now == d) {
      result = Math.min(result, total);
    } else if (now < d) {
      result = Math.min(result, total + d - now);
      for (int i = 0; i < shortcuts.size(); i++) {
        if (!isPassShortCuts[i]) {
          Path path = shortcuts.get(i);
          if (path.startPos == now) {
            isPassShortCuts[i] = true;
            findShortestDistance(path.destPos, total + path.length);
            isPassShortCuts[i] = false;
          }
        }
      }
      findShortestDistance(now + 1, total + 1);
    }
  }
}

class Path {
  int startPos;
  int destPos;
  int length;

  public Path(int startPos, int destPos, int length) {
    this.startPos = startPos;
    this.destPos = destPos;
    this.length = length;
  }
}

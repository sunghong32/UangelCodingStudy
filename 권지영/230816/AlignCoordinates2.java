import java.io.*;
import java.util.*;

/*
 * 2023.08.16
 * BAEKJOON 11651번:좌표 정렬하기 2
 * 메모리 : 314280 KB
 * 시간 : 1444 ms
 * */

public class AlignCoordinates2 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    List<String> coordinates = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      coordinates.add(str);
    }

    coordinates.sort(new AlignCoordinates());
    for(String str : coordinates){
      sb.append(str).append("\n");
    }
    sb.deleteCharAt(sb.length()-1);
    bw.write(sb.toString());
    br.close();
    bw.close();
  }
}

class AlignCoordinates implements Comparator<String> {
  @Override
  public int compare(String o1, String o2) {
    String[] s1 = o1.split(" ");
    String[] s2 = o2.split(" ");
    int x1 = Integer.parseInt(s1[0]);
    int x2 = Integer.parseInt(s2[0]);
    int y1 = Integer.parseInt(s1[1]);
    int y2 = Integer.parseInt(s2[1]);

    if (y1 < y2) return -1;
    else if (y1 == y2) {
      if (x1 < x2) return -1;
    }
    return 1;
  }
}

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
* 2023.07.24
* BAEKJOON 10816번:숫자카드2
* 메모리 : 138108 KB
* 시간 : 1068 ms
* */

public class NumberCard {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    bw.write(solution());

    br.close();
    bw.close();
  }

  static String solution() throws IOException {
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    HashMap<String, Integer> cardMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String key = st.nextToken();
      if (cardMap.containsKey(key)) cardMap.put(key, cardMap.get(key) + 1);
      else cardMap.put(key, 1);
    }

    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine(), " ");
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      String checkCard = st.nextToken();
      int count = cardMap.get(checkCard) == null ? 0 : cardMap.get(checkCard);
      sb.append(count).append(" ");
    }

    return sb.substring(0, sb.length() - 1);
  }
}

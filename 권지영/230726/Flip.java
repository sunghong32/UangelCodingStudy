import java.io.*;

/*
 * 2023.07.26
 * BAEKJOON 1439번:뒤집기
 * 메모리 : 14376 KB
 * 시간 : 132 ms
 * */

public class Flip {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    solution();
  }

  static void solution() throws IOException {
    String str = br.readLine();
    String temp = str.replace("10", "1 0").replace("01", "0 1");
    String[] strings = temp.split(" ");
    int oneCnt = 0;
    int zeroCnt = 0;

    for (String s : strings) {
      if (s.startsWith("0")) zeroCnt++;
      else oneCnt++;
    }

    String result = String.valueOf(Math.min(oneCnt, zeroCnt));
    bw.write(result);

    br.close();
    bw.close();
  }
}
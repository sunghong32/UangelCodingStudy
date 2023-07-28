import java.io.*;

/*
* 20230728
* 메모리 : 15736 KB
* 시간 : 160 ms
*/

public class IronRod {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    String marks = br.readLine();

    int answer = 0;
    int count = 0;

    for (int i = 0; i < marks.length(); i++) {
      char mark = marks.charAt(i);
      if (mark == '(') count++;
      if (mark == ')') {
        count--;
        if (i > 0 && marks.charAt(i - 1) == '(') answer += count;
        else answer++;
      }
    }

    bw.write(String.valueOf(answer));

    br.close();
    bw.close();
  }
}

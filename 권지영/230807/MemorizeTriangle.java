import java.io.*;

/*
 * 2023.08.07
 * BAEKJOON 10101번:삼각형 외우기
 * 메모리 : 14116 KB
 * 시간 : 124 ms
 * */

public class MemorizeTriangle {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    int angleA = Integer.parseInt(br.readLine());
    int angleB = Integer.parseInt(br.readLine());
    int angleC = Integer.parseInt(br.readLine());

    outputType(angleA, angleB, angleC);

    br.close();
    bw.close();
  }

  static void outputType(int angleA, int angleB, int angleC) throws IOException {
    int total = angleA + angleB + angleC;

    if (total != 180) {
      bw.write("Error");
    } else {
      if (angleA == angleB || angleA == angleC || angleB == angleC) {
        if (angleA == angleB && angleA == angleC) bw.write("Equilateral");
        else bw.write("Isosceles");
      } else {
        bw.write("Scalene");
      }
    }
  }
}
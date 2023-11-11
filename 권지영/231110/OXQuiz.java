import java.io.*;
import java.util.Objects;

/*
 * 2023.11.10
 * BAEKJOON 8958번:OX퀴즈
 * 메모리 : 16544 KB
 * 시간 : 168 ms
 * */

public class OXQuiz {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] strs = br.readLine().split("");
            int score = 0;
            int total = 0;
            for (int j = 0; j < strs.length; j++) {
                if (Objects.equals(strs[j], "O")) score++;
                else score = 0;
                total += score;
            }
            bw.write(total + "\n");
        }

        br.close();
        bw.close();
    }
}
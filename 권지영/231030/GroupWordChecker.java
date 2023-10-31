import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
 * 2023.10.30
 * BAEKJOON 1316번:그룹 단어 체커
 * 메모리 : 14344 KB
 * 시간 : 136 ms
 * */

public class GroupWordChecker {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int cnt = n;
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            char[] letters = word.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            char standard = 0;

            for (char letter : letters) {
                map.compute(letter, (k, v) -> v == null ? 1 : v + 1);
                if ((letter != standard) && map.get(letter) > 1) {
                    cnt--;
                    break;
                }
                standard = letter;
            }
        }
        bw.write(cnt + "");
        br.close();
        bw.close();
    }
}
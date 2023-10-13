import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 2023.10.13
 * BAEKJOON 1337번:올바른 배열
 * 메모리 : 14300 KB
 * 시간 : 128 ms
 * */

public class CorrectArray {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            array.add(num);
        }
        Collections.sort(array);

        bw.write(findCorrectArray(array) + "");
        br.close();
        bw.close();
    }

    static int findCorrectArray(List array) {
        int answer = 0;
        for (int i = 0; i < array.size(); i++) {
            int cnt = 0;
            int num = (int) array.get(i);
            for (int j = num; j < num + 5; j++) {
                if (array.contains(j)) cnt++;
            }
            if (answer < cnt) answer = cnt;
        }

        return 5 - answer;
    }
}
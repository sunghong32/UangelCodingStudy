import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Stream;

/*
 * 2023.08.25
 * BAEKJOON 11497번:통나무 건너뛰기
 * 메모리 : 64048 KB
 * 시간 : 708 ms
 * */

public class SkipTheLog {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String[] arr = str.split(" ");

            int[] l = Arrays.stream(Stream.of(arr).mapToInt(Integer::parseInt).toArray()).sorted().toArray();
            getDifficulty(n, l);
        }
        sb.deleteCharAt(sb.length()-1);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static void getDifficulty(int n, int[] l) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (dq.size() == 0) {
                dq.offerLast(l[i]);
            } else {
                if (i % 2 == 1)
                    dq.offerFirst(l[i]);
                else
                    dq.offerLast(l[i]);
            }
        }

        int difficulty = 0;
        int result = 0;
        int temp1 = 0;
        int length = dq.size();
        for (int i = 0; i < length; i++) {
            if (i == 0) temp1 = dq.peek();
            int temp2 = dq.peek();
            if (temp1 > temp2) difficulty = temp1 - temp2;
            else difficulty = temp2 - temp1;
            if (difficulty > result) result = difficulty;
            temp1 = dq.poll();
        }
        sb.append(result).append("\n");
    }
}
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * 2023.09.29
 * BAEKJOON 1766번:문제집
 * 메모리 : 53016 KB
 * 시간 : 604 ms
 * */

public class Workbook {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        List<List<Integer>> conditions = new ArrayList<>();
        int[] conCnt = new int[n];
        PriorityQueue<Integer> answer = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            conditions.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            strs = br.readLine().split(" ");
            int f = Integer.parseInt(strs[0]);
            int s = Integer.parseInt(strs[1]);
            conditions.get(f - 1).add(s - 1);
            conCnt[s - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (conCnt[i] == 0) {
                answer.add(i);
            }
        }

        while (!answer.isEmpty()) {
            int num = answer.poll();
            sb.append(num + 1).append(" ");

            for (Integer i : conditions.get(num)) {
                conCnt[i]--;
                if (conCnt[i] == 0) {
                    answer.add(i);
                }
            }
        }

        sb = sb.deleteCharAt(sb.length() - 1);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}

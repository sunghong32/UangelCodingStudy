import java.io.*;
import java.util.*;

/*
 * 2023.12.15
 * BAEKJOON 18352번:특정 거리의 도시 찾기
 * 메모리 : 338608 KB
 * 시간 : 1316 ms
 * */

public class FindCity {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int k = Integer.parseInt(strs[2]);
        int x = Integer.parseInt(strs[3]);

        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            strs = br.readLine().split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            list[a].add(b);
        }

        int[] distance = new int[n + 1];
        for (int i = 0; i <= n; i++) distance[i] = -1;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        distance[x] = 0;
        List<Integer> answer = new ArrayList<>();

        while (!q.isEmpty()) {
            int now = q.poll();
            if (distance[now] > k) break;
            if (distance[now] == k) answer.add(now);

            for (int next : list[now]) {
                if (distance[next] != -1) continue;
                distance[next] = distance[now] + 1;
                q.add(next);
            }
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (int i : answer) sb.append(i).append("\n");
        bw.write(answer.isEmpty() ? -1 + "" : sb.toString());
        br.close();
        bw.close();
    }
}
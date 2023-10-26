import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/*
 * 2023.10.25
 * BAEKJOON 1389번:케빈 베이컨의 6단계 법칙
 * 메모리 : 14420 KB
 * 시간 : 136 ms
 * */

public class KevinBacon {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] step, totalBacon;
    static int n, m;
    static List<Integer>[] friends;

    public static void main(String[] args) throws IOException {
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        friends = new List[n + 1];
        step = new int[n + 1];
        totalBacon = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            strs = br.readLine().split(" ");
            friends[Integer.parseInt(strs[0])].add(Integer.parseInt(strs[1]));
            friends[Integer.parseInt(strs[1])].add(Integer.parseInt(strs[0]));
        }

        Arrays.fill(totalBacon, 500001);
        for (int i = 1; i < n + 1; i++) {
            totalBacon[i] = Math.min(totalBacon[i], getBacon(i));
        }
        int min = Arrays.stream(totalBacon).min().getAsInt();
        System.out.println(IntStream.range(0, totalBacon.length).filter(i-> min == totalBacon[i]).findFirst().getAsInt());

    }

    static int getBacon(int key) {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(key);
        Arrays.fill(step, -1);
        step[key] = 0;

        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int v : friends[num]) {
                if (step[v] != -1) continue;
                step[v] = step[num] + 1;
                cnt += step[v];
                queue.add(v);
            }
        }
        return cnt;
    }
}

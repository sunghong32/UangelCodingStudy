import java.io.*;
import java.util.*;

/*
 * 2023.10.02
 * BAEKJOON 11725번:트리의 부모 찾기
 * 메모리 : 70560 KB
 * 시간 : 720 ms
 * */

public class FindTreeParents {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        boolean[] isVisit = new boolean[n + 1];
        int[] parents = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] strs = br.readLine().split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        queue.add(1);
        isVisit[1] = true;

        while (!queue.isEmpty()) {
            int k = queue.poll();
            for (int v : tree.get(k)) {
                if (!isVisit[v]) {
                    isVisit[v] = true;
                    queue.add(v);
                    parents[v] = k;
                }
            }
        }

        for (int i = 2; i < n + 1; i++) {
            sb.append(parents[i]).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
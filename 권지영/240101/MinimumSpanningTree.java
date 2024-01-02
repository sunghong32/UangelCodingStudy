import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 2024.01.01
 * BAEKJOON 1197번:최소 스패닝 트리
 * 메모리 : 48004 KB
 * 시간 : 560 ms
 * */

public class MinimumSpanningTree {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] parent;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        parent = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> q = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            q.add(new Edge(a, b, c));
        }

        int costSum = 0;

        while (!q.isEmpty()) {
            Edge edge = q.poll();
            if (union(edge.from, edge.to)) {
                costSum += edge.val;
            }
        }
        bw.write(costSum + "");
        br.close();
        bw.close();
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a == b) return false;
        else if (a > b)
            parent[a] = b;
        else
            parent[b] = a;
        return true;
    }
}

class Edge implements Comparable<Edge> {
    int from;
    int to;
    int val;

    Edge(int f, int t, int v) {
        from = f;
        to = t;
        val = v;
    }

    @Override
    public int compareTo(Edge o) {
        return (this.val - o.val);
    }
}
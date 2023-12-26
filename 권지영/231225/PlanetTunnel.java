import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 2023.12.25
 * BAEKJOON 2887번:행성 터널
 * 메모리 : 87164 KB
 * 시간 : 1324 ms
 * */

public class PlanetTunnel {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] g;

    static int find(int x) {
        if (g[x] == x) return x;
        else return g[x] = find(g[x]);
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        g = new int[n + 1];
        ArrayList<Planet> X = new ArrayList<>();
        ArrayList<Planet> Y = new ArrayList<>();
        ArrayList<Planet> Z = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            X.add(new Planet(i, 0, x));
            Y.add(new Planet(i, 0, y));
            Z.add(new Planet(i, 0, z));
            g[i] = i;
        }
        Collections.sort(X);
        Collections.sort(Y);
        Collections.sort(Z);
        PriorityQueue<Planet> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                q.add(new Planet(X.get(i).from, X.get(i - 1).from, Math.abs(X.get(i).val - X.get(i - 1).val)));
                q.add(new Planet(Y.get(i).from, Y.get(i - 1).from, Math.abs(Y.get(i).val - Y.get(i - 1).val)));
                q.add(new Planet(Z.get(i).from, Z.get(i - 1).from, Math.abs(Z.get(i).val - Z.get(i - 1).val)));
            }
            if (i != n - 1) {
                q.add(new Planet(X.get(i).from, X.get(i + 1).from, Math.abs(X.get(i).val - X.get(i + 1).val)));
                q.add(new Planet(Y.get(i).from, Y.get(i + 1).from, Math.abs(Y.get(i).val - Y.get(i + 1).val)));
                q.add(new Planet(Z.get(i).from, Z.get(i + 1).from, Math.abs(Z.get(i).val - Z.get(i + 1).val)));
            }
        }
        long cost = 0;
        while (!q.isEmpty()) {
            Planet p = q.poll();
            if (union(p.from, p.to)) {
                cost += p.val;
            }
        }
        bw.write(cost + "");

        br.close();
        bw.close();
    }

    static boolean union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a == b) return false;
        else if (a > b)
            g[a] = b;
        else
            g[b] = a;
        return true;
    }
}

class Planet implements Comparable<Planet> {
    int from;
    int to;
    int val;

    Planet(int f, int t, int v) {
        from = f;
        to = t;
        val = v;
    }

    @Override
    public int compareTo(Planet o) {
        return (this.val - o.val);
    }
}
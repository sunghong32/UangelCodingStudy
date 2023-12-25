package baekjoon.algorithm.graphsearch;

import java.io.*;
import java.util.*;

/**
 * [Algorithm]
 * 그래프 이론
 * 정렬
 * 최소 스패닝 트리
 * [Result]
 * 메모리 : 83200 kb
 * 수행시간 : 2384 ms
 */
public class PlanetaryTunnel {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[] parent;

    public static void main(String[] args) { planetaryTunnel(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void planetaryTunnel() {
        int n = Integer.parseInt(readInput());
        Planet[] planets = new Planet[n];
        List<Tunnel> tList = new ArrayList<>();

        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(readInput(), " ");
            planets[i] = new Planet(i, Integer.valueOf(st.nextToken()),Integer.valueOf(st.nextToken()),Integer.valueOf(st.nextToken()));
        }
        Arrays.sort(planets, Comparator.comparingInt(p -> p.x));
        for(int i=0;i<n-1;i++){
            int c = planets[i+1].x-planets[i].x;
            tList.add(new Tunnel(planets[i].n, planets[i+1].n, c));
        }
        Arrays.sort(planets, Comparator.comparingInt(p -> p.y));
        for(int i=0;i<n-1;i++){
            int c = planets[i+1].y-planets[i].y;
            tList.add(new Tunnel(planets[i].n, planets[i+1].n, c));
        }
        Arrays.sort(planets, Comparator.comparingInt(p -> p.z));
        for(int i=0;i<n-1;i++){
            int c = planets[i+1].z-planets[i].z;
            tList.add(new Tunnel(planets[i].n, planets[i+1].n, c));
        }

        parent = new int[n];
        for (int i = 0; i < n; i++) { parent[i] = i; }
        Collections.sort(tList);

        int cost = 0;
        for (int i = 0; i < tList.size(); i++) {
            Tunnel t = tList.get(i);

            if (find(t.s) != find(t.e)) {
                cost += t.c;
                union(t.s, t.e);
            }
        }

        writeOutput(String.valueOf(cost));
    }

    public static int find(int x) {
        if (x == parent[x]) {return x;}
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {parent[y] = x;}
    }

    static class Planet{
        int n, x, y, z;
        Planet(int n, int x, int y, int z){this.n=n;this.x=x;this.y=y; this.z=z;}
    }

    static class Tunnel implements Comparable<Tunnel>{
        int s, e, c;
        Tunnel(int s, int e, int c){this.s=s;this.e=e;this.c=c;}

        @Override
        public int compareTo(Tunnel o) {
            return this.c - o.c;
        }
    }
}
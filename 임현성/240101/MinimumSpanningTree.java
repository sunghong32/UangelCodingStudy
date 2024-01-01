package baekjoon.algorithm.graphsearch;

import java.io.*;
import java.util.*;

/**
 * [Algorithm]
 * 그래프 이론
 * 최소 스패닝 트리
 * [Result]
 * 메모리 : 55784 kb
 * 수행시간 : 792 ms
 */
public class MinimumSpanningTree {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] parent;

    public static void main(String[] args) { minimumSpanningTree(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void minimumSpanningTree() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        int vN = Integer.parseInt(st.nextToken());
        int eN = Integer.parseInt(st.nextToken());
        parent = new int[vN+1];
        for (int i = 0; i <= vN; i++) { parent[i] = i; }
        List<Integer[]> edges = new ArrayList<>();
        for(int i=0;i<eN;i++){
            st = new StringTokenizer(readInput(), " ");
            Integer[] edge = new Integer[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            edges.add(edge);
        }
        edges.sort(Comparator.comparingInt(e -> e[2]));
        int result = 0;
        for(Integer[] e:edges){
            if(find(e[0]) != find(e[1])) {
                union(e[0], e[1]);
                result+=e[2];
            }
        }
        writeOutput(String.valueOf(result));
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
}
package baekjoon.algorithm.graphsearch;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 그래프 이론
 * 그래프 탐색
 * 트리
 * 깊이 우선 탐색
 * [Result]
 * 메모리 : 79936 kb
 * 수행시간 : 836 ms
 */
public class TreeDiameter {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Node>[] list;
    static boolean[] visited;
    static int max = 0;
    static int peer;

    public static void main(String[] args) { treeDiameter(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void treeDiameter() {
        int N = Integer.parseInt(readInput());
        list = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(readInput(), " ");
            int target = Integer.parseInt(st.nextToken());
            while(true) {
                int node = Integer.parseInt(st.nextToken());
                if(node == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                list[target-1].add(new Node(node-1, cost));
            }
        }

        visited = new boolean[N];
        dfs(0, 0);

        visited = new boolean[N];
        dfs(peer, 0);

        writeOutput(String.valueOf(max));
    }

    public static void dfs(int x, int len) {
        if(len > max) {
            max = len;
            peer = x;
        }
        visited[x] = true;
        for(int i = 0; i < list[x].size(); i++) {
            Node node = list[x].get(i);
            if(!visited[node.n]) {
                dfs(node.n, node.cost + len);
                visited[node.n] = true;
            }
        }

    }

    static class Node {
        int n;
        int cost;

        Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }
    }
}
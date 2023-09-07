package baekjoon.algorithm.graphsearch;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 그래프 이론
 * 다익스트라
 * [Result]
 * 메모리 : 20904 kb
 * 수행시간 : 252 ms
 */
public class GreenBoyLink {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();

    static class Node implements Comparable<Node>{
        public int x;
        public int y;
        public int cost;

        public Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) {
        greenBoyLink();
        stop();
    }

    private static String readInput() {
        try { return READER.readLine(); } catch (Exception e){ return ""; }
    }

    private static void writeOutput(String output) {
        try {
            WRITER.write(output);
            WRITER.flush();
        } catch (IOException ignored) {/* ignored */}
    }

    private static void stop(){
        try {
            READER.close();
            WRITER.close();
        } catch (IOException ignored) {/* ignored */}
    }

    private static void greenBoyLink() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        int n = Integer.parseInt(st.nextToken());
        int idx = 1;
        while (n != 0){
            int[][] cave = new int[n][n];
            for(int i=0;i<n;i++){
                st = new StringTokenizer(readInput(), " ");
                for(int j=0;j<n;j++){
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            SB.append("Problem ").append(idx++).append(": ").append(findCheapestWay(cave)).append("\n");
            st = new StringTokenizer(readInput(), " ");
            n = Integer.parseInt(st.nextToken());
        }
        writeOutput(SB.toString());
    }

    private static int findCheapestWay(int[][] cave){
        int size = cave.length;
        boolean[][] check = new boolean[size][size];
        int[][] dist = new int[size][size];
        int inf = 18*size;
        for (int[] d : dist){
            Arrays.fill(d, inf);
        }
        dist[0][0] = cave[0][0];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, dist[0][0]));

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            int x = nowNode.x;
            int y = nowNode.y;

            if(check[x][y]) continue;

            if(x>0 && dist[x-1][y] > dist[x][y]+cave[x-1][y]) {
                dist[x-1][y] = dist[x][y]+cave[x-1][y];
                pq.offer(new Node(x-1, y, dist[x-1][y]));
            }
            if(y>0 && dist[x][y-1] > dist[x][y]+cave[x][y-1]) {
                dist[x][y-1] = dist[x][y]+cave[x][y-1];
                pq.offer(new Node(x, y-1, dist[x][y-1]));
            }
            if(x<size-1 && dist[x+1][y] > dist[x][y]+cave[x+1][y]) {
                dist[x+1][y] = dist[x][y]+cave[x+1][y];
                pq.offer(new Node(x+1, y, dist[x+1][y]));
            }
            if(y<size-1 && dist[x][y+1] > dist[x][y]+cave[x][y+1]) {
                dist[x][y+1] = dist[x][y]+cave[x][y+1];
                pq.offer(new Node(x, y+1, dist[x][y+1]));
            }
            check[x][y] = true;
        }
        return dist[size-1][size-1];
    }
}
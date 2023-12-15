package baekjoon.algorithm.graphsearch;

import java.io.*;
import java.util.*;

/**
 * [Algorithm]
 * 그래프 이론
 * 그래프 탐색
 * 너비 우선 탐색
 * 데이크스트라
 * 최단 경로
 * [Result]
 * 메모리 : 346236 kb
 * 수행시간 : 1536 ms
 */
public class FindCity {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();
    private static Map<Integer, List<Integer>> adjList = new HashMap<>();
    private static int[] dist;
    private static boolean[] isCheck;

    public static void main(String[] args) { findCity(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void findCity() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        for(int i=1;i<=n;i++){ adjList.put(i, new ArrayList<>()); }
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(readInput(), " ");
            adjList.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }
        dist = new int[n+1];
        isCheck = new boolean[n+1];
        bfs(x);
        for (int i=1;i<=n;i++){
            if(dist[i]==k) SB.append(i).append("\n");
        }
        if(SB.length()==0) SB.append("-1");
        writeOutput(SB.toString());
    }

    private static void bfs(int x){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(x);
        while (!q.isEmpty()){
            int node = q.poll();
            isCheck[node] = true;
            List<Integer> nNodes = adjList.get(node);
            for(int i=0;i<nNodes.size();i++){
                if(!isCheck[nNodes.get(i)] && dist[nNodes.get(i)] == 0) {
                    q.add(nNodes.get(i));
                    dist[nNodes.get(i)] = dist[node]+1;
                }
            }
        }
    }
}
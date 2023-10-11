package baekjoon.algorithm.graphsearch;

import java.io.*;
import java.util.*;

/**
 * [Algorithm]
 * 그래프 이론
 * 그래프 탐색
 * 너비 우선 탐색
 * 깊이 우선 탐색
 * [Result]
 * 메모리 : 145264 kb
 * 수행시간 : 668 ms
 */
public class ConnectedComponent {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        connectedComponent();
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

    private static void connectedComponent() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<Integer> nodeSet = new HashSet<>();
        List<Set<Integer>> graphSet = new ArrayList<>();
        for(int i=1;i<=n;i++){
            nodeSet.add(i);
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(readInput(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(nodeSet.contains(u)) {
                nodeSet.remove(u);
                if(nodeSet.contains(v)){
                    nodeSet.remove(v);
                    Set<Integer> graph = new HashSet<>();
                    graph.add(u);
                    graph.add(v);
                    graphSet.add(graph);
                } else {
                    for (Set<Integer> g:graphSet){
                        if(g.contains(v)) {
                            g.add(u);
                            break;
                        }
                    }
                }
            } else if(nodeSet.contains(v)){
                nodeSet.remove(v);
                for (Set<Integer> g:graphSet){
                    if(g.contains(u)) {
                        g.add(v);
                        break;
                    }
                }
            } else {
                int uIdx = -1, vIdx = -1;
                for (int j=0;j<graphSet.size();j++){
                    if(graphSet.get(j).contains(u)) uIdx = j;
                    if(graphSet.get(j).contains(v)) vIdx = j;
                    if(uIdx != -1 && vIdx != -1) break;
                }
                if(uIdx != vIdx) {
                    graphSet.get(uIdx).addAll(graphSet.get(vIdx));
                    graphSet.remove(vIdx);
                }
            }
        }
        writeOutput(String.valueOf(graphSet.size()+nodeSet.size()));
    }
}
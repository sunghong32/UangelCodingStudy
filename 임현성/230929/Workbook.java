package baekjoon.algorithm.graphsearch;

import java.io.*;
import java.util.*;

/**
 * [Algorithm]
 * 자료 구조
 * 그래프 이론
 * 우선순위 큐
 * 위상 정렬
 * [Result]
 * 메모리 : 45612 kb
 * 수행시간 : 508 ms
 */
public class Workbook {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();
    private static int n;

    public static void main(String[] args) {
        workbook();
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

    private static void workbook() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> edgeList = new ArrayList<>();
        int[] inEdgeCount = new int[n];
        for(int i=0;i<n;i++){
            edgeList.add(new ArrayList<>());
        }

        for (int i=0;i<m;i++){
            st = new StringTokenizer(readInput(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edgeList.get(a-1).add(b-1);
            inEdgeCount[b-1]++;
        }
        topologicalSort(inEdgeCount, edgeList);
        writeOutput(SB.toString());
    }

    private static void topologicalSort(int[] inEdgeCount, List<List<Integer>> edgeList){
        PriorityQueue<Integer> zeroQ = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            if(inEdgeCount[i] == 0) zeroQ.offer(i);
        }

        while (!zeroQ.isEmpty()){
            int node = zeroQ.poll();
            SB.append(node+1).append(" ");

            for(Integer i:edgeList.get(node)){
                inEdgeCount[i]--;
                if(inEdgeCount[i] == 0){
                    zeroQ.offer(i);
                }
            }
        }
    }
}
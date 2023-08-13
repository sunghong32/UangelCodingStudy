package baekjoon.algorithm.graphsearch;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Input]
 * Line 1 : 정점의 개수 n
 * Line 2 ~ n+1 : 정점 간 간선 행렬
 * [Output]
 * Line 2 ~ n+1 : 경로 존재 여부 행렬
 * [Algorithm]
 * 그래프 이론
 * 그래프 탐색
 * 플로이드–워셜
 * [Result]
 * 메모리 : 15252 kb
 * 수행시간 : 188 ms
 */
public class FindingPath {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        findingPath();
        stop();
    }

    private static String readInput() {
        try { return reader.readLine(); } catch (Exception e){ return ""; }
    }

    private static void writeOutput(String output) {
        try {
            writer.write(output);
            writer.flush();
        } catch (IOException ignored) {/* ignored */}
    }

    private static void stop(){
        try {
            reader.close();
            writer.close();
        } catch (IOException ignored) {/* ignored */}
    }

    private static void findingPath() {
        int nodeCount = Integer.parseInt(readInput());
        int[][] adjacencyMatrix = new int[nodeCount][nodeCount];
        StringTokenizer st;
        for(int i=0;i<nodeCount;i++){
            st = new StringTokenizer(readInput(), " ");
            for(int j=0;j<nodeCount;j++) adjacencyMatrix[i][j] = Integer.parseInt(st.nextToken());
        }
        // 플로이드 와샬 알고리즘
        // int[][] pathGraph = floydWarshall(adjacencyMatrix);
        // 문제에서 요구한 알고리즘
        int[][] pathGraph = getPathGraph(adjacencyMatrix);
        StringBuilder sb = new StringBuilder();
        for(int[] line : pathGraph){
            for (int edge : line) {
                sb.append(edge).append(" ");
            }
            sb.append("\n");
        }
        writeOutput(sb.toString());
    }

    private static int[][] floydWarshall(int[][] adjacencyMatrix) {
        for(int i = 0; i < adjacencyMatrix.length; i++){
            for(int j = 0; j < adjacencyMatrix.length; j++) {
                if( adjacencyMatrix[i][j] > 0){
                    for(int k = 0; k < adjacencyMatrix.length; k++) {
                        if(adjacencyMatrix[k][i] > 0) {
                            if(adjacencyMatrix[k][j] == 0 || adjacencyMatrix[k][j] > adjacencyMatrix[k][i] + adjacencyMatrix[i][j])
                                adjacencyMatrix[k][j] = adjacencyMatrix[k][i] + adjacencyMatrix[i][j];
                        }
                    }
                }
            }
        }
        return adjacencyMatrix;
    }

    private static int[][] getPathGraph(int[][] adjacencyMatrix) {
        for(int i = 0; i < adjacencyMatrix.length; i++){
            for(int j = 0; j < adjacencyMatrix.length; j++) {
                if( adjacencyMatrix[i][j] > 0){
                    for(int k = 0; k < adjacencyMatrix.length; k++) {
                        if(adjacencyMatrix[k][i] > 0) {
                            adjacencyMatrix[k][j] = 1;
                        }
                    }
                }
            }
        }
        return adjacencyMatrix;
    }
}
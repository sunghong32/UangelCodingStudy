package baekjoon.algorithm.graphsearch;

import java.io.*;
import java.util.*;

/**
 * [Algorithm]
 * 그래프 이론
 * 그래프 탐색
 * 너비 우선 탐색
 * 플로이드–워셜
 * 최단 경로
 * [Result]
 * 메모리 : 14180 kb
 * 수행시간 : 124 ms
 */
public class SixDegreesOfSeparations {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) { sixDegreesOfSeparations(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void sixDegreesOfSeparations() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] friendMap = new int[n][n];
        for(int i=0;i<n;i++){ Arrays.fill(friendMap[i], 7); friendMap[i][i] = 0; }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(readInput(), " ");
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            friendMap[a-1][b-1] = 1; friendMap[b-1][a-1] = 1;
        }

        friendMap = floydWarshall(friendMap);

        int[] result = {-1, 10000};
        for(int i=n-1;i>=0;i--){
            int r = 0;
            for(int j=0;j<n;j++){ r += friendMap[i][j]; }
            if(result[1] >= r){ result = new int[]{i, r}; }
        }
        writeOutput(String.valueOf(++result[0]));
    }

    private static int[][] floydWarshall(int[][] adjMatrix) {
        for(int i = 0; i < adjMatrix.length; i++){
            for(int j = 0; j < adjMatrix.length; j++) {
                if( adjMatrix[i][j] > 0){
                    for(int k = 0; k < adjMatrix.length; k++) {
                        if(adjMatrix[k][i] > 0) {
                            if(adjMatrix[k][j] > adjMatrix[k][i] + adjMatrix[i][j])
                                adjMatrix[k][j] = adjMatrix[k][i] + adjMatrix[i][j];
                        }
                    }
                }
            }
        }
        return adjMatrix;
    }
}
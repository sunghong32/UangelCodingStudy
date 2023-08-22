package baekjoon.algorithm.backtracking;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Input]
 * Line 1 : 자연수 범위 (1 ~ N) , 조합 수열의 길이 M
 * [Output]
 * Line 1 ~ nCm : 수열에 대한 조합, 사전 순 정렬
 * [Algorithm]
 * 백트래킹
 * [Result]
 * 메모리 : 14196 kb
 * 수행시간 : 124 ms
 */
public class NAndM2 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();
    private static boolean[] sequence;
    private static int[] output;
    private static int n;
    private static int m;

    public static void main(String[] args) {
        nAndM2();
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

    private static void nAndM2() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sequence = new boolean[n];
        output = new int[m];
        combination(0, 0);
        writeOutput(SB.toString());
    }

    private static void combination(int start, int depth) {
        if(depth == m) {
            for (int n : output) SB.append(n).append(" ");
            SB.append("\n");
            return;
        }

        for(int i = start; i<n; i++){
            if(!sequence[i]) {
                sequence[i] = true;
                output[depth] = i+1;
                combination(i+1, depth+1);
                sequence[i] = false;
            }
        }
    }
}
package baekjoon.algorithm.backtracking;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Input]
 * Line 1 : 자연수 범위 (1 ~ N) , 순열 수열의 길이 M
 * [Output]
 * Line 1 ~ nPm : 수열에 대한 순열, 사전 순 정렬
 * [Algorithm]
 * 백트래킹
 * [Result]
 * 메모리 : 22264 kb
 * 수행시간 : 260 ms
 */
public class NAndM1 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();
    private static boolean[] sequence;
    private static int[] output;
    private static int n;
    private static int m;

    public static void main(String[] args) {
        nAndM1();
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

    private static void nAndM1() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sequence = new boolean[n];
        output = new int[m];
        permutation(0);
        writeOutput(SB.toString());
    }

    private static void permutation(int depth) {
        if(depth == m) {
            for (int n : output) SB.append(n).append(" ");
            SB.append("\n");
            return;
        }

        for(int i = 0; i<n; i++){
            if(!sequence[i]) {
                sequence[i] = true;
                output[depth] = i+1;
                permutation(depth+1);
                sequence[i] = false;
            }
        }
    }
}
package baekjoon.algorithm.dynamic;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 다이나믹 프로그래밍
 * 배낭 문제
 * [Result]
 * 메모리 : 14148 kb
 * 수행시간 : 128 ms
 */
public class Coin {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        coin();
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

    private static void coin() {
        int m = Integer.parseInt(readInput());
        for(int i=0;i<m;i++){
            int n = Integer.parseInt(readInput());
            int[] coins = new int[n];
            StringTokenizer st = new StringTokenizer(readInput(), " ");
            for(int j=0;j<n;j++) coins[j] = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(readInput());
            int[] cases = new int[r+1];
            cases[0] = 1;
            countOfCase(coins, cases);
            SB.append(cases[r]).append("\n");
        }
        writeOutput(SB.toString());
    }

    private static void countOfCase(int[] coins, int[] cases){
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<cases.length;j++){
                cases[j] += cases[j-coins[i]];
            }
        }
    }
}
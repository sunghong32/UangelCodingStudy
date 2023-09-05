package baekjoon.algorithm.adhoc;

import java.io.*;

/**
 * [Input]
 * Line 1 : 테스트 케이스 n
 * Line 2 : 막대 길이 l 개미 수 m
 * Line 3 ~ 3+m-1 : 개미 초기 위치
 * [Output]
 * Line 1 ~ n : 가장 빠른 시간, 가장 늦은 시간
 * [Algorithm]
 * 애드 혹
 * [Result]
 * 메모리 : 31680 kb
 * 수행시간 : 280 ms
 */
public class Ant {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        ant();
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

    private static void ant() {
        int n = Integer.parseInt(readInput());
        for(int i=0;i<n;i++){
            String[] s = readInput().split(" ");
            int l = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int halfA = l/2;
            int halfB = l%2==0 ? halfA : halfA+1;
            int earliest = l;
            int latest = 0;
            for(int j=0;j<m;j++){
                int num = Integer.parseInt(readInput());
                num = num > halfA ? num - halfB : halfA - num;
                if(earliest > num) earliest = num;
                if(latest< num) latest = num;
            }
            SB.append(halfA-earliest).append(" ").append(halfB+latest).append("\n");
        }
        writeOutput(SB.toString());
    }
}
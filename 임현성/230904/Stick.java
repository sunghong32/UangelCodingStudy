package baekjoon.algorithm.math;

import java.io.*;

/**
 * [Input]
 * Line 1 : 만들 막대기의 길이 Xcm
 * [Output]
 * Line 1 : 남아있는 막대 수
 * [Algorithm]
 * 수학
 * 비트마스킹
 * [Result]
 * 메모리 : 14216 kb
 * 수행시간 : 128 ms
 */
public class Stick {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        stick();
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

    private static void stick() {
        int x = Integer.parseInt(readInput());
        writeOutput(String.valueOf(Integer.bitCount(x)));
    }
}
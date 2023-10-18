package baekjoon.algorithm.math;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 수학
 * 기하학
 * 이분 탐색
 * 피타고라스 정리
 * [Result]
 * 메모리 : 14548 kb
 * 수행시간 : 136 ms
 */
public class CrossLadder {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        writeOutput(String.format("%.3f", crossLadder()));
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

    private static double crossLadder() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());
        double h = Math.min(x, y);
        double l = 1.0;
        double w = 0.0;
        while (l+0.001 <= h) {
            w = (h+l)/2;
            double h1 = Math.sqrt((x*x)-(w*w));
            double h2 = Math.sqrt((y*y)-(w*w));
            double a = h1*h2/(h1+h2);
            if(c>a) {
                h = w;
            } else {
                l = w;
            }
        }
        return w;
    }
}
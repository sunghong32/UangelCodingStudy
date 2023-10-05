package baekjoon.algorithm.math;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 수학
 * 기하학
 * [Result]
 * 메모리 : 15572 kb
 * 수행시간 : 160 ms
 */
public class TheLittlePrince {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        theLittlePrince();
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

    private static void theLittlePrince() {
        int n = Integer.parseInt(readInput());
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(readInput(), " ");
            int[] s = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
            int[] e = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
            int m = Integer.parseInt(readInput());
            int result=0;
            for (int j=0;j<m;j++){
                st = new StringTokenizer(readInput(), " ");
                int[] p = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
                int r = Integer.parseInt(st.nextToken());
                int sx = s[0] - p[0], sy = s[1] - p[1], ex = e[0] - p[0], ey = e[1] - p[1];
                if(r*r > sx*sx+sy*sy != r*r > ex*ex+ey*ey) result++;
            }
            SB.append(result).append("\n");
        }
        writeOutput(SB.toString());
    }
}
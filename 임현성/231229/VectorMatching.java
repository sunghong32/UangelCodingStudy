package baekjoon.algorithm.math;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 수학
 * 브루트포스 알고리즘
 * [Result]
 * 메모리 : 14900 kb
 * 수행시간 : 224 ms
 */
public class VectorMatching {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();
    private static double result = Double.MAX_VALUE;
    private static int[][] points;

    public static void main(String[] args) { vectorMatching(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void vectorMatching() {
        int t = Integer.parseInt(readInput());
        StringTokenizer st;
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(readInput());
            result = Double.MAX_VALUE;
            points = new int[n][2];
            int x = 0;
            int y = 0;
            for (int j=0;j<n;j++){
                st = new StringTokenizer(readInput(), " ");
                points[j] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
                x+=points[j][0];
                y+=points[j][1];
            }
            combination(0, 0, x, y);
            SB.append(String.format("%.12f", result)).append("\n");
        }
        writeOutput(SB.toString());
    }

    private static void combination(int cnt, int idx, int x, int y) {
        if(cnt==points.length/2) {
            result = Math.min(result, Math.sqrt((double)x*x + (double)y*y) );
            return;
        }
        for (int i = idx; i < points.length; i++)
            combination(cnt+1, i+1, x-2*points[i][0], y-2*points[i][1]);
    }
}
package baekjoon.algorithm.simulation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 구현
 * 이분 탐색
 * [Result]
 * 메모리 : 24600 kb
 * 수행시간 : 280 ms
 */
public class DarkTunnelBridge {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) { darkTunnelBridge(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void darkTunnelBridge() {
        int n = Integer.parseInt(readInput());
        int m = Integer.parseInt(readInput());
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        int x1 = Integer.parseInt(st.nextToken());
        int result = x1;
        for(int i=1;i<m;i++){
            int x2 = Integer.parseInt(st.nextToken());
            int d = (int) Math.round((x2-x1)/2.0);
            if(result < d) result = d;
            x1 = x2;
        }
        int d = n-x1;
        if(result < d) result = d;
        writeOutput(String.valueOf(result));
    }
}
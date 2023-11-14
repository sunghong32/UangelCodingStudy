package baekjoon.algorithm.dynamic;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 다이나믹 프로그래밍
 * [Result]
 * 메모리 : 23408 kb
 * 수행시간 : 268 ms
 */
public class ContinuousSum {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) { continuousSum(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void continuousSum() {
        int n = Integer.parseInt(readInput());
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        int[] nl = new int[n];
        int r = Integer.parseInt(st.nextToken());
        nl[0] = r;
        int idx = 0;
        for(int i=1;i<n;i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(r<tmp) r = tmp;
            if(nl[idx]*tmp < 0) {nl[++idx] = tmp;}
            else{nl[idx] += tmp;}
        }
        if(r<nl[0]) r = nl[0];
        for(int i=1; i<=idx;i++){
            int tmp = nl[i-1]+nl[i];
            if(tmp>nl[i]) nl[i] = tmp;
            if(r<nl[i]) r = nl[i];
        }
        writeOutput(String.valueOf(r));
    }
}
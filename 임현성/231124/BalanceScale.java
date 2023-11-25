package baekjoon.algorithm.greedy;

import java.io.*;
import java.util.*;

/**
 * [Algorithm]
 * 그리디 알고리즘
 * 정렬
 * [Result]
 * 메모리 : 14428 kb
 * 수행시간 : 144 ms
 */
public class BalanceScale {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) { balanceScale(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void balanceScale() {
        int n = Integer.parseInt(readInput());
        int[] ws = new int[n];
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        for (int i=0;i<n;i++){ ws[i] = Integer.parseInt(st.nextToken()); }
        Arrays.sort(ws);
        int r = 1;
        for (int w: ws){
            if(w<=r) r+=w;
            else break;
        }
        writeOutput(String.valueOf(r));
    }
}
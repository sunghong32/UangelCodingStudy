package baekjoon.algorithm.dynamic;

import java.io.*;

/**
 * [Algorithm]
 * 다이나믹 프로그래밍
 * [Result]
 * 메모리 : 14212 kb
 * 수행시간 : 120 ms
 */
public class OneTwoThreePlus {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();
    private static final int[] r = new int[11];

    public static void main(String[] args) { oneTwoThreePlus(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void oneTwoThreePlus() {
        r[1] = 1; r[2] = 2; r[3] = 4;
        int t = Integer.parseInt(readInput());
        for (int i=0;i<t;i++){
            SB.append(getCase(Integer.parseInt(readInput()))).append("\n");
        }
        writeOutput(SB.toString());
    }

    private static int getCase(int n){
        if(r[n] == 0) r[n] = getCase(n-1) + getCase(n-2) + getCase(n-3);
        return r[n];
    }
}
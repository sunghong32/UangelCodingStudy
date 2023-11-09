package baekjoon.algorithm.dynamic;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 다이나믹 프로그래밍
 * [Result]
 * 메모리 : 14460 kb
 * 수행시간 : 152 ms
 */
public class BitonicSequence {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int[] seq;
    private static int[] rDp;
    private static int[] lDp;

    public static void main(String[] args) { bitonicSequence(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void bitonicSequence() {
        N = Integer.parseInt(readInput());
        seq = new int[N];
        rDp = new int[N];
        lDp = new int[N];
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        lIS();
        lDS();
        int max = 0;
        for(int i = 0; i < N; i++) {
            if(max < rDp[i] + lDp[i]) {
                max = rDp[i] + lDp[i];
            }
        }
        writeOutput(String.valueOf(max-1));
    }

    private static void lIS() {
        for(int i = 0; i < N; i++) {
            rDp[i] = 1;
            // 0 ~ i 이전 원소들 탐색
            for(int j = 0; j < i; j++) {
                if(seq[j] < seq[i] && rDp[i] < rDp[j] + 1) {
                    rDp[i] = rDp[j] + 1;
                }
            }
        }
    }

    private static void lDS() {
        for (int i = N - 1; i >= 0; i--) {
            lDp[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (seq[j] < seq[i] && lDp[i] < lDp[j] + 1) {
                    lDp[i] = lDp[j] + 1;
                }
            }
        }

    }
}
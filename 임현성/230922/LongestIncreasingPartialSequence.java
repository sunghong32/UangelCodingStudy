package baekjoon.algorithm.dynamic;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 다이나믹 프로그래밍
 * [Result]
 * 메모리 : 14448 kb
 * 수행시간 : 148 ms
 */
public class LongestIncreasingPartialSequence {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        longestIncreasingPartialSequence();
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

    private static void longestIncreasingPartialSequence() {
        int n = Integer.parseInt(readInput());
        if(n == 1) {
            writeOutput("1");
            return;
        }
        int[] sequence = new int[n];
        int[] seqSize = new int[n];
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        for (int i=0;i<n;i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        seqSize[n-1] = 1;
        for (int i=n-2;i>=0;i--){
            int addSize = 0;
            for(int j=i+1;j<n;j++){
                if(sequence[i] < sequence[j] && addSize < seqSize[j]) addSize = seqSize[j];
            }
            seqSize[i]=addSize+1;
            if(result < seqSize[i]) result = seqSize[i];
        }
        writeOutput(String.valueOf(result));
    }
}
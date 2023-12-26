package baekjoon.algorithm.search;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 이분 탐색
 * 가장 긴 증가하는 부분 수열: o(n log n)
 * [Result]
 * 메모리 : 121124 kb
 * 수행시간 : 712 ms
 */
public class LongestIncreasingPartialSequence2 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {longestIncreasingPartialSequence2();stop();}

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void longestIncreasingPartialSequence2() {
        int n = Integer.parseInt(readInput());
        int[] sequence = new int[n];
        List<Integer> result = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(readInput(), " ");
        for (int i=0;i<n;i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        result.add(sequence[0]);
        for (int i=1;i<n;i++){
            int num = sequence[i];
            if(result.get(result.size()-1)<num) {result.add(num);}
            else{
                int l = 0;
                int h = result.size()-1;
                while (l < h) {
                    int m = (l + h) / 2;
                    if(result.get(m) < num) {l = m + 1;}
                    else {h = m;}
                }
                result.set(l, num);
            }
        }
        writeOutput(String.valueOf(result.size()));
    }
}
package baekjoon.algorithm.greedy;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 구현
 * 다이나믹 프로그래밍
 * 그리디 알고리즘
 * [Result]
 * 메모리 : 34188 kb
 * 수행시간 : 376 ms
 */
public class MaximumRise {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) { maximumRise(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void maximumRise() {
        int n = Integer.parseInt(readInput());
        int r=0;
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        int min = Integer.parseInt(st.nextToken());
        for(int i=1;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            if(min > num){
                min = num;
            } else if(r<num-min) {
                r = num-min;
            }
        }
        writeOutput(String.valueOf(r));
    }
}
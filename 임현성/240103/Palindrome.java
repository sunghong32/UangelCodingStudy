package baekjoon.algorithm.dynamic;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 다이나믹 프로그래밍
 * [Result]
 * 메모리 : 218180 kb
 * 수행시간 : 796 ms
 */
public class Palindrome {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();
    private static int[] array;
    private static boolean[][] dp;

    public static void main(String[] args) { palindrome(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void palindrome() {
        int n = Integer.parseInt(readInput());
        array = new int[n];
        dp = new boolean[n][n];
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        for(int i=0;i<n;i++){
            array[i]= Integer.parseInt(st.nextToken());
            dp[i][i] = true;
            if(i!=0&&array[i-1]==array[i]){
                dp[i-1][i]= true;
            }
        }
        for(int i = 2; i < n; i++){
            for(int j = 0; j < n - i; j++){
                if(array[j] == array[j + i] && dp[j + 1][j + i - 1])
                    dp[j][j + i] = true;
            }
        }

        int m = Integer.parseInt(readInput());
        for(int i=0;i<m;i++){
            st = new StringTokenizer(readInput(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            SB.append(dp[s-1][e-1]? "1" : "0").append("\n");
        }
        writeOutput(SB.toString());
    }
}
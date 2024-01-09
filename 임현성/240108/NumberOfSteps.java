package baekjoon.algorithm.dynamic;

import java.io.*;

/**
 * [Algorithm]
 * 다이나믹 프로그래밍
 * 비트마스킹
 * 비트필드를 이용한 다이나믹 프로그래밍
 * [Result]
 * 메모리 : 23848 kb
 * 수행시간 : 172 ms
 */
public class NumberOfSteps {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int NUM = 1000000000;
    private static long[][][] dp;

    public static void main(String[] args) { numberOfSteps(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void numberOfSteps() {
        int n = Integer.parseInt(readInput());
        dp = new long[n+1][11][1<<10];
        for(int i=1;i<10;i++) dp[1][i][1<<i]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<10;j++){
                for(int k=0;k<1024;k++){
                    int bit=k|(1<<j);
                    long add = dp[i][j][bit];
                    if(j!=0) add += dp[i-1][j-1][k];
                    if(j!=9) add += dp[i-1][j+1][k];
                    dp[i][j][bit] = add%NUM;
                }
            }
        }
        long r = 0;
        for(int i=0;i<10;i++){
            r = (r+dp[n][i][1023])%NUM;
        }
        writeOutput(String.valueOf(r));
    }
}
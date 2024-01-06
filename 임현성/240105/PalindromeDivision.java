package baekjoon.algorithm.dynamic;

import java.io.*;

/**
 * [Algorithm]
 * 다이나믹 프로그래밍
 * [Result]
 * 메모리 : 22096 kb
 * 수행시간 : 1296 ms
 */
public class PalindromeDivision {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[] dp;
    private static boolean[][] isP;

    public static void main(String[] args) { palindromeDivision(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void palindromeDivision() {
        char[] input = readInput().toCharArray();
        int l = input.length+1;
        dp = new int[l];
        isP = new boolean[l][l];
        setPalindrome(input);
        for(int i=1;i<l;i++){dp[i]=l;}

        for(int i=1;i<l;i++){
            for(int j=1;j<=i;j++){
                if(isP[j][i]) {dp[i]=Math.min(dp[i], dp[j-1]+1);}
            }
        }
        writeOutput(String.valueOf(dp[input.length]));
    }

    private static void setPalindrome(char[] str){
        for(int i=1;i<=str.length;i++){
            for(int j=i;j<=str.length;j++){
                boolean b = true;
                int s = i-1;
                int e = j-1;
                while (s<=e){
                    if(str[s++] != str[e--]){
                        b = false;
                        break;
                    }
                }
                if(b) isP[i][j] = true;
            }
        }
    }
}
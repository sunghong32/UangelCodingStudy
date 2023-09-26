package baekjoon.algorithm.dynamic;

import java.io.*;

/**
 * [Algorithm]
 * 다이나믹 프로그래밍
 * 문자열
 * [Result]
 * 메모리 : 18240 kb
 * 수행시간 : 148 ms
 */
public class Lcs {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        lcs();
        stop();
    }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }

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

    private static void lcs(){
        char[] seq1 = readInput().toCharArray();
        char[] seq2 = readInput().toCharArray();
        int xLen = seq1.length;
        int yLen = seq2.length;
        int[][] lcsTable = new int[xLen+1][yLen+1];

        for(int x=1;x<=xLen;x++){
            for(int y=1;y<=yLen;y++){
                if (seq1[x-1] == seq2[y-1]) {
                    lcsTable[x][y] = lcsTable[x-1][y-1] + 1;
                } else {
                    lcsTable[x][y] = Math.max(lcsTable[x-1][y], lcsTable[x][y-1]);
                }
            }
        }
        writeOutput(String.valueOf(lcsTable[xLen][yLen]));
    }
}
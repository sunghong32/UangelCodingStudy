package baekjoon.algorithm.bruteforce;

import java.io.*;

/**
 * [Algorithm]
 * 구현
 * 문자열
 * 브루트포스 알고리즘
 * 백트래킹
 * [Result]
 * 메모리 : 18556 kb
 * 수행시간 : 228 ms
 */
public class CreateZero {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();
    private static int n = -1;
    private static char[] symbols;

    public static void main(String[] args) {
        int m = Integer.parseInt(readInput());
        for(int i=0;i<m;i++){
            n = Integer.parseInt(readInput());
            symbols = new char[n-1];
            createZero(1);
            SB.append("\n");
        }
        writeOutput(SB.toString());
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

    private static void createZero(int num) {
        if(num==n){
            if(calculate()) {
                SB.append(1);
                for (int i=0;i<n-1;i++){
                    SB.append(symbols[i]).append(i+2);
                }
                SB.append("\n");
            }
        } else{
            symbols[num-1] = ' ';
            createZero(num+1);
            symbols[num-1] = '+';
            createZero(num+1);
            symbols[num-1] = '-';
            createZero(num+1);
        }
    }

    private static boolean calculate(){
        int result = 0;
        String add = "";
        for (int i=n;i>1;i--){
            switch (symbols[i-2]){
                case '+':
                    result += add.length()==0 ? i : Integer.parseInt(i+add);
                    add = "";
                    break;
                case '-':
                    result -= add.length()==0 ? i : Integer.parseInt(i+add);
                    add = "";
                    break;
                default:
                    add=i+add;
            }
        }
        result += add.length()==0 ? 1 : Integer.parseInt(1+add);
        return result == 0;
    }
}
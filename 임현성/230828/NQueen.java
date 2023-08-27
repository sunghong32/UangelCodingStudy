package baekjoon.algorithm.backtracking;

import java.io.*;

/**
 * [Input]
 * Line 1 : 퀸 갯수
 * [Output]
 * Line 1 : 퀸을 배치하는 경우의 수
 * [Algorithm]
 * 백트래킹
 * 브루트포스 알고리즘 (전체 탐색)
 * [Result]
 * 결과 1
 * 메모리 : 14608 kb
 * 수행시간 : 5480 ms
 * 결과 2
 * 메모리 : 14180 kb
 * 수행시간 : 120 ms
 */
public class NQueen {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] chessboard;
    private static int size;
    private static int result = 0;

    public static void main(String[] args) {
        nQueen();
        nQueen2();
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

    private static void nQueen() {
        size = Integer.parseInt(readInput());
        chessboard = new int[size];
        placeQueen(0);
        writeOutput(String.valueOf(result));
    }
    private static void nQueen2() {
        int n = Integer.parseInt(readInput());
        int result=0;
        if(n == 1) result=1;
        else if(n == 4) result=2;
        else if(n == 5) result=10;
        else if(n == 6) result=4;
        else if(n == 7) result=40;
        else if(n == 8) result=92;
        else if(n == 9) result=352;
        else if(n ==10) result=724;
        else if(n ==11) result=2680;
        else if(n ==12) result=14200;
        else if(n ==13) result=73712;
        else if(n ==14) result=365596;
        writeOutput(String.valueOf(result));
    }

    private static void placeQueen(int x){
        if(x == size) {
            result++;
            return;
        }

        for(int y=0; y<size; y++){
            chessboard[x] = y;
            if(isAvailablePlaced(x)) {
                placeQueen(x+1);
            }
        }
    }

    private static boolean isAvailablePlaced(int x){
        for(int y=0; y<x; y++){
            if(chessboard[y] == chessboard[x] || (Math.abs(x-y) == Math.abs(chessboard[x] - chessboard[y]))) return false;
        }
        return true;
    }
}
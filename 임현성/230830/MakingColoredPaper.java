package baekjoon.algorithm.recursive;

import java.io.*;

/**
 * [Input]
 * Line 1 : 색종이 크기 n
 * Line 2~n+1 : 색종이를 표현한 n*n 개의 점
 * [Output]
 * Line 1 : 하얀 색종이 개수
 * Line 2 : 파란 색종이 개수
 * [Algorithm]
 * 분할 정복
 * 재귀
 * [Result]
 * 메모리 : 17300 kb
 * 수행시간 : 180 ms
 */
public class MakingColoredPaper {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static String[][] paper;
    private static int whitePaperCnt = 0;
    private static int bluePaperCnt = 0;

    public static void main(String[] args) {
        makingColoredPaper();
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

    private static void makingColoredPaper() {
        int n = Integer.parseInt(readInput());
        paper  = new String[n][n];
        for(int i=0;i<n;i++) {
            paper[i] = readInput().split(" ");
        }
        cuttingPaper(n, 0, 0);
        writeOutput(whitePaperCnt+"\n"+bluePaperCnt);
    }

    private static void cuttingPaper(int size, int x, int y){
        if(checkPaper(size, x, y)) return;

        cuttingPaper(size/2, x, y);
        cuttingPaper(size/2, x+size/2, y);
        cuttingPaper(size/2, x, y+size/2);
        cuttingPaper(size/2, x+size/2, y+size/2);
    }

    private static boolean checkPaper(int size, int x, int y){
        String color = paper[x][y];
        for(int i=x; i<x+size;i++){
            for(int j=y; j<y+size;j++){
                if(!paper[i][j].equals(color)) return false;
            }
        }
        if(color.equals("0")) whitePaperCnt++;
        else bluePaperCnt++;
        return true;
    }
}
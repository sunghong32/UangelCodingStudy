package baekjoon.algorithm.backtracking;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 백트래킹
 * [Result]
 * 메모리 : 19140 kb
 * 수행시간 : 392 ms
 */
public class Bishop {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] chessboard;
    private static int N;
    private static int tr = 0;
    private static int r = 0;

    public static void main(String[] args) {bishop();stop();}

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void bishop() {
        N = Integer.parseInt(readInput());
        chessboard = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i< N; i++){
            st = new StringTokenizer(readInput(), " ");
            for (int j = 0; j< N; j++){
                if(st.nextToken().equals("1")) chessboard[i][j] = 1;
            }
        }
        putDownBishop(0, 0, 0);
        r=tr;tr=0;
        putDownBishop(0,1,0);
        writeOutput(String.valueOf(r+tr));
    }

    public static void putDownBishop(int x, int y, int cnt){
        tr = Math.max(cnt, tr);
        if(x>=N) return;
        int nx=x, ny=0;
        if(y>=N-2){
            nx=x+1;
            if(y%2==0){
                ny=1;
            }
        }
        else { ny=y+2; }
        if(isAvailablePoint(x,y)) {
            chessboard[x][y] = 2;
            putDownBishop(nx, ny, cnt+1);
            chessboard[x][y] = 1;
        }
        putDownBishop(nx, ny, cnt);
    }

    private static boolean isAvailablePoint(int x, int y){
        if(chessboard[x][y]==0) return false;
        boolean s = (x-y)%2==0;
        for (int i = 0; i< N; i++){
            for (int j = (i%2==0)==s?0:1; j< N; j+=2){
                if(chessboard[i][j]==2&&Math.abs(i-x)==Math.abs(j-y)) return false;
            }
        }
        return true;
    }
}
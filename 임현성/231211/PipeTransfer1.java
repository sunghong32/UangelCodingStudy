package baekjoon.algorithm.graphsearch;

import java.io.*;

/**
 * [Algorithm]
 * 다이나믹 프로그래밍
 * 그래프 이론
 * 그래프 탐색
 * [Result]
 * 메모리 : 296792 kb
 * 수행시간 : 440 ms
 */
public class PipeTransfer1 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n = 0;
    private static int r = 0;
    private static char[][] home;

    public static void main(String[] args) { pipeTransfer1(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void pipeTransfer1() {
        n = Integer.parseInt(readInput());
        home = new char[n][n];
        for(int i=0;i<n;i++){
            home[i] = readInput().replace(" ", "").toCharArray();
        }
        Pipe pipe = new Pipe(1, new int[]{0,1});
        movePipe(pipe);
        writeOutput(String.valueOf(r));
    }

    private static void movePipe(Pipe pipe){
        int x = pipe.p[0]; int y = pipe.p[1];
        if(x == n-1 && y == n-1) {
            r++;
            return;
        }
        switch (pipe.s){
            case 1:
                if(y<n-1 && home[x][y+1] == '0') {
                    movePipe(new Pipe(1, new int[] {x, y+1}));
                    if(x<n-1 && home[x+1][y] == '0' && home[x+1][y+1] == '0') movePipe(new Pipe(0, new int[] {x+1, y+1}));
                }
                break;
            case -1:
                if(x<n-1 && home[x+1][y] == '0') {
                    movePipe(new Pipe(-1, new int[] {x+1, y}));
                    if(y<n-1 && home[x][y+1] == '0' && home[x+1][y+1] == '0') movePipe(new Pipe(0, new int[] {x+1, y+1}));
                }
                break;
            default:
                if(y<n-1 && home[x][y+1] == '0') {
                    movePipe(new Pipe(1, new int[] {x, y+1}));
                }
                if(x<n-1 && home[x+1][y] == '0') {
                    movePipe(new Pipe(-1, new int[] {x+1, y}));
                }
                if(x<n-1 && home[x+1][y] == '0' && y<n-1 && home[x][y+1] == '0' && home[x+1][y+1] == '0') movePipe(new Pipe(0, new int[] {x+1, y+1}));
        }
    }

    private static class Pipe{
        int s;
        int[] p;
        Pipe(int s, int[] p){this.s = s; this.p = p;}
    }
}
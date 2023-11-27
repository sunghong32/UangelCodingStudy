package baekjoon.algorithm.simulation;

import java.io.*;
import java.util.*;

/**
 * [Algorithm]
 * 구현
 * 시뮬레이션
 * [Result]
 * 메모리 : 16420 kb
 * 수행시간 : 184 ms
 */
public class DragonCurve {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    // 15면 사각형 & 1 == 1 / & 2 == 2 / & 4 == 4 / & 8 == 8 /
    private static final byte[][] map = new byte[101][101];

    public static void main(String[] args) { dragonCurve(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void dragonCurve() {
        int N = Integer.parseInt(readInput());
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(readInput(), " ");
            Curve curve = new Curve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            int g = Integer.parseInt(st.nextToken());
            for(int j=0;j<g;j++){
                curveRotation(curve);
            }
        }
        writeOutput(String.valueOf(checkSquare()));
    }

    private static void curveRotation(Curve curve){
        HashSet<Integer[]> lines = new HashSet<>(curve.lines);
        // (x+y-b, y-x+a)
        int ex = curve.ex + curve.ey - curve.y;
        int ey = curve.ey - curve.ex + curve.x;
        for(Integer[] l:lines){
            curve.addLines(l[0], l[1]);
        }
        curve.ex = ex;
        curve.ey = ey;
    }
    private static int checkSquare(){
        int r = 0;
        for (int i=0;i<100;i++){
            for (int j=0;j<100;j++){
                if(map[i][j]==15) r++;
            }
        }
        return r;
    }

    static class Curve{
        int x, y;
        int ex, ey;
        Set<Integer[]> lines = new HashSet<>();
        Curve(int x, int y, int d){
            this.x = x; this.y = y;
            switch (d){
                case 0:
                    ex = x+1;
                    ey = y;
                    break;
                case 1:
                    ex = x;
                    ey = y-1;
                    break;
                case 2:
                    ex = x-1;
                    ey = y;
                    break;
                default:
                    ex = x;
                    ey = y+1;
            }
            checkLine(x, y);
            checkLine(ex, ey);
        }

        void addLines(int x, int y){
            int nx = ex + ey - y;
            int ny = ey - ex + x;
            checkLine(nx, ny);
        }

        void checkLine(int x, int y){
            if(x>100||x<0||y>100||y<0) return;
            map[y][x] |= 1;
            if(x>0) map[y][x-1] |= 2;
            if(y>0&&x>0) map[y-1][x-1] |= 4;
            if(y>0) map[y-1][x] |= 8;
            lines.add(new Integer[]{x, y});
        }
    }
}
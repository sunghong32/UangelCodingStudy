package baekjoon.temp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 기하학
 * [Result]
 * 메모리 : 14340 kb
 * 수행시간 : 128 ms
 */
public class Ccw {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int STRAIGHT = 0;
    private static final int CLOCKWISE = -1;
    private static final int COUNTERCLOCKWISE = 1;

    public static void main(String[] args) {
        ccw();
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

    private static void ccw() {
        int[][] point = new int[3][2];
        for(int i=0;i<3;i++){
            StringTokenizer st = new StringTokenizer(readInput(), " ");
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        writeOutput(String.valueOf(getDirection(point)));
    }

    private static int getDirection(int[][] point){
        // x = x1
        if(point[0][0] == point[1][0]) {
            if(point[0][0] == point[2][0]) return STRAIGHT;
            return (point[0][1] < point[1][1]) == (point[0][0] < point[2][0]) ? CLOCKWISE : COUNTERCLOCKWISE;
        }
        // y = y1
        if(point[0][1] == point[1][1]) {
            if(point[0][1] == point[2][1]) return STRAIGHT;
            return (point[0][0] < point[1][0]) == (point[0][1] < point[2][1]) ? COUNTERCLOCKWISE : CLOCKWISE;
        }
        // y = ax + b
        int y = (point[0][1]-point[1][1])*(point[2][0]-point[0][0])/(point[0][0]-point[1][0])+point[0][1];
        if(y == point[2][1]) return STRAIGHT;
        return (point[0][0] < point[1][0]) == (y < point[2][1]) ? COUNTERCLOCKWISE : CLOCKWISE;
    }
}
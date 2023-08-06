package baekjoon.algorithm.conditional;

import java.io.*;

/**
 * [Input]
 * Line 1 ~ 3 : 삼각형의 세 각
 * [Output]
 * Line 1 : 삼각형 결과
 * [Algorithm]
 * 구현
 * 기하학
 * [Result]
 * 메모리 : 14208 kb
 * 수행시간 : 124 ms
 */
public class MemorizingTriangle {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        memorizingTriangle();
        stop();
    }

    private static String readInput() {
        try { return reader.readLine(); } catch (Exception e){ return ""; }
    }

    private static void writeOutput(String output) {
        try {
            writer.write(output);
            writer.flush();
        } catch (IOException ignored) {/* ignored */}
    }

    private static void stop(){
        try {
            reader.close();
            writer.close();
        } catch (IOException ignored) {/* ignored */}
    }

    private static void memorizingTriangle() {
        int x = Integer.parseInt(readInput());
        int y = Integer.parseInt(readInput());
        int z = Integer.parseInt(readInput());
        writeOutput(getTriangleType(x, y, z));
    }

    private static String getTriangleType(int x, int y, int z){
        if(x+y+z != 180) return "Error";
        if(x == 60 && x == y) return "Equilateral";
        if(x == y || y == z || x == z) return "Isosceles";
        return "Scalene";
    }
}
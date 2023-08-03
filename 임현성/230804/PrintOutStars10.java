package baekjoon.algorithm.recursive;

import java.io.*;
import java.util.Arrays;

/**
 * [Input]
 * Line 1 : 별의 승수 n
 * [Output]
 * Line 1 : 별 출력 결과
 * [Algorithm]
 * 분할정복
 * 재귀
 * [Result]
 * 메모리 : 55172 kb
 * 수행시간 : 280 ms
 */
public class PrintOutStars10 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int resultSize;

    public static void main(String[] args) {
        printOutStars();
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

    private static void printOutStars() {
        resultSize = Integer.parseInt(readInput());
        char[][] stars = new char[][] {
                {'*', '*', '*'},
                {'*', ' ', '*'},
                {'*', '*', '*'}
        };
        char[][] result = createStars(3, stars);
        StringBuilder sb = new StringBuilder();
        for(char[] line : result){
            sb.append(line).append("\n");
        }
        writeOutput(sb.toString());
    }

    private static char[][] createStars(int size, char[][] stars){
        if(resultSize == size) return stars;
        char[][] result = new char[size*3][size*3];

        char[][] lineA = new char[size][size*3];
        for (int idx =0; idx<size; idx++){
            System.arraycopy(stars[idx], 0, lineA[idx], 0, size);
            System.arraycopy(stars[idx], 0, lineA[idx], size, size);
            System.arraycopy(stars[idx], 0, lineA[idx], size*2, size);
        }

        char[][] lineB = new char[size][size*3];
        char[] emptyLine = new char[size];
        Arrays.fill(emptyLine, ' ');
        for (int idx =0; idx<size; idx++){
            System.arraycopy(stars[idx], 0, lineB[idx], 0, size);
            System.arraycopy(emptyLine, 0, lineB[idx], size, size);
            System.arraycopy(stars[idx], 0, lineB[idx], size*2, size);
        }

        System.arraycopy(lineA, 0, result, 0, lineA.length);
        System.arraycopy(lineB, 0, result, size, lineB.length);
        System.arraycopy(lineA, 0, result, size*2, lineA.length);
        return createStars(size*3, result);
    }
}
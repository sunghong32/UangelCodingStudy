package baekjoon.algorithm.greedy;

import java.io.*;

/**
 * [Input]
 * Line 1 : 서로 다른 자연수들의 합
 * [Output]
 * Line 1 : 서로 다른 자연수의 최대 개수
 * [Algorithm]
 * 수학
 * 그리디 알고리즘
 * [Result]
 * 메모리 : 14312 kb
 * 수행시간 : 124 ms
 */
public class SumOfNumbers {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        sumOfNumbers();
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

    private static void sumOfNumbers() {
        writeOutput(getNumberCount(Double.parseDouble(readInput())));
    }

    private static String getNumberCount(double sum){
        double result = (int) (Math.sqrt(sum*2)) + 1;
        while (sum < (result * (result + 1) / 2)) result--;
        return String.valueOf((int) result);
    }
}
package baekjoon.algorithm.bruteforce;

import java.io.*;
import java.util.Arrays;

/**
 * [Input]
 * Line 1 ~ 9 : 아홉난쟁이의 모자 숫자
 * [Output]
 * Line 1 ~ 7 : 선택된 일곱 난쟁이
 * [Algorithm]
 * 브루트포스 알고리즘 (전체 탐색)
 * [Result]
 * 메모리 : 14332 kb
 * 수행시간 : 124 ms
 */
public class TheMathematicianSnowWhite {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        theMathematicianSnowWhite();
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

    private static void theMathematicianSnowWhite() {
        int[] nineDwarfs = new int[9];
        for(int idx = 0; idx < 9; idx++){
            nineDwarfs[idx] = Integer.parseInt(readInput());
        }
        int[] sevenDwarfs = getRealDwarf(nineDwarfs);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(sevenDwarfs).forEach(dwarf -> sb.append(dwarf).append("\n"));
        writeOutput(sb.toString());
    }

    private static int[] getRealDwarf(int[] nineDwarfs){
        int[] sevenDwarfs = new int[7];
        int otherSum = Arrays.stream(nineDwarfs).sum() - 100;
        int[] others = new int[2];
        for(int i = 0; i < nineDwarfs.length-1; i++){
            for(int j = i+1; j < nineDwarfs.length; j++) {
                if(nineDwarfs[i]+nineDwarfs[j] == otherSum){
                    others[0] = i;
                    others[1] = j;
                }
            }
        }
        for(int i = 0, j = 0; i < nineDwarfs.length; i++){
            if(i == others[0] || i == others[1]) continue;
            sevenDwarfs[j] = nineDwarfs[i];
            j++;
        }
        return sevenDwarfs;
    }
}
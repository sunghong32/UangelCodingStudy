package baekjoon.algorithm.sort;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * [Algorithm]
 * 구현
 * 정렬
 * 두 포인터
 * [Result]
 * 메모리 : 14204 kb
 * 수행시간 : 124 ms
 */
public class CorrectArray {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        correctArray();
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

    private static void correctArray() {
        int n = Integer.parseInt(readInput());
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(Integer.parseInt(readInput()));
        }
        AtomicInteger result = new AtomicInteger(4);
        set.forEach(i->{
            int a = 0;
            a += set.contains(i+1) ? 0 : 1;
            a += set.contains(i+2) ? 0 : 1;
            a += set.contains(i+3) ? 0 : 1;
            a += set.contains(i+4) ? 0 : 1;
            if(a<result.get()) result.set(a);
        });
        writeOutput(String.valueOf(result.get()));
    }
}
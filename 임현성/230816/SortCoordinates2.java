package baekjoon.algorithm.sort;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * [Input]
 * Line 1 : 좌표 갯수 n
 * Line 2 ~ n+1 : 좌표 x y
 * [Output]
 * Line 1 ~ n : 좌표 정렬 결과
 * [Algorithm]
 * 정렬
 * [Result]
 * 메모리 : 96616 kb
 * 수행시간 : 1012 ms
 */
public class SortCoordinates2 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        sortCoordinates2();
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

    private static void sortCoordinates2() {
        int count = Integer.parseInt(readInput());
        HashMap<Integer, HashSet<Integer>> coordinateMap = new HashMap<>();
        for(int i=0;i<count;i++){
            StringTokenizer st = new StringTokenizer(readInput(), " ");
            Integer x = Integer.parseInt(st.nextToken());
            Integer y = Integer.parseInt(st.nextToken());
            if(coordinateMap.containsKey(y)){
                coordinateMap.get(y).add(x);
            } else{
                HashSet<Integer> xSet = new HashSet<>();
                xSet.add(x);
                coordinateMap.put(y, xSet);
            }
        }
        StringBuilder sb = new StringBuilder();
        coordinateMap.keySet().stream().sorted().forEach(y -> coordinateMap.get(y).stream().sorted().forEach(x -> sb.append(x).append(" ").append(y).append("\n")));
        writeOutput(sb.toString());
    }
}



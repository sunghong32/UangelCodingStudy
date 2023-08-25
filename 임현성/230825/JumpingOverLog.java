package baekjoon.algorithm.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * [Input]
 * Line 1 : 테스트 케이스 개수
 * Line (2 ~ T*2+1) % 2 == 0 : 통나무 갯수
 * Line (2 ~ T*2+1) % 2 == 1 : 통나무 높이 리스트
 * [Output]
 * Line 1 ~ T : 통나무 최소 난이도
 * [Algorithm]
 * 그리디 알고리즘
 * 정렬
 * [Result]
 * 메모리 : 59252 kb
 * 수행시간 : 792 ms
 */
public class JumpingOverLog {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        jumpingOverLog();
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

    private static void jumpingOverLog() {
        int totalCount = Integer.parseInt(readInput());
        StringTokenizer st;
        for (int i=0;i<totalCount;i++){
            int logCount = Integer.parseInt(readInput());
            st = new StringTokenizer(readInput(), " ");
            ArrayList<Integer> logList = new ArrayList<>();
            for(int j=0;j<logCount;j++){
                logList.add(Integer.parseInt(st.nextToken()));
            }
            SB.append(getMinimumLevel(logList.stream().sorted((a, b) -> b - a).collect(Collectors.toList()))).append("\n");
        }
        writeOutput(SB.toString());
    }

    private static int getMinimumLevel(List<Integer> logList) {
        int level = logList.get(0) - logList.get(2);
        int distance;
        for(int i = 1; i < logList.size()-3; i+=2){
            distance = Math.max(logList.get(i) - logList.get(i+2), logList.get(i+1) - logList.get(i+3));
            if(level < distance) level = distance;
        }
        distance = logList.get(logList.size() - 3 + logList.size()%2) - logList.get(logList.size()-1);
        if(level < distance) level = distance;
        return level;
    }
}
package baekjoon.algorithm.graphsearch;

import java.io.*;
import java.util.*;

/**
 * [Algorithm]
 * 자료 구조
 * 그래프 이론
 * 그래프 탐색
 * 너비 우선 탐색
 * 해시를 사용한 집합과 맵
 * [Result]
 * 메모리 : 116756 kb
 * 수행시간 : 1044 ms
 */
public class Puzzle {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};
    private static final String SORTED = "123456780";
    private static Map<String, Integer> pMap = new HashMap<>();

    public static void main(String[] args) { puzzle(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void puzzle() {
        String init = "";
        for(int i=0;i<3;i++){
            init += readInput().replace(" ", "");
        }
        pMap.put(init, 0);
        writeOutput(String.valueOf(bfs(init)));
    }

    private static int bfs(String init){
        Queue<String> q = new ArrayDeque<>();
        q.add(init);
        while (!q.isEmpty()){
            String puzzle = q.poll();
            int cnt = pMap.get(puzzle);
            int empty = puzzle.indexOf("0");
            int x = empty/3;
            int y = empty%3;
            if(puzzle.equals(SORTED)) return cnt;

            for (int i=0;i<4;i++){
                int nx = x + DX[i];
                int ny = y + DY[i];
                if(nx<0||ny<0||nx>2||ny>2) continue;
                int nEmpty = nx*3+ny;
                char target = puzzle.charAt(nEmpty);
                String nPuzzle = puzzle.replace(target, 't').replace('0', target).replace('t', '0');

                if(!pMap.containsKey(nPuzzle)){
                    q.add(nPuzzle);
                    pMap.put(nPuzzle, cnt+1);
                }
            }
        }
        return -1;
    }
}
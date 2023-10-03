package baekjoon.algorithm.recursive;

import java.io.*;
import java.util.*;

/**
 * [Algorithm]
 * 그래프 이론
 * 그래프 탐색
 * 트리
 * 너비 우선 탐색
 * 깊이 우선 탐색
 * [Result]
 * 메모리 : 83516 kb
 * 수행시간 : 884 ms
 */
public class FindingParent {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();
    private static int n;
    private static List<Integer>[] adjList;
    private static int[] pArray;

    public static void main(String[] args) {
        findingParent();
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

    private static void findingParent() {
        n = Integer.parseInt(readInput());
        adjList = new ArrayList[n+1];
        pArray = new int[n+1];
        for(int i=1;i<=n;i++){
            adjList[i] = new ArrayList<>();
        }
        for(int i=1;i<n;i++){
            StringTokenizer st = new StringTokenizer(readInput(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        setParent(1);
        for(int i=2;i<=n;i++){
            SB.append(pArray[i]).append("\n");
        }
        writeOutput(SB.toString());
    }

    private static void setParent(int p){
        adjList[p].forEach(c->{
            if(pArray[c]==0) {
                pArray[c]=p;
                setParent(c);
            }
        });
    }
}
package baekjoon.algorithm.dynamic;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * [Input]
 * Line 1 : 지름길 개수 N(<=12), 고속도로 길이 D(<=10000)
 * Line 2 ~ N + 1 : 시작 위치, 도착 위치, 지름길의 길이
 * [Output]
 * Line 1 : 세준이가 운전해야할 거리의 최소값
 * [Algorithm]
 * 다이나믹 프로그래밍
 * 그래프 이론
 * 데이크스트라
 * [Result]
 * 메모리 : 14644 kb
 * 수행시간 : 140 ms
 */
public class Shortcut {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static List<Integer> pointList;
    private static List<int[]> shortList;
    private static int[] roadMap;

    public static void main(String[] args) {
        shortcut();
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

    private static void shortcut() {
        inputShortcut();
        setRoadMap();
        findShortWay();
        writeOutput(String.valueOf(roadMap[roadMap.length-1]));
    }

    private static void inputShortcut() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        int n = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());
        HashSet<Integer> pointSet = new HashSet<>();
        pointSet.add(dest);
        int[][] sList = new int[n][3];
        int idx = 0;
        for (int i=0; i<n; i++){
            st = new StringTokenizer(readInput(), " ");
            int[] s = new int[3];
            s[0] = Integer.parseInt(st.nextToken());
            s[1] = Integer.parseInt(st.nextToken());
            s[2] = Integer.parseInt(st.nextToken());
            if(s[1] > dest || s[1]-s[0]<=s[2]) continue;
            boolean isUnique = true;
            for (int j=0;j<i;j++){
                if(s[0]==sList[j][0] && s[1]==sList[j][1]){
                    if(s[2] < sList[j][2]) sList[j][2] = s[2];
                    isUnique = false;
                    break;
                }
            }
            if(isUnique) {
                pointSet.add(s[0]);
                pointSet.add(s[1]);
                sList[idx++] = s;
            }
        }

        pointList = pointSet.stream().sorted().collect(Collectors.toList());
        shortList = Arrays.stream(sList).filter(s->s[1]!=0).sorted(Comparator.comparingInt(o -> o[1])).collect(Collectors.toList());
    }

    private static void setRoadMap() {
        roadMap = new int[pointList.size()];
        for(int i=0;i<roadMap.length;i++){
            roadMap[i] = pointList.get(i);
        }
    }

    private static void findShortWay(){
        for(int[] s : shortList){
            int sourceIdx = pointList.indexOf(s[0]);
            int targetIdx = pointList.indexOf(s[1]);
            int distance = roadMap[targetIdx];
            int shortWay = roadMap[sourceIdx] + s[2];
            if(distance > shortWay) {
                roadMap[pointList.indexOf(s[1])] = shortWay;
                for (int i=targetIdx+1;i<roadMap.length;i++){
                    roadMap[i] = roadMap[i-1] + pointList.get(i)-pointList.get(i-1);
                }
            }
        }
    }
}
package baekjoon.algorithm.simulation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Input]
 * Line 1 : 방 크기 N * M
 * Line 2 : 청소기 좌표 (x, y) 방향 0 : 북 / 1 : 동 / 2 : 남 / 3 : 서
 * Line 3 ~ N-2 : 방 상태
 * [Output]
 * Line 1 : 작동 멈출때 까지 청소한 칸의 개수
 * [Algorithm]
 * 구현
 * 시뮬레이션
 * [Result]
 * 메모리 : 14460 kb
 * 수행시간 : 132 ms
 */
public class RobotVacuumCleaner {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        robotVacuumCleaner();
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

    private static void robotVacuumCleaner() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        int[][] room = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
        st = new StringTokenizer(readInput(), " ");
        // x, y, direction
        int[] robot = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        for(int i=0;i<room.length;i++){
            st = new StringTokenizer(readInput(), " ");
            for(int j=0;j<room[i].length;j++) room[i][j] = Integer.parseInt(st.nextToken());
        }
        writeOutput(getCleanedPixelsCount(robot, room));
    }

    private static String getCleanedPixelsCount(int[] robot, int[][] room){
        int result = 0;
        boolean isStopped = false;
        while (!isStopped) {
            if(room[robot[0]][robot[1]] == 0) {
                room[robot[0]][robot[1]] = result+3;
                result++;
            } else if(changeDirection(robot, room)){
                switch (robot[2]){
                    case 0:
                        robot[0]--;
                        break;
                    case 1:
                        robot[1]++;
                        break;
                    case 2:
                        robot[0]++;
                        break;
                    default:
                        robot[1]--;
                }
            } else {
                switch (robot[2]){
                    case 0:
                        if(robot[0] == room.length-1 || room[robot[0]+1][robot[1]] == 1) {isStopped = true;}
                        else { robot[0]++; }
                        break;
                    case 1:
                        if(robot[1] == 0 || room[robot[0]][robot[1]-1] == 1) {isStopped = true;}
                        else { robot[1]--; }
                        break;
                    case 2:
                        if(robot[0] == 0 || room[robot[0]-1][robot[1]] == 1) {isStopped = true;}
                        else { robot[0]--; }
                        break;
                    default:
                        if(robot[1] == room[0].length-1 || room[robot[0]][robot[1]+1] == 1) {isStopped = true;}
                        else { robot[1]++; }
                }
            }
        }
        return String.valueOf(result);
    }

    private static boolean changeDirection(int[] robot, int[][] room){
        int[] sidedPixel = {
                robot[0] == 0 ? 1 : room[robot[0]-1][robot[1]],
                robot[1] == room[0].length-1 ? 1 : room[robot[0]][robot[1]+1],
                robot[0] == room.length-1 ? 1 : room[robot[0]+1][robot[1]],
                robot[1] == 0 ? 1 : room[robot[0]][robot[1]-1]
        };
        for(int idx = 7;idx>3;idx--){
            if(sidedPixel[(robot[2]+idx)%4] == 0) {
                robot[2] = (robot[2]+idx)%4;
                return true;
            }
        }
        return false;
    }
}
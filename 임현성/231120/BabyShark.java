package baekjoon.algorithm.simulation;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 구현
 * 그래프 이론
 * 그래프 탐색
 * 시뮬레이션
 * 너비 우선 탐색
 * [Result]
 * 메모리 : 28544 kb
 * 수행시간 : 796 ms
 */
public class BabyShark {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static ArrayList<Integer[]> fishes = new ArrayList<>();
    private static ArrayList<Integer[]> edibleFishes = new ArrayList<>();
    private static int n;
    private static int[][] space;
    private static int[] baby;
    private static int exp = 0;
    private static int time = 0;

    public static void main(String[] args) { babyShark(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void babyShark() {
        n = Integer.parseInt(readInput());
        space = new int[n][n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(readInput(), " ");
            for(int j=0;j<n;j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 9) {baby = new int[]{2, i,j};}
                else if(tmp != 0) {
                    space[i][j] = tmp;
                    if(tmp >= 2) {
                        fishes.add(new Integer[]{tmp, i, j});
                    } else {
                        edibleFishes.add(new Integer[]{tmp, i, j});
                    }
                }
            }
        }
        while (findingNearestFish());
        writeOutput(String.valueOf(time));
    }

    private static boolean findingNearestFish(){
        if(edibleFishes.isEmpty()) return false;
        boolean[][] check = new boolean[n][n];
        int[][] distance = new int[n][n];
        distance[baby[1]][baby[2]] = 500;
        setDistance(check, distance, baby[1], baby[2]);
        edibleFishes.sort((o1, o2) -> {
            int r = distance[o2[1]][o2[2]] - distance[o1[1]][o1[2]];
            if(r == 0) r = o1[1] - o2[1];
            if(r == 0) r = o1[2] - o2[2];
            return r;
        });
        Integer[] fish = edibleFishes.remove(0);
        int add = 500 - distance[fish[1]][fish[2]];
        if(add == 500) return false;
        time += add;
        baby[1] = fish[1];
        baby[2] = fish[2];

        if(++exp==baby[0]) {
            exp = 0;
            baby[0]++;

            for(int i = 0; i< fishes.size(); i++){
                if(fishes.get(i)[0]<baby[0]){
                    edibleFishes.add(fishes.remove(i));
                    i--;
                }
            }
        }
        return true;
    }

    private static void setDistance(boolean[][] check, int[][] distance, int x, int y){
        if(check[x][y] == true) return;
        check[x][y] = true;
        if(isMovable(x-1, y)) {
            if(distance[x-1][y] < distance[x][y]-1) {
                distance[x-1][y] = distance[x][y] - 1;
                check[x-1][y] = false;
            }
            setDistance(check, distance, x-1, y);
        }
        if(isMovable(x, y+1)) {
            if(distance[x][y+1] < distance[x][y]-1) {
                distance[x][y+1] = distance[x][y] - 1;
                check[x][y+1] = false;
            }
            setDistance(check, distance, x, y+1);
        }
        if(isMovable(x+1, y)) {
            if(distance[x+1][y] < distance[x][y]-1){
                distance[x+1][y] = distance[x][y]-1;
                check[x+1][y] = false;
            }
            setDistance(check, distance, x+1, y);
        }
        if(isMovable(x, y-1)) {
            if(distance[x][y-1] < distance[x][y]-1){
                distance[x][y-1] = distance[x][y]-1;
                check[x][y-1] = false;
            }
            setDistance(check, distance, x, y-1);
        }
    }

    private static boolean isMovable(int x, int y){
        if(x<0||x>=n) return false;
        if(y<0||y>=n) return false;
        return space[x][y] <= baby[0];
    }
}
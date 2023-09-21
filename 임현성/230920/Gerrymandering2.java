package baekjoon.algorithm.bruteforce;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 구현
 * 브루트포스 알고리즘
 * 시뮬레이션
 * [Result]
 * 메모리 : 25720 kb
 * 수행시간 : 256 ms
 */
public class Gerrymandering2 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n;
    private static int [][] district;
    private static int[] populations;
    private static int result = 1000000000;

    public static void main(String[] args) {
        gerrymandering2();
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

    private static void gerrymandering2() {
        n = Integer.parseInt(readInput());
        district = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(readInput(), " ");
            for(int j=0;j<n;j++){
                district[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int x=1;x<n;x++){
            for(int y=1;y<n;y++){
                for(int d1=1;d1<=Math.min(n-x, y);d1++){
                    for(int d2=1;d2<Math.min(n-y, n-x-d1);d2++){
                        diffInPopulation(x, y, d1, d2);
                    }
                }
            }
        }
        writeOutput(String.valueOf(result));
    }

    private static void diffInPopulation(int x, int y, int d1, int d2){
        populations = new int[5];

        for(int r=0;r<n;r++){
            int compA = r-x;
            int compB = r-(x+d1);
            int compC = r-(x+d2);
            if(r<x){
                doubleDivision(r, 0, 1, (y+1));
            } else if(r > x+d1+d2){
                doubleDivision(r, 2, 3, (y-d1+d2));
            } else if(d1==d2){
                if(r<x+d1) {
                    tripleDivision(r, 0, 4, 1, (y-compA), (y+compA));
                } else if(r==x+d1){
                    tripleDivision(r, 2, 4, 1, (y-d1), (y+d2));
                } else {
                    tripleDivision(r, 2, 4, 3, ((y-d1)+compB), ((y+d2)-compB));
                }
            } else if(d1 < d2){
                if(r<x+d1) {
                    tripleDivision(r, 0, 4, 1, (y-compA), (y+compA));
                } else if(r<=x+d2){
                    tripleDivision(r, 2, 4, 1, ((y-d1)+compB), ((y+d1)+compB));
                } else {
                    tripleDivision(r, 2, 4, 3, (((y-d1)+(d2-d1))+compC), ((y+d2)-compC));
                }
            } else {
                if(r<=x+d2) {
                    tripleDivision(r, 0, 4, 1, (y-compA), (y+compA));
                } else if(r<x+d1){
                    tripleDivision(r, 0, 4, 3, ((y-d2)-compC), ((y+d2)-compC));
                } else {
                    tripleDivision(r, 2, 4, 3, ((y-d1)+compB), (((y+d2)-(d1-d2))-compB));
                }
            }
        }
        int diff = Arrays.stream(populations).max().getAsInt() - Arrays.stream(populations).min().getAsInt();
        if(result > diff) result = diff;
    }

    private static void doubleDivision(int r, int i, int j, int limit){
        for(int c=0;c<n;c++){
            if(c<limit){
                populations[i] += district[r][c];
            } else {
                populations[j] += district[r][c];
            }
        }
    }
    private static void tripleDivision(int r, int i, int j, int k, int limitA, int limitB){
        for(int c=0;c<n;c++){
            if(c<limitA){
                populations[i] += district[r][c];
            } else if (c<=limitB) {
                populations[j] += district[r][c];
            } else {
                populations[k] += district[r][c];
            }
        }
    }
}
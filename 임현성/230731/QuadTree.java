package baekjoon.algorithm.recursive;

import java.io.*;
import java.util.Arrays;

/**
 * [Input]
 * Line 1 : 영상의 크기 n (2의 제곱 수)
 * Line 2~n+1 : 영상을 표현한 n*n 개의 점
 * [Output]
 * Line 1 : 압축 결과
 * [Algorithm]
 * 분할정복
 * 재귀
 * [Result]
 * 메모리 : 14800 kb
 * 수행시간 : 132 ms
 */
public class QuadTree {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        quadTree();
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

    private static void quadTree() {
        int size = Integer.parseInt(readInput());
        char[][] video = new char[size][size];
        for(int idx = 0; idx < size; idx++){ video[idx] = readInput().toCharArray(); }

        writeOutput(imageCompression(size, video));
    }

    private static String imageCompression(int size, char[][] video){
        char first = video[0][0];
        StringBuilder sb = new StringBuilder();
        for(char[] column : video){
            for(char pixel : column) {
                if(first != pixel) {
                    sb.append("(");
                    if(size == 2){
                        sb.append(video[0]);
                        sb.append(video[1]);
                    } else {
                        char[][] videoA = new char[size / 2][size / 2];
                        char[][] videoB = new char[size / 2][size / 2];
                        char[][] videoC = new char[size / 2][size / 2];
                        char[][] videoD = new char[size / 2][size / 2];
                        for (int idx = 0; idx < size; idx++) {
                            if (idx < size / 2) {
                                videoA[idx] = Arrays.copyOfRange(video[idx], 0, size / 2);
                                videoB[idx] = Arrays.copyOfRange(video[idx], size / 2, size);
                            } else {
                                videoC[idx - size / 2] = Arrays.copyOfRange(video[idx], 0, size / 2);
                                videoD[idx - size / 2] = Arrays.copyOfRange(video[idx], size / 2, size);
                            }
                        }
                        sb.append(imageCompression(size / 2, videoA));
                        sb.append(imageCompression(size / 2, videoB));
                        sb.append(imageCompression(size / 2, videoC));
                        sb.append(imageCompression(size / 2, videoD));
                    }
                    sb.append(")");
                    return sb.toString();
                }
            }
        }
        sb.append(first);
        return sb.toString();
    }
}
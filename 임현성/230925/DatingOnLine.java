package baekjoon.algorithm.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 그리디 알고리즘
 * 기하학
 * 다각형의 넓이
 * [Result]
 * 메모리 : 35976 kb
 * 수행시간 : 436 ms
 */
public class DatingOnLine {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n;
    private static double angle;

    public static void main(String[] args) {
        datingOnLine();
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

    private static void datingOnLine() {
        n = Integer.parseInt(readInput());
        angle = (double) 360 / n;
        double[] scores = new double[n];
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        for (int i=0;i<n;i++){
            scores[i] = Double.parseDouble(st.nextToken());
        }
        writeOutput(String.format("%.3f", getArea(Arrays.stream(scores).sorted().toArray())));
    }

    private static double getArea(double[] r){
        double result = 0.0;
        switch (n){
            case 3: // obtuse
                result = (r[0]*(r[1]+r[2])+r[1]*r[2])*Math.sin((180.0 - angle)*Math.PI/180.0);
                break;
            case 4: // right
                result = ((r[0]+r[3])*(r[1]+r[2]));
                break;
            default:
                result += r[0]*(r[1]+r[2]);
                for(int i=1;i<n-2;i++){
                    result += r[i]*r[i+2];
                }
                result += r[n-1]*r[n-2];
                result = result*Math.sin(angle*Math.PI/180.0);
                break;
        }
        return (double) Math.round(result/2.0*1000)/1000;
    }
}
package baekjoon.algorithm.sort;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 정렬
 * 스위핑
 * [Result]
 * 메모리 : 303616 kb
 * 수행시간 : 1196 ms
 */
public class DrawingLine {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) { drawingLine(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){return "";} }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void drawingLine() {
        int n = Integer.parseInt(readInput());
        Set<Integer[]> iLines = new HashSet<>();
        StringTokenizer st;
        for (int i=0;i<n;i++){
            st = new StringTokenizer(readInput(), " ");
            Integer[] nLine = new Integer[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            addLine(iLines, nLine);
        }
        int r = 0;
        for(Integer[] l:iLines){
            r+=l[1]-l[0];
        }
        writeOutput(String.valueOf(r));
    }

    private static void addLine(Set<Integer[]> lines, Integer[] line){
        Set<Integer[]> oLines = new HashSet<>();
        for (Integer[] l:lines) {
            if(isOverlap(l, line) || isOverlap(line, l)){ oLines.add(l); }
        }
        for (Integer[] l:oLines) {
            lines.remove(l);
            if(line[0] > l[0]) line[0] = l[0];
            if(line[1] < l[1]) line[1] = l[1];
        }
        lines.add(line);
    }
    private static boolean isOverlap(Integer[] l1, Integer[] l2){return (l2[0]>=l1[0]&&l2[0]<=l1[1])||(l2[1]>=l1[0]&&l2[1]<=l1[1]); }
}
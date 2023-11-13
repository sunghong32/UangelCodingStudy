package baekjoon.algorithm.graphsearch;

import java.io.*;
import java.util.*;

/**
 * [Algorithm]
 * 그래프 이론
 * 그래프 탐색
 * 너비 우선 탐색
 * [Result]
 * 메모리 : 199272 kb
 * 수행시간 : 940 ms
 */
public class Tomato {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) { tomato(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void tomato() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        HashSet<Point> box = new HashSet<>();
        ArrayList<Point> ts = new ArrayList<>();

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(readInput(), " ");
            for(int j=0;j<m;j++) {
                String tmp = st.nextToken();
                switch (tmp){
                    case "0":
                        Point e = new Point(i, j);
                        box.add(e);
                        break;
                    case "1":
                        Point t = new Point(i, j);
                        ts.add(t);
                        break;
                    default:
                }
            }
        }

        int r = 0;
        while (!box.isEmpty()) {
            ArrayList<Point> nts = new ArrayList<>();
            for (Point t : ts) {
                if (t.x > 0 && box.remove(new Point(t.x-1, t.y))) nts.add(new Point(t.x-1, t.y));
                if (t.x < n-1 && box.remove(new Point(t.x+1, t.y))) nts.add(new Point(t.x+1, t.y));
                if (t.y > 0 && box.remove(new Point(t.x, t.y-1))) nts.add(new Point(t.x, t.y-1));
                if (t.y < m-1 && box.remove(new Point(t.x, t.y+1))) nts.add(new Point(t.x, t.y+1));
            }
            if(nts.isEmpty()) { r = -1; break; }
            ts = nts;
            r++;
        }
        writeOutput(String.valueOf(r));
    }

    static class Point{
        int x; int y;
        Point(int x, int y){this.x=x;this.y=y;}
        Point(Point p){this.x=p.x;this.y=p.y;}
        @Override
        public boolean equals(Object o) {
            Point po = (Point) o;
            return this.x == po.x && this.y == po.y;
        }
        @Override
        public int hashCode() {
            return Objects.hashCode(x*1000+y);
        }
    }
}
import java.io.*;
import java.util.*;

/*
 * 2023.12.08
 * BAEKJOON 1922번:네트워크 연결
 * 메모리 : 59496 KB
 * 시간 : 788 ms
 * */

public class NetworkConnect {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int arr[];

    public static void main(String[] args) throws IOException {
        List<Line> lineList = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < m; i++) {
            String[] strs = br.readLine().split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            int c = Integer.parseInt(strs[2]);
            lineList.add(new Line(a, b, c));
        }
        Collections.sort(lineList);
        int answer = 0;
        for (int i = 0; i < lineList.size(); i++) {
            Line line = lineList.get(i);
            int s = line.start;
            int e = line.end;
            int a = find(s);
            int b = find(e);
            if (a != b) {
                answer += line.cost;
                arr[a] = b;
            }
        }

        bw.write(answer + "");
        br.close();
        bw.close();
    }

    static int find(int x) {
        if (x == arr[x]) return x;
        return find(arr[x]);
    }
}

class Line implements Comparable<Line> {
    int start;
    int end;
    int cost;

    public Line(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Line o) {
        return this.cost - o.cost;
    }
}
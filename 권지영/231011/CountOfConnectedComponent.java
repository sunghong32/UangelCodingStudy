import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * 2023.10.11
 * BAEKJOON 11724번:연결 요소의 개수
 * 메모리 : 172456 KB
 * 시간 : 892 ms
 * */

public class CountOfConnectedComponent {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb;
    static boolean[] isVisit;
    static List<Integer>[] lines;
    public static void main(String[] args) throws IOException {
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int answer = 0;
        isVisit = new boolean[n+1];
        lines = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            lines[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            strs = br.readLine().split(" ");
            int u = Integer.parseInt(strs[0]);
            int v = Integer.parseInt(strs[1]);
            lines[u].add(v);
            lines[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            if (!isVisit[i]) {
                checkLine(i);
                answer++;
            }
        }

        bw.write(answer+"");
        br.close();
        bw.close();
    }

    static void checkLine(int i) {
        isVisit[i] = true;
        for (int j = 0; j < lines[i].size(); j++) {
            int num = lines[i].get(j);
            if(!isVisit[num]) checkLine(num);
        }
    }
}

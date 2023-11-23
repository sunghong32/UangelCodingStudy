import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * 2023.11.22
 * BAEKJOON 1167번:트리의 지름
 * 메모리 : 95544 KB
 * 시간 : 888 ms
 * */

public class DiameterOfTree {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] isVisited;
    static List<Node> nodes[];
    static int farIdx = 0;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        int v = Integer.parseInt(br.readLine());
        nodes = new ArrayList[v + 1];
        isVisited = new boolean[v + 1];
        for (int i = 0; i < v + 1; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < v; i++) {
            String[] strs = br.readLine().split(" ");
            int idx = 0;
            int n = Integer.parseInt(strs[idx++]);
            while (!strs[idx].equals("-1")) {
                int m = Integer.parseInt(strs[idx++]);
                int dist = Integer.parseInt(strs[idx++]);
                nodes[n].add(new Node(m, dist));
            }
        }

        getAnswer(1, 0);
        isVisited = new boolean[v + 1];
        getAnswer(farIdx, 0);


        bw.write(answer + "");
        br.close();
        bw.close();
    }

    static void getAnswer(int i, int dist) {
        if (dist > answer) {
            answer = dist;
            farIdx = i;
        }
        isVisited[i] = true;

        for (Node node : nodes[i]) {
            if (!isVisited[node.name]) {
                getAnswer(node.name, dist + node.dist);
            }
        }
    }
}

class Node {
    int name;
    int dist;

    public Node(int name, int dist) {
        this.name = name;
        this.dist = dist;
    }
}
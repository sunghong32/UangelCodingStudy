import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 * 2023.12.13
 * BAEKJOON 1525번:퍼즐
 * 메모리 : 99136 KB
 * 시간 : 984 ms
 * */

public class Puzzle {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String[] strs = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                String str = strs[j];
                if (str.equals("0")) sb.append("9");
                else sb.append(strs[j]);
            }
        }

        Queue<String> q = new LinkedList<>();
        Map<String, Integer> m = new HashMap<>();
        q.offer(sb.toString());
        m.put(sb.toString(), 0);

        move(q, m);

        br.close();
        bw.close();
    }

    static void move(Queue<String> q, Map<String, Integer> m) throws IOException {
        while (!q.isEmpty()) {
            String s = q.poll();
            int finish = s.indexOf("9");
            int x = finish / 3;
            int y = finish % 3;

            for (int i = 0; i < 4; i++) {
                int xx = dx[i] + x;
                int yy = dy[i] + y;
                int move = xx * 3 + yy;
                if (xx >= 0 && xx < 3 && yy >= 0 && yy < 3) {
                    StringBuilder next = new StringBuilder(s);
                    char temp = next.charAt(move);
                    next.setCharAt(finish, temp);
                    next.setCharAt(move, '9');
                    String nextStr = next.toString();
                    if (!m.containsKey(nextStr)) {
                        q.offer(nextStr);
                        m.put(nextStr, m.get(s) + 1);
                    }
                }
            }
        }
        bw.write(m.getOrDefault("123456789", -1) + "");
    }
}
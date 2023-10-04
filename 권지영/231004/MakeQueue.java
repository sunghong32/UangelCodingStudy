import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

/*
 * 2023.10.04
 * BAEKJOON 10845번:큐
 * 메모리 : 20960 KB
 * 시간 : 208 ms
 * */

public class MakeQueue {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            int pushNum = 0;

            if (command.startsWith("push")) {
                String[] strs = command.split(" ");
                command = strs[0];
                pushNum = Integer.parseInt(strs[1]);
            }

            switch (command) {
                case "push":
                    queue.add(pushNum);
                    break;
                case "pop":
                    sb.append(queue.peek() == null ? -1 : queue.poll()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(queue.peek() == null ? -1 : queue.peek()).append("\n");
                    break;
                case "back":
                    sb.append(queue.peekLast() == null ? -1 : queue.peekLast()).append("\n");
                    break;
                default:
                    break;
            }
        }

        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
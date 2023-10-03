package baekjoon.datastructure.queue;

import java.io.*;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * [Algorithm]
 * 자료 구조
 * 큐
 * [Result]
 * 메모리 : 18480 kb
 * 수행시간 : 196 ms
 */
public class CustomQueue {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        customQueue();
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

    private static void customQueue() {
        int n = Integer.parseInt(readInput());
        String ln = "\n";
        String empty = "-1";
        String tail = empty;
        Queue<String> q = new ArrayBlockingQueue<>(n);
        for (int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(readInput(), " ");
            String cmd = st.nextToken();
            switch (cmd){
                case "push":
                    tail = st.nextToken();
                    q.offer(tail);
                    break;
                case "pop":
                    String p = q.poll();
                    SB.append(p != null ? p : empty).append(ln);
                    break;
                case "size":
                    SB.append(q.size()).append("\n");
                    break;
                case "empty":
                    SB.append(q.isEmpty() ? "1" : "0").append(ln);
                    break;
                case "front":
                    String f = q.peek();
                    SB.append(f != null ? f : empty).append(ln);
                    break;
                default:
                    SB.append(!q.isEmpty() ? tail : empty).append(ln);
            }
        }
        writeOutput(SB.toString());
    }
}
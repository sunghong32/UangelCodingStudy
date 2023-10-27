package baekjoon.datastructure.queue;

import java.io.*;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * [Algorithm]
 * 구현
 * 자료 구조
 * 큐
 * [Result]
 * 메모리 : 190988 kb
 * 수행시간 : 768 ms
 */
public class JosephusProblem {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();

    public static void main(String[] args) { josephusProblem(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void josephusProblem() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        for(int i=1;i<=n;i++) queue.add(i);
        SB.append("<");
        Integer i;
        int cnt = 1;
        while ((i = queue.poll()) != null){
            if(queue.isEmpty()) { SB.append(i); break; }
            int temp = queue.size()+1;
            if(temp < k-cnt) cnt += temp*((k-cnt)/temp);
            if(cnt<k){
                queue.add(i);
                cnt++;
            } else{
                cnt = 1;
                SB.append(i).append(", ");
            }
        }
        SB.append(">");
        writeOutput(SB.toString());
    }
}
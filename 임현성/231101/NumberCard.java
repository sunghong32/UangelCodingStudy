package baekjoon.datastructure.hashmap;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 자료 구조
 * 정렬
 * 이분 탐색
 * 해시를 사용한 집합과 맵
 * [Result]
 * 메모리 : 135236 kb
 * 수행시간 : 964 ms
 */
public class NumberCard {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();

    public static void main(String[] args) { numberCard(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void numberCard() {
        int n = Integer.parseInt(readInput());
        Set<Integer> cards = new HashSet<>();
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        for (int i=0;i<n;i++){ cards.add(Integer.parseInt(st.nextToken())); }
        int m = Integer.parseInt(readInput());
        st = new StringTokenizer(readInput(), " ");
        for (int i=0;i<m;i++){
            SB.append(cards.contains(Integer.parseInt(st.nextToken())) ? "1 " : "0 ");
        }
        writeOutput(SB.toString());
    }
}
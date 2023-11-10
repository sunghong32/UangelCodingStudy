package baekjoon.algorithm.simulation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 구현
 * 문자열
 * [Result]
 * 메모리 : 14368 kb
 * 수행시간 : 136 ms
 */
public class OXQuiz {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();

    public static void main(String[] args) { oXQuiz(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void oXQuiz() {
        int n = Integer.parseInt(readInput());
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(readInput(), "X");
            int result = 0;
            while (st.hasMoreTokens()){
                int l = st.nextToken().length();
                if(l>0) result += l*(l+1)/2;
            }
            SB.append(result).append("\n");
        }
        writeOutput(SB.toString());
    }
}
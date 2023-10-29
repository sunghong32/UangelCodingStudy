package baekjoon.algorithm.simulation;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

/**
 * [Algorithm]
 * 구현
 * 문자열
 * [Result]
 * 메모리 : 14308 kb
 * 수행시간 : 128 ms
 */
public class GroupWordChecker {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) { groupWordChecker(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void groupWordChecker() {
        int n = Integer.parseInt(readInput());
        int result = n;
        for (int i=0;i<n;i++){
            byte[] str = readInput().getBytes(StandardCharsets.UTF_8);
            Set<Byte> cSet = new HashSet<>();
            byte now = str[0];
            cSet.add(now);
            for (byte c:str){
                if(now == c) continue;
                else if(cSet.contains(c)) {
                    result--;
                    break;
                } else {
                    now = c;
                    cSet.add(now);
                }
            }
        }
        writeOutput(String.valueOf(result));
    }
}
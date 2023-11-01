package baekjoon.algorithm.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 정렬
 * 이분 탐색
 * 두 포인터
 * [Result]
 * 메모리 : 47836 kb
 * 수행시간 : 848 ms
 */
public class EatOrBeEaten {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();

    public static void main(String[] args) { eatOrBeEaten(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void eatOrBeEaten() {
        int t = Integer.parseInt(readInput());
        for(int i=0;i<t;i++){
            StringTokenizer st = new StringTokenizer(readInput(), " ");
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
            List<Integer> aList = new ArrayList<>();
            st = new StringTokenizer(readInput(), " ");
            for(int j=0;j<n;j++){ aList.add(Integer.parseInt(st.nextToken())); }
            Collections.sort(aList);

            List<Integer> bList = new ArrayList<>();
            st = new StringTokenizer(readInput(), " ");
            for(int j=0;j<m;j++){ bList.add(Integer.parseInt(st.nextToken())); }
            Collections.sort(bList);

            int result = 0, oEat = 0;
            for(int j=0;j<n;j++){
                int nEat = 0;
                for(int k=0;k<bList.size();k++){
                    if(aList.get(j)>bList.get(k)){
                        nEat++;
                        bList.remove(k);
                        k--;
                    } else {
                        break;
                    }
                }
                oEat += nEat;
                result += oEat;
            }
            SB.append(result).append("\n");
        }
        writeOutput(SB.toString());
    }
}
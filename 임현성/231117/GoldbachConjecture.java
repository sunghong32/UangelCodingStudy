package baekjoon.algorithm.math;

import java.io.*;

/**
 * [Algorithm]
 * 수학
 * 정수론
 * 소수 판정
 * 에라토스테네스의 체
 * [Result]
 * 메모리 : 15492 kb
 * 수행시간 : 168 ms
 */
public class GoldbachConjecture {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();
    private static final boolean[] primes = new boolean[10001];

    public static void main(String[] args) { goldbachConjecture(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void goldbachConjecture() {
        int t = Integer.parseInt(readInput());
        setPrime();
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(readInput());
            for(int j=n/2;j>1;j--){
                if(primes[j]) continue;
                if(!primes[j]&&!primes[n-j]) {
                    SB.append(j).append(" ").append(n-j).append("\n");
                    break;
                }
            }
        }
        writeOutput(SB.toString());
    }

    private static void setPrime(){
        primes[0] = primes[1] = true;
        for( int i = 2; i <= Math.sqrt(primes.length);i++){
            if(primes[i]) continue;
            for(int j = i * i; j < primes.length; j+=i){
                primes[j] = true;
            }
        }
    }
}
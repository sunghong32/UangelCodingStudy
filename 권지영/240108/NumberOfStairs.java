import java.io.*;

/*
 * 2024.01.08
 * BAEKJOON 1562:계단 수
 * 메모리 : 24232 KB
 * 시간 : 192 ms
 * */

public class NumberOfStairs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static long[][][] dp;
    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][10][1 << 10];

        for (int i = 1; i <= 9; i++)
            dp[1][i][1 << i] = 1;

        for (int i = 2; i <= n; i++) {
            for (int k = 0; k <= 9; k++) {
                for (int visit = 0; visit < (1 << 10); visit++) {

                    int newVisit = visit | (1 << k);

                    if (k == 0)
                        dp[i][k][newVisit] += dp[i - 1][k + 1][visit] % MOD;
                    else if (k == 9)
                        dp[i][k][newVisit] += dp[i - 1][k - 1][visit] % MOD;
                    else
                        dp[i][k][newVisit] += dp[i - 1][k + 1][visit] % MOD + dp[i - 1][k - 1][visit] % MOD;

                    dp[i][k][newVisit] %= MOD;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[n][i][(1 << 10) - 1] % MOD;
            sum %= MOD;
        }

        bw.write(sum + "");
        br.close();
        bw.close();
    }
}
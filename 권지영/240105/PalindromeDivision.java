import java.io.*;
import java.util.Arrays;

/*
 * 2024.01.05
 * BAEKJOON 1509번:팰린드롬 분할
 * 메모리 : 21760 KB
 * 시간 : 1312 ms
 * */

public class PalindromeDivision {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dp;
    static boolean[][] palindrome;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        int length = str.length();
        dp = new int[length + 1];
        palindrome = new boolean[length + 1][length + 1];
        for (int i = 1; i <= length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        findPalindrome(str);
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= i; j++) {
                if (palindrome[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        bw.write(dp[length]+"");
        br.close();
        bw.close();
    }

    public static void findPalindrome(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                boolean isPalindrome = true;

                int start = i;
                int end = j;
                while (start <= end) {
                    if (str.charAt(start++) != str.charAt(end--)) {
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPalindrome) {
                    palindrome[i + 1][j + 1] = true;
                }
            }
        }
    }
}
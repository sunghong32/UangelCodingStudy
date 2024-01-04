import java.io.*;
import java.util.StringTokenizer;

/*
 * 2024.01.03
 * BAEKJOON 10942번:팰린드롬?
 * 메모리 : 207372 KB
 * 시간 : 1208 ms
 * */

public class Palindrome {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, m, s, e;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        numbers = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            if (isPalindrome()) bw.write("1\n");
            else bw.write("0\n");
        }

        br.close();
        bw.close();
    }

    public static boolean isPalindrome() {
        int size = e - s + 1;
        for (int j = 0; j < size / 2; j++) {
            if (numbers[s + j] != numbers[e - j]) {
                return false;
            }
        }
        return true;
    }
}
import java.io.*;
import java.util.Arrays;

/*
 * 2023.11.01
 * BAEKJOON 10815번:숫자 카드
 * 메모리 : 123520 KB
 * 시간 : 1364 ms
 * */

public class NumberCard {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] cards;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        cards = new int[n];
        for (int i = 0; i < n; i++) cards[i] = Integer.parseInt(strs[i]);
        Arrays.sort(cards);

        br.readLine();
        strs = br.readLine().split(" ");
        for (String num : strs) search(Integer.parseInt(num));

        br.close();
        bw.close();
    }

    private static boolean search(int num) throws IOException {
        int leftIndex = 0;
        int rightIndex = n - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            int mid = cards[midIndex];
            if (num < mid) rightIndex = midIndex - 1;
            else if (num > mid) leftIndex = midIndex + 1;
            else {
                bw.write("1 ");
                return true;
            }
        }
        bw.write("0 ");
        return false;
    }
}
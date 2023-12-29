import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 2023.12.27
 * BAEKJOON 12015:가장 긴 증가하는 부분 수열 2
 * 메모리 : 139568 KB
 * 시간 : 712 ms
 * */

public class LongestIncreasingPartialSequence2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] strs = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < n; i++) {
            int value = arr[i] = Integer.parseInt(strs[i]);
            if (value > list.get(list.size() - 1)) list.add(value);
            else {
                int left = 0;
                int right = list.size() - 1;

                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (list.get(mid) >= value) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                list.set(right, value);
            }
        }

        bw.write(list.size() - 1 + "");
        br.close();
        bw.close();
    }
}
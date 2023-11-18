import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * 2023.11.17
 * BAEKJOON 9020번:골드바흐의 추측
 * 메모리 : 137632 KB
 * 시간 : 2548 ms
 * */

public class GoldbachConjecture {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer sb = new StringBuffer();
    static boolean[] nums;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            getSosu(n);
            getGoldBach(n);
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static void getSosu(int n) {
        nums = new boolean[n + 1];
        for (int i = 2; i < n; i++) {
            nums[i] = true;
        }

        int root = (int) Math.sqrt(n);
        for (int i = 2; i <= root; i++) {
            if (nums[i]) {
                for (int j = i; i * j <= n; j++)
                    nums[i * j] = false;
            }
        }
    }

    static void getGoldBach(int n) {
        List<Integer> sosu = new ArrayList<>();
        sosu.add(1);
        for (int i = 2; i <= n; i++) {
            if (nums[i]) sosu.add(i);
        }
        int size = sosu.size();
        int[] answer = new int[2];
        int min = 10000;
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                int num1 = sosu.get(i);
                int num2 = sosu.get(j);
                if (num1 + num2 == n) {
                    int temp = Math.abs(num1 - num2);
                    if (min > temp) {
                        answer[0] = num1;
                        answer[1] = num2;
                        min = temp;
                    }
                    break;
                }
            }
        }
        sb.append(answer[0]).append(" ").append(answer[1]).append("\n");
    }
}
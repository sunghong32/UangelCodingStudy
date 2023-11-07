import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2023.11.06
 * BAEKJOON 7795번:먹을 것인가 먹힐 것인가
 * 메모리 : 40968 KB
 * 시간 : 556 ms
 * */

public class EatOrBeEaten {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] strs = br.readLine().split(" ");
            int n = Integer.parseInt(strs[0]);
            int m = Integer.parseInt(strs[1]);
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                a[j] = Integer.parseInt(st.nextToken());
                j++;
            }
            int[] b = new int[m];
            st = new StringTokenizer(br.readLine(), " ");
            j = 0;
            while (st.hasMoreTokens()) {
                b[j] = Integer.parseInt(st.nextToken());
                j++;
            }

            Arrays.sort(a);
            Arrays.sort(b);

            int answer = 0;
            for (int k = 0; k < n; k++) {
                int result = 0;
                int left = 0, right = m - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    int num = b[mid];
                    if (a[k] > num) {
                        left = mid + 1;
                        result = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                answer += result;
            }

            bw.write(answer + "\n");
        }
        br.close();
        bw.close();
    }
}
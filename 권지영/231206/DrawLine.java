import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

/*
 * 2023.12.06
 * BAEKJOON 2170번:선 긋기
 * 메모리 : 339444 KB
 * 시간 : 2668 ms
 * */

public class DrawLine {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] temp = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().split(" ");
            temp[i][0] = Integer.parseInt(strs[0]);
            temp[i][1] = Integer.parseInt(strs[1]);
        }
        Arrays.sort(temp, new Comparator<int[]>() { //x좌표 오름차순 정렬. x좌표 같으면 y좌표 오름차순 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });

        int s1 = temp[0][0];
        int e1 = temp[0][1];
        int length = e1 - s1;
        for (int i = 1; i < n; i++) {
            int s2 = temp[i][0];
            int e2 = temp[i][1];
            if (s1 <= s2 && e2 <= e1) {
                continue;
            } else if (s2 < e1) {
                length += temp[i][1] - e1;
            } else {
                length += temp[i][1] - temp[i][0];
            }
            s1 = temp[i][0];
            e1 = temp[i][1];
        }

        bw.write(length + "");
        br.close();
        bw.close();
    }

}
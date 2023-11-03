import java.io.*;

/*
 * 2023.11.03
 * BAEKJOON 17266번:어두운 굴다리
 * 메모리 : 25104 KB
 * 시간 : 292 ms
 * */

public class DarkUnderpass {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        int answer = 0;
        int start = 0;
        for (int i = 0; i < m; i++) {
            int lampIndex = Integer.parseInt(strs[i]);
            if (m == 1) answer = Math.max(n - lampIndex, lampIndex);
            if (i == 0) {
                answer = Math.max(lampIndex, answer);
                start = lampIndex;
                continue;
            }
            int gap = lampIndex - start;
            start = lampIndex;
            answer = Math.max((gap / 2 + gap % 2), answer);
            if (i == (m - 1)) {
                answer = Math.max((n - lampIndex), answer);
            }
        }

        bw.write(answer + "");
        br.close();
        bw.close();
    }
}
import java.io.*;

/*
 * 2023.08.23
 * BAEKJOON 15650번:N과 M (2)
 * 메모리 : 14264 KB
 * 시간 : 124 ms
 * */

public class NAndM2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static boolean[] visitNum;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        visitNum = new boolean[n];
        arr = new int[m];
        findSequence(0,n,m,0);
        sb.deleteCharAt(sb.length()-1).deleteCharAt(sb.length()-1);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static void findSequence(int a, int n, int m, int d){
        if(d==m){
            for(int num :arr){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=a; i<n; i++){
            if(!visitNum[i]){
                visitNum[i] = true;
                arr[d] = i+1;
                findSequence(i+1,n,m,d+1);
                visitNum[i] = false;
            }
        }
    }
}
import java.io.*;
import java.util.StringTokenizer;

/*
 * 2023.08.14
 * BAEKJOON 11403번:경로 찾기
 * 메모리 : 16180 KB
 * 시간 : 188 ms
 * */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        findRoute(arr);
        br.close();
        bw.close();
    }

    static void findRoute(int[][] arr) throws IOException {
        int number = arr.length;
        for(int k=0; k<number; k++){
            for(int i=0; i<number; i++){
                for(int j=0; j<number; j++){
                    if(arr[i][k] == 1 && arr[k][j] == 1){
                        arr[i][j] = 1;
                    }
                }
            }
        }

        for (int[] ints : arr) {
            for (int j = 0; j < number; j++) {
                sb.append(ints[j]).append(" ");
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        bw.write(sb.toString());
    }
}
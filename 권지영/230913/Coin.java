import java.io.*;

/*
 * 2023.09.13
 * BAEKJOON 9084번:동전
 * 메모리 : 14364 KB
 * 시간 : 132 ms
 * */

public class Coin {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    solution();
  }

  static void solution() throws IOException {
    int t = Integer.parseInt(br.readLine());
    for(int i=0; i<t; i++){
      int n = Integer.parseInt(br.readLine());
      String[] strs = br.readLine().split(" ");
      int[] coins = new int[n];
      for(int j=0; j<n; j++){
        coins[j] = Integer.parseInt(strs[j]);
      }
      int m = Integer.parseInt(br.readLine());

      findWayCount(n,m, coins);
    }
    sb.deleteCharAt(sb.length()-1);
    bw.write(sb.toString());
    br.close();
    bw.close();
  }
  static void findWayCount(int n, int m, int[] coins){
      int[] ways = new int[m];
      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
          if((j+1) - coins[i] > 0){
            ways[j] = ways[j] + ways[j-coins[i]];
          }else if((j+1) - coins[i] == 0){
            ways[j]++;
          }
        }
      }
      sb.append(ways[m-1]).append("\n");
  }
}

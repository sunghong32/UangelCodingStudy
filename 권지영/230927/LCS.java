import java.io.*;
import java.lang.Math;
import java.util.Arrays;

/*
 * 2023.09.27
 * BAEKJOON 9251번:LCS
 * 메모리 : 18540 KB
 * 시간 : 156 ms
 * */

public class LCS{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[] a;
    static char[] b;
    static int[][] sub;
    
	public static void main(String[] args) throws IOException {
        String str1 = br.readLine();
        String str2 = br.readLine();
        int length1 = str1.length();
        int length2 = str2.length();
        
		a=new char[length1+1];
		b=new char[length2+1];
		
		for(int i = 1; i <= length1; i++) {
			a[i] = str1.charAt(i - 1);
		}
		for(int i = 1; i <= length2; i++) {
			b[i] = str2.charAt(i - 1);
		}
		
		sub = new int[length1+1][length2+1];

        for (int i = 1; i < length1+1; i++) {
            for (int j = 1; j < length2+1; j++) {
                if(a[i] == b[j]){
                    sub[i][j] = sub[i - 1][j - 1] + 1;
                }else{
                    sub[i][j] = Math.max(sub[i - 1][j], sub[i][j - 1]);
                }
            }
        }
        
        bw.write(sub[length1][length2] + "");
        br.close();
        bw.close();
	}
}
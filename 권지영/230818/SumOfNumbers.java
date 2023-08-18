import java.io.*;

/*
 * 2023.08.16
 * BAEKJOON 1789번:수들의 합
 * 메모리 : 16380 KB
 * 시간 : 140 ms
 * */

public class SumOfNumbers {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Long total = Long.parseLong(br.readLine());
        int i=1;
        int n=0;
        while(total >= 0){
            total = total -i;
            i++;
            n++;
        }
        n--;
        bw.write(n+"");
        br.close();
        bw.close();
    }
}

import java.io.*;

/*
 * 2023.08.12
 * BAEKJOON 3040번:백설 공주와 일곱 난쟁이
 * 메모리 : 14124 KB
 * 시간 : 120 ms
 * */

public class SnowWhite {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int[] dwarf = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int temp = Integer.parseInt(br.readLine());
            sum += temp;
            dwarf[i] = temp;
        }
        getTwoDwarf(sum, dwarf);
        br.close();
        bw.close();
    }

    static void getTwoDwarf(int sum, int[] dwarf) throws IOException {
        for(int i=0; i<8; i++){
            for(int j= i+1; j<9; j++){
                int twoDwarf = dwarf[i] + dwarf[j];
                if(sum- twoDwarf == 100){
                    dwarf[i] = -100;
                    dwarf[j] = -100;
                }
            }
        }

        for(int i=0; i<9; i++){
            int num = dwarf[i];
            if(num > 0){
                sb.append(num).append("\n");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        bw.write(sb.toString());
    }
}
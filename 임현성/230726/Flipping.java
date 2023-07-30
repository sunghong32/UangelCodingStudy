import java.io.*;

/**
 * [Input]
 * Line 1 : 다솜이의 숫자 배열 (0 or 1)
 * [Output]
 * Line 1 : 뒤집는 최소 횟수
 * [Algorithm]
 * 문자열
 * 그리디 알고리즘
 * [Result]
 * 메모리 : 14264 kb
 * 수행시간 : 128 ms
 */
public class Flipping {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        flipping();
        stop();
    }

    private static String readInput() {
        try { return reader.readLine(); } catch (Exception e){ return ""; }
    }

    private static void writeOutput(String output) {
        try {
            writer.write(output);
            writer.flush();
        } catch (IOException ignored) {/* ignored */}
    }

    private static void stop(){
        try {
            reader.close();
            writer.close();
        } catch (IOException ignored) {/* ignored */}
    }

    private static void flipping() {
        String binaryList = readInput();
        writeOutput(getFlippingCount(binaryList));
    }

    private static String getFlippingCount(String binaryList) {
        int cnt = 1;
        for(int idx = 1; idx < binaryList.length(); idx++){
            if(binaryList.charAt(idx-1) != binaryList.charAt(idx)){
                cnt++;
            }
        }
        if(cnt%2 == 1) cnt--;
        return String.valueOf(cnt/2);
    }
}
package baekjoon.datastructure.stack;

import java.io.*;

/**
 * [Input]
 * Line 1 : 입력 데이터 수 n
 * Line 2~n+1 : 괄호 문자열
 * [Output]
 * Line 1 ~ N : 괄호 문자열이 VPS 인지 결과
 * [Algorithm]
 * 자료 구조
 * 문자열
 * 스택
 * [Result]
 * 메모리 : 14228 kb
 * 수행시간 : 124 ms
 */
public class ParenthesisString {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        parenthesisString();
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

    private static void parenthesisString() {
        int size = Integer.parseInt(readInput());
        StringBuilder sb = new StringBuilder();
        for(int idx = 0; idx < size; idx++){ sb.append(isVPS(readInput())); }
        writeOutput(sb.toString());
    }

    private static String isVPS(String ps){
        int stack = 0;
        for(char pc : ps.toCharArray()){
            switch (pc){
                case '(':
                    stack++;
                    break;
                case ')':
                    stack--;
                    break;
                default:
            }
            if(stack < 0) return "NO\n";
        }
        return stack == 0 ? "YES\n" : "NO\n";
    }
}
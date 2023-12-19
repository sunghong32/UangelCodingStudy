package baekjoon.datastructure.stack;

import java.io.*;
import java.util.Stack;

/**
 * [Algorithm]
 * 자료 구조
 * 스택
 * [Result]
 * 메모리 : 14224 kb
 * 수행시간 : 128 ms
 */
public class PostfixNotation {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();

    public static void main(String[] args) { postfixNotation(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void postfixNotation() {
        Stack<Character> stack = new Stack<>();
        for(char s:readInput().toCharArray()){
            switch (s){
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(s)) {
                        SB.append(stack.pop());
                    }
                case '(':
                    stack.add(s);
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() != '('){
                        SB.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    SB.append(s);
            }
        }
        while (!stack.isEmpty()) SB.append(stack.pop());
        writeOutput(SB.toString());
    }

    public static int priority(char o){
        if (o == '+' || o == '-') return 1;
        else if (o == '*' || o == '/') return 2;
        else return 0;
    }
}
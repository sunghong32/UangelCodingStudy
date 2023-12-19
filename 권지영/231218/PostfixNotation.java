import java.io.*;
import java.util.Stack;

/*
 * 2023.12.18
 * BAEKJOON 1918번:후위 표기식
 * 메모리 : 14328 KB
 * 시간 : 124 ms
 * */

public class PostfixNotation {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] strs = br.readLine().split("");
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (String str : strs) {
            switch (str) {
                case "+":
                case "-":
                case "*":
                case "/":
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(str)) {
                        sb.append(stack.pop());
                    }
                    stack.push(str);
                    break;
                case "(":
                    stack.push(str);
                    break;
                case ")":
                    while (!stack.isEmpty() && !stack.peek().equals("(")) sb.append(stack.pop());
                    stack.pop();
                    break;
                default:
                    sb.append(str);
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pop());

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    public static int priority(String op) {
        switch (op) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }
}
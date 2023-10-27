import java.io.*;

/*
 * 2023.10.27
 * BAEKJOON 1158번:요세푸스 문제
 * 메모리 : 14476 KB
 * 시간 : 332 ms
 * */

public class JosephusProblem {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);
        Circle circle = new Circle();

        for (int i = 1; i <= n; i++) {
            circle.insertLast(i);
        }
        sb.append("<");
        while (circle.length() != 0) {
            sb.append(circle.remove(k)).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1).append(">");
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}

class Circle {
    private Node tail;
    private int size;

    public Circle() {
        tail = null;
        size = 0;
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);

        if (tail == null) {
            tail = newNode;
            newNode.setNext(newNode);
        } else {
            newNode.setNext(tail.getNext());
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public int remove(int i) {
        int num = getNode(i - 1).getData();
        Node prevNode = getNode(i - 2);
        prevNode.next = getNode(i);
        tail = prevNode;
        size--;
        return num;
    }

    public Node getNode(int i) {
        Node currNode = tail;
        for (int j = 0; j <= i; j++) {
            currNode = currNode.next;
        }
        return currNode;
    }

    public int length() {
        return size;
    }

    class Node {
        private int data;
        private Node next;

        public Node() {
            this.data = 0;
            this.next = null;
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return this.data;
        }

        public void setNext(Node node) {
            this.next = node;
        }

        public Node getNext() {
            return this.next;
        }
    }
}
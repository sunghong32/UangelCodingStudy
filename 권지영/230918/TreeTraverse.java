import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 * 2023.09.18
 * BAEKJOON 1991번:트리 순회
 * 메모리 : 14208 KB
 * 시간 : 124 ms
 * */

public class TreeTraverse {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Map<String, TreeNode> trees = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().split(" ");
            TreeNode node;
            String name = strs[0];
            if (trees.containsKey(name)) {
                node = trees.get(name);
            } else {
                node = new TreeNode(name);
                trees.put(name, node);
            }
            if (!Objects.equals(strs[1], ".")) {
                node.left = new TreeNode(strs[1]);
                trees.put(strs[1], node.left);
            }
            if (!Objects.equals(strs[2], ".")) {
                node.right = new TreeNode(strs[2]);
                trees.put(strs[2], node.right);
            }
        }

        TreeNode node = trees.get("A");
        //전위순회
        preOrder(node);
        sb.append("\n");
        //중위순회
        inOrder(node);
        sb.append("\n");
        //후위순회
        postOrder(node);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static void preOrder(TreeNode node) {
        if (node != null) {
            sb.append(node.name);
            if (node.left != null) preOrder(node.left);
            if (node.right != null) preOrder(node.right);
        }
    }

    static void inOrder(TreeNode node) {
        if (node != null) {
            if (node.left != null) inOrder(node.left);
            sb.append(node.name);
            if (node.right != null) inOrder(node.right);
        }
    }

    static void postOrder(TreeNode node) {
        if (node != null) {
            if (node.left != null) postOrder(node.left);
            if (node.right != null) postOrder(node.right);
            sb.append(node.name);
        }
    }
}

class TreeNode {
    String name;
    TreeNode left;
    TreeNode right;

    TreeNode(String name) {
        this.name = name;
        this.left = null;
        this.right = null;
    }
}


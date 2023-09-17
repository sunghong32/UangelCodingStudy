package baekjoon.algorithm.recursive;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 트리
 * 재귀
 * [Result]
 * 메모리 : 14204 kb
 * 수행시간 : 124 ms
 */
public class TreeTraversal {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();
    private static Map<String, TreeNode> nodeMap = new HashMap<>();
    private static class TreeNode{
        final String data;
        TreeNode leftNode = null;
        TreeNode rightNode = null;

        public TreeNode(String data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        treeTraversal();
        stop();
    }

    private static String readInput() {
        try { return READER.readLine(); } catch (Exception e){ return ""; }
    }

    private static void writeOutput(String output) {
        try {
            WRITER.write(output);
            WRITER.flush();
        } catch (IOException ignored) {/* ignored */}
    }

    private static void stop(){
        try {
            READER.close();
            WRITER.close();
        } catch (IOException ignored) {/* ignored */}
    }

    private static void treeTraversal() {
        int n = Integer.parseInt(readInput());
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(readInput(), " ");
            String data = st.nextToken();
            TreeNode node = nodeMap.putIfAbsent(data, new TreeNode(data));
            if(node == null) node = nodeMap.get(data);
            String lData = st.nextToken();
            if(!lData.equals(".")){
                TreeNode leftNode = nodeMap.putIfAbsent(lData, new TreeNode(lData));
                if(leftNode == null) leftNode = nodeMap.get(lData);
                node.leftNode = leftNode;
            }
            String rData = st.nextToken();
            if(!rData.equals(".")){
                TreeNode rightNode = nodeMap.putIfAbsent(rData, new TreeNode(rData));
                if(rightNode == null) rightNode = nodeMap.get(rData);
                node.rightNode = rightNode;
            }
        }
        TreeNode rootNode = nodeMap.get("A");
        preorderTraversal(rootNode);
        SB.append("\n");
        inorderTraversal(rootNode);
        SB.append("\n");
        postorderTraversal(rootNode);
        writeOutput(SB.toString());
    }

    private static void preorderTraversal(TreeNode node){
        if(node == null) return;
        SB.append(node.data);
        preorderTraversal(node.leftNode);
        preorderTraversal(node.rightNode);
    }

    private static void inorderTraversal(TreeNode node){
        if(node == null) return;
        inorderTraversal(node.leftNode);
        SB.append(node.data);
        inorderTraversal(node.rightNode);
    }

    private static void postorderTraversal(TreeNode node){
        if(node == null) return;
        postorderTraversal(node.leftNode);
        postorderTraversal(node.rightNode);
        SB.append(node.data);
    }
}
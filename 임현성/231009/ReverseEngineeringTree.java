package baekjoon.algorithm.divideandconquer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 트리
 * 분할 정복
 * 재귀
 * [Result]
 * 메모리 : 49332 kb
 * 수행시간 : 488 ms
 */
public class ReverseEngineeringTree {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        reverseEngineeringTree();
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

    private static void reverseEngineeringTree() {
        int t = Integer.parseInt(readInput());
        for (int i=0;i<t;i++){
            int n = Integer.parseInt(readInput());
            StringTokenizer st = new StringTokenizer(readInput(), " ");
            List<Integer> preorder = new ArrayList<>();
            for (int j=0;j<n;j++){
                preorder.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(readInput(), " ");
            List<Integer> inorder = new ArrayList<>();
            for (int j=0;j<n;j++){
                inorder.add(Integer.parseInt(st.nextToken()));
            }
            TreeNode root = new TreeNode(preorder.get(0));
            makeTree(root, preorder, inorder);
            postorder(root);
            SB.append("\n");
        }
        writeOutput(SB.toString());
    }

    private static void makeTree(TreeNode node, List<Integer> preorder, List<Integer> inorder){
        int nIdx = inorder.indexOf(node.data);
        if(nIdx != 0) {
            List<Integer> lInorder = inorder.subList(0, nIdx);
            int lSize = lInorder.size();
            if(lSize == 1) {
                node.lNode = new TreeNode(lInorder.get(0));
            } else {
                List<Integer> lPreorder = preorder.subList(1, 1+lSize);
                node.lNode = new TreeNode(lPreorder.get(0));
                makeTree(node.lNode, lPreorder, lInorder);
            }
        }
        if(nIdx != inorder.size()-1){
            List<Integer> rInorder = inorder.subList(nIdx+1, inorder.size());
            int rSize = rInorder.size();
            if(rSize == 1) {
                node.rNode = new TreeNode(rInorder.get(0));
            } else {
                List<Integer> rPreorder = preorder.subList(preorder.size()-rSize, preorder.size());
                node.rNode = new TreeNode(rPreorder.get(0));
                makeTree(node.rNode, rPreorder, rInorder);
            }
        }
    }

    private static void postorder(TreeNode node){
        if(node==null) return;
        postorder(node.lNode);
        postorder(node.rNode);
        SB.append(node.data).append(" ");
    }

    private static class TreeNode{
        int data;
        TreeNode lNode = null;
        TreeNode rNode = null;
        public TreeNode(int data) { this.data = data; }
    }
}
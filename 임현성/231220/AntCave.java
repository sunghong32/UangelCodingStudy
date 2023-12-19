package baekjoon.datastructure.hashmap;

import java.io.*;
import java.util.*;

/**
 * [Algorithm]
 * 자료 구조
 * 문자열
 * 트리
 * 트라이
 * [Result]
 * 메모리 : 16428 kb
 * 수행시간 : 204 ms
 */
public class AntCave {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder SB = new StringBuilder();
    private static final String DEPTH = "--";

    public static void main(String[] args) { antCave(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void antCave() {
        int n = Integer.parseInt(readInput());
        StringTokenizer st;
        CaveNode rNode = new CaveNode("r", -1);
        for(int i=0;i<n;i++){
            CaveNode pNode = rNode;
            st = new StringTokenizer(readInput(), " ");
            int m = Integer.parseInt(st.nextToken());
            for(int j=0;j<m;j++){
                String food = st.nextToken();
                pNode.children.putIfAbsent(food, new CaveNode(food, pNode.depth+1));
                pNode = pNode.children.get(food);
            }
        }
        drawingCave(rNode);
        writeOutput(SB.toString());
    }

    private static void drawingCave(CaveNode node){
        if(node.depth != -1) {
            for (int i = 0; i < node.depth; i++) {SB.append(DEPTH);}
            SB.append(node.food).append("\n");
        }
        node.children.values().stream().sorted(Comparator.comparing(o -> o.food)).forEach(AntCave::drawingCave);
    }

    private static class CaveNode{
        String food;
        int depth;
        Map<String, CaveNode> children = new HashMap<>();
        CaveNode(String f, int d){food = f; depth = d;}
    }
}
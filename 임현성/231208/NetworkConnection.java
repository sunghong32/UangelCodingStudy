package baekjoon.algorithm.graphsearch;

import java.io.*;
import java.util.*;

/**
 * [Algorithm]
 * 그래프 이론
 * 최소 스패닝 트리
 * [Result]
 * 메모리 : 63452 kb
 * 수행시간 : 852 ms
 */
public class NetworkConnection {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) { networkConnection(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void networkConnection() {
        StringTokenizer st;
        List<Set<Integer>> nodeSetList = new ArrayList<>();
        List<Integer[]> edges = new ArrayList<>();
        int n = Integer.parseInt(readInput());
        int m = Integer.parseInt(readInput());
        for(int i=1;i<=n;i++){
            Set<Integer> nodeSet = new HashSet<>();
            nodeSet.add(i);
            nodeSetList.add(nodeSet);
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(readInput(), " ");
            edges.add(new Integer[]{Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken())});
        }
        Collections.sort(edges, (Comparator.comparingInt(o -> o[2])));
        int r = 0;
        for (Integer[] e:edges) {
            int aI=-1, bI=-1;
            for (int i=0;i<nodeSetList.size();i++){
                if(nodeSetList.get(i).contains(e[0])) aI = i;
                if(nodeSetList.get(i).contains(e[1])) bI = i;
                if(aI!=-1&&bI!=-1) break;
            }
            if(aI!=bI) {
                nodeSetList.get(aI).addAll(nodeSetList.get(bI));
                nodeSetList.remove(bI);
                r+=e[2];
            }
            if(nodeSetList.size()==1) break;
        }
        writeOutput(String.valueOf(r));
    }
}
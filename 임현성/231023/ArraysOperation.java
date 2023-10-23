package baekjoon.algorithm.simulation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [Algorithm]
 * 구현
 * 정렬
 * 시뮬레이션
 * [Result]
 * 메모리 : 30292 kb
 * 수행시간 : 328 ms
 */
public class ArraysOperation {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static List<List<Integer>> array = new ArrayList<>();

    public static void main(String[] args) { arrayOperation(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void arrayOperation() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for(int i=0;i<3;i++){
            st = new StringTokenizer(readInput(), " ");
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(Integer.parseInt(st.nextToken()));
            temp.add(Integer.parseInt(st.nextToken()));
            temp.add(Integer.parseInt(st.nextToken()));
            array.add(temp);
        }

        int result = -1;
        for(int s=0;s<=100;s++){
            if ((array.size()>=r&&array.get(0).size()>=c) && array.get(r-1).get(c-1) == k){
                result = s;
                break;
            }

            if(array.size() >= array.get(0).size()){
                calculationR(array);
            } else {
                calculationC();
            }
        }
        writeOutput(String.valueOf(result));
    }

    private static void calculationR(List<List<Integer>> matrix){
        int max = matrix.get(0).size();
        for(int i=0;i<matrix.size();i++){
            List<Integer> oldRow = matrix.get(i);
            List<int[]> temps = new ArrayList<>();
            for(int j=0;j<oldRow.size();j++){
                final int n = oldRow.get(j);
                if (n==0) continue;
                int[] temp = temps.stream().filter(t->t[0]==n).findFirst().orElse(null);
                if(temp == null){
                    temps.add(new int[]{oldRow.get(j), 1});
                } else {
                    temp[1]++;
                }
            }
            temps.sort((o1, o2) -> {
                if(o1[1]>o2[1]) return 1;
                else if(o1[1]==o2[1]) return o1[0]-o2[0];
                else return -1;
            });

            List<Integer> newRow = new ArrayList<>();
            for (int[] t:temps){ newRow.add(t[0]); newRow.add(t[1]); }
            matrix.set(i, newRow);
            if(max < newRow.size()) max = newRow.size();
        }
        if(max > 100) max = 100;
        for(int i=0;i<matrix.size();i++){
            List<Integer> row = matrix.get(i);
            if(row.size()<max){
                while (row.size() < max){ row.add(0); }
            } else {
                matrix.set(i, row.subList(0, max));
            }
        }
    }

    private static void calculationC(){
        List<List<Integer>> changeArray = transposedMatrix(array);
        calculationR(changeArray);
        array = transposedMatrix(changeArray);
    }

    private static List<List<Integer>>  transposedMatrix(List<List<Integer>> matrix){
        List<List<Integer>> changeArray = new ArrayList<>();
        List<Integer> refRow = matrix.get(0);
        for(int i=0;i<refRow.size();i++){
            List<Integer> newRow = new ArrayList<>();
            newRow.add(refRow.get(i));
            changeArray.add(newRow);
        }
        for(int i=1;i<matrix.size();i++){
            for(int j=0;j<refRow.size();j++){
                changeArray.get(j).add(matrix.get(i).get(j));
            }
        }
        return changeArray;
    }
}
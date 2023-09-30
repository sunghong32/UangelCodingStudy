import java.io.*;
import java.util.*;
import java.lang.Math;

/*
 * 2023.09.25
 * BAEKJOON 13869번:Dating On-Line
 * 메모리 : 32208 KB
 * 시간 : 412 ms
 * */

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		String[] strs = br.readLine().split(" ");
		int[] s = new int[n];
		Deque<Integer> stack = new ArrayDeque<>();
		
		for(int i=0; i<n; i++){
		    s[i] = Integer.parseInt(strs[i]);
		}
		
		Arrays.sort(s);
		
		for(int i=n-1; i>=0; i--){
		    if(i%2 == 0) stack.addFirst(s[i]);
		    else stack.addLast(s[i]);
		}
		
		bw.write(getArea(stack));
		br.close();
		bw.close();
	}
	
	static String getArea(Deque stack){
	    List<Integer> list = new ArrayList<>(stack);
	    int a;
	    int b;
	    int size = list.size();
	    double angle = 360.0 / size;
	    double rad = Math.toRadians(angle); 
	    double area = 0.0;
	    for(int i=0; i<size; i++){
	       if(i == (size-1)){
	           a= list.get(i);
	           b= list.get(0);
	       }else{
	           a= list.get(i);
	           b= list.get(i+1);
	       }
	       
	       area += 0.5*a*b*(Math.sin(rad));
	    }
	    return String.format("%.3f", area);
	}
}
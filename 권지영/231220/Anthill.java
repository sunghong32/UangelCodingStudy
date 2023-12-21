import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

/*
 * 2023.12.20
 * BAEKJOON 14725번:개미굴
 * 메모리 : 17708 KB
 * 시간 : 236 ms
 * */

public class Anthill {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Room root = new Room();

        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().split(" ");
            int size = Integer.parseInt(strs[0]);
            Room cur = root;

            for (int j = 0; j < size; j++) {
                String s = strs[j + 1];

                if (!cur.child.containsKey(s)) {
                    cur.child.put(s, new Room());
                }
                cur = cur.child.get(s);
            }
        }
        drawAnthill(root, "");
        br.close();
        bw.close();
    }

    public static void drawAnthill(Room root, String bar) throws IOException {
        Object[] key = root.child.keySet().toArray();
        Arrays.sort(key);

        for (Object s : key){
            bw.write(bar+s+"\n");
            drawAnthill(root.child.get(s),bar+"--");
        }
    }
}

class Room {
    HashMap<String, Room> child = new HashMap<>();
}
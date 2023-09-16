import java.io.*;

/*
 * 2023.09.15
 * BAEKJOON 11758번:CCW
 * 메모리 : 14308 KB
 * 시간 : 128 ms
 * */

public class CCW {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] tempStr;
        Point p1 = null, p2 = null, p3 = null;
        for (int i = 0; i < 3; i++) {
            tempStr = br.readLine().split(" ");
            switch (i) {
                case 0:
                    p1 = new Point(Integer.parseInt(tempStr[0]), Integer.parseInt(tempStr[1]));
                    break;
                case 1:
                    p2 = new Point(Integer.parseInt(tempStr[0]), Integer.parseInt(tempStr[1]));
                    break;
                case 2:
                    p3 = new Point(Integer.parseInt(tempStr[0]), Integer.parseInt(tempStr[1]));
                    break;
            }
        }
        int ccw = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);
        if (ccw < 0) bw.write("-1");
        else if (ccw == 0) bw.write("0");
        else bw.write("1");
        br.close();
        bw.close();
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
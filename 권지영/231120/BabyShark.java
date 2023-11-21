import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 2023.11.20
 * BAEKJOON 16236번:아기 상어
 * 메모리 : 25268 KB
 * 시간 : 212 ms
 * */

public class BabyShark {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Shark> queue = new LinkedList<>();
    static int[][] fishbowl;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        fishbowl = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int status = Integer.parseInt(strs[j]);
                fishbowl[i][j] = status;
                if (strs[j].equals("9")) {
                    queue.add(new Shark(i, j, 0));
                    fishbowl[i][j] = 0;
                }
            }
        }
        bw.write(getAnswer() + "");

        br.close();
        bw.close();
    }

    static int getAnswer() {
        int answer = 0;
        int sharkSize = 2;
        int eatCount = 0;

        while (true) {
            if (sharkSize == eatCount) {
                sharkSize++;
                eatCount = 0;
            }

            int[][] route = new int[n][n];
            List<Shark> canEatFish = new ArrayList<>();
            while (!queue.isEmpty()) {
                Shark shark = queue.poll(); //상어 정보
                int x = shark.x;
                int y = shark.y;

                for (int i = 0; i < 4; i++) {
                    int tx = x, ty = y;
                    if (i == 0) tx = tx + 1;
                    else if (i == 1) tx = tx - 1;
                    else if (i == 2) ty = ty + 1;
                    else ty = ty - 1;

                    if (tx < 0 || ty < 0 || tx >= n || ty >= n) continue;
                    if (route[tx][ty] == 0 && fishbowl[tx][ty] <= sharkSize) { //지나갈 수 있으면
                        route[tx][ty] = route[x][y] + 1;
                        queue.add(new Shark(tx, ty, route[tx][ty]));
                        if (fishbowl[tx][ty] != 0 && fishbowl[tx][ty] != 9 && fishbowl[tx][ty] < sharkSize) { //먹을 수 있으면
                            canEatFish.add(new Shark(tx, ty, route[tx][ty]));
                        }
                    }
                }
            }

            //먹을 게 없으면
            if (canEatFish.size() == 0) return answer;

            //먹을 게 있으면
            Shark nowCanEatFish = canEatFish.get(0);
            for (int i = 1; i < canEatFish.size(); i++) {
                if (nowCanEatFish.moving > canEatFish.get(i).moving) nowCanEatFish = canEatFish.get(i);
                else if (nowCanEatFish.moving == canEatFish.get(i).moving) { //거리가 같으면
                    if (nowCanEatFish.x > canEatFish.get(i).x) {
                        nowCanEatFish = canEatFish.get(i);
                    } else if (nowCanEatFish.x == canEatFish.get(i).x) { //물고기가 같은 위쪽에 있으면
                        if (nowCanEatFish.y > canEatFish.get(i).y) {
                            nowCanEatFish = canEatFish.get(i);
                        }
                    }
                }
            }

            eatCount++;
            fishbowl[nowCanEatFish.x][nowCanEatFish.y] = 0;
            answer += nowCanEatFish.moving;

            queue.add(nowCanEatFish);
        }
    }
}

class Shark {
    int x;
    int y;
    int moving;

    public Shark(int x, int y, int moving) {
        this.x = x;
        this.y = y;
        this.moving = moving;
    }
}
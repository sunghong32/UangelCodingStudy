package baekjoon.algorithm.graphsearch;

import java.io.*;
import java.util.*;

/**
 * [Algorithm]
 * 그래프 이론
 * 그래프 탐색
 * 너비 우선 탐색
 * 비트마스킹
 * [Result]
 * 메모리 : 17324 kb
 * 수행시간 : 148 ms
 */
public class RisingMoon {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n, m;
    private static char[][] maze;
    private static Node start;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) { risingMoon(); stop(); }

    private static String readInput() { try { return READER.readLine(); } catch (Exception e){ return ""; } }
    private static void writeOutput(String output) { try { WRITER.write(output); WRITER.flush(); } catch (IOException ignored) {/* ignored */} }
    private static void stop(){ try { READER.close(); WRITER.close(); } catch (IOException ignored) {/* ignored */} }

    private static void risingMoon() {
        StringTokenizer st = new StringTokenizer(readInput(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new char[n][m];
        for(int i = 0; i < n; i++) {
            maze[i] = readInput().toCharArray();
            for(int j = 0; j < m; j++) {
                if(maze[i][j] == '0') start = new Node(i, j, 0, 0);
            }
        }
        writeOutput(String.valueOf(bfs()));
    }
    public static int bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][64];
        q.offer(start);
        visited[start.x][start.y][0] = true;

        while(!q.isEmpty()) {
            Node current = q.poll();
            if(maze[current.x][current.y] == '1') return current.cost;

            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny][current.key] || maze[nx][ny] == '#') continue;

                if(maze[nx][ny] >= 'a' && maze[nx][ny] <= 'f') {
                    int next_key = 1 << (maze[nx][ny] - 'a');
                    next_key = current.key | next_key;
                    visited[nx][ny][next_key] = true;
                    q.offer(new Node(nx, ny, current.cost + 1, next_key));
                }
                else if(maze[nx][ny] >= 'A' && maze[nx][ny] <= 'F') {
                    if((current.key & 1 << (maze[nx][ny] - 'A')) == (int)Math.pow(2, maze[nx][ny] - 'A')) {
                        visited[nx][ny][current.key] = true;
                        q.offer(new Node(nx, ny, current.cost + 1, current.key));
                    }
                } else {
                    visited[nx][ny][current.key] = true;
                    q.offer(new Node(nx, ny, current.cost + 1, current.key));
                }
            }
        }
        return -1;
    }

    public static class Node {
        int x, y, cost, key;

        public Node(int x, int y, int cost, int key) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.key = key;
        }
    }
}
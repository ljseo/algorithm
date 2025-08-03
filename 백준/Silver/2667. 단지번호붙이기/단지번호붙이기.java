
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> houseCounts = new ArrayList<>();
        int complexCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    complexCount++;
                    houseCounts.add(bfs(i, j));
                }
            }
        }

        System.out.println(complexCount);

        Collections.sort(houseCounts);
        for (int count : houseCounts) {
            System.out.println(count);
        }
    }

    public static int bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX});
        visited[startY][startX] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            for (int i = 0; i < 4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < N &&
                        map[nextY][nextX] == 1 && !visited[nextY][nextX]) {

                    visited[nextY][nextX] = true;
                    queue.offer(new int[]{nextY, nextX});
                    count++;
                }
            }
        }
        return count;
    }
}

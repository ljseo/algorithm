
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] campus;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];
        visited = new boolean[N][M];

        int startY = -1;
        int startX = -1;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = line.charAt(j);
                if (campus[i][j] == 'I') {
                    startY = i;
                    startX = j;
                }
            }
        }

        int peopleCount = bfs(startY, startX);

        if (peopleCount == 0) {
            System.out.println("TT");
        } else {
            System.out.println(peopleCount);
        }
    }

    public static int bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX});
        visited[startY][startX] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            if (campus[y][x] == 'P') {
                count++;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M &&
                        !visited[nextY][nextX] && campus[nextY][nextX] != 'X') {

                    visited[nextY][nextX] = true;
                    queue.offer(new int[]{nextY, nextX});
                }
            }
        }
        return count;
    }
}

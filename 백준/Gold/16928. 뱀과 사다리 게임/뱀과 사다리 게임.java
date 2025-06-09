
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] move = new int[101];
        for(int i = 0; i < move.length; i++){
            move[i] = i;
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            move[a] = b;
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            move[a] = b;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] playCnt = new int[101];
        Arrays.fill(playCnt, -1);
        playCnt[1] = 0;
        queue.add(1);
        while(!queue.isEmpty()){
            int cur = queue.poll();

            if(cur == 100) break;

            for(int i = 1; i<=6; i++){
                int next = cur + i;
                if(next > 100) break;
                int moved = move[next];
                if(playCnt[moved] == -1){
                    playCnt[moved] = playCnt[cur] + 1;
                    queue.add(moved);
                }
            }
        }
        System.out.println(playCnt[100]);
    }
}

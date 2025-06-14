
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n;
    private static List<Integer>[] friend;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        n = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        friend = new List[n +1];
        for (int i = 1; i <= n; i++) {
            friend[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i<M; i++){
            String[] AB = br.readLine().split(" ");
            int A = Integer.parseInt(AB[0]);
            int B = Integer.parseInt(AB[1]);
            friend[A].add(B);
            friend[B].add(A);
        }

        int mx = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 1; i <= n; i++){
            int cnt = bfs(i);
            if(cnt < mx){
                mx = cnt;
                ans = i;
            }
        }
        System.out.println(ans);

    }

    private static int bfs(int start) {
        int[] cnt = new int [n + 1];
        Arrays.fill(cnt, -1);
        cnt[start] = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        while(!queue.isEmpty()){

            int cur = queue.poll();
            for(int i = 0; i<friend[cur].size(); i++){
                int next = friend[cur].get(i);
                if(cnt[next] == -1){
                    queue.add(next);
                    cnt[next] = cnt[cur] + 1;
                }
            }
        }
        int ans = 0;
        for(int i = 1; i<=n; i++){
            ans += cnt[i];
        }
        return ans;
    }
}

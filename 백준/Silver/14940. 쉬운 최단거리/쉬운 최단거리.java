
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int [][] map = new int[n][m];
        int [][] cnt = new int[n][m];

        for(int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            Arrays.fill(cnt[i], -1);
            for(int j = 0; j < m; j++){
                if(map[i][j] != 1) {
                    cnt[i][j] = 0;
                    if(map[i][j] == 2){
                        queue.add(new int[]{i, j});
                    }
                }
            }
        }

        int[] dn = {0,0,1,-1};
        int[] dm = {1,-1,0,0};

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cn = cur[0];
            int cm = cur[1];
            for(int i = 0; i<4; i++){
                int nN = cn + dn[i];
                int nM = cm + dm[i];
                if(nN >= 0 && nM >= 0 && nN < n && nM < m && map[nN][nM] == 1 && cnt[nN][nM] == -1){
                    cnt[nN][nM] = cnt[cn][cm] + 1;
                    queue.add(new int[]{nN, nM});
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(cnt[i][j] + " ");
            }
            System.out.println();
        }
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[N][N];
        int [][] dp = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while(st.hasMoreTokens()) {
                arr[i][idx] = Integer.parseInt(st.nextToken());
                idx++;
            }
        }
        dp[0][0] = arr[0][0];

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(j == 0) dp[i][j] = dp[i-1][j] + arr[i][j];
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[N-1][i]);
        }

        System.out.println(ans);


    }
}

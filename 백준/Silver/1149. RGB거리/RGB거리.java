import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[N+1][3];
        int [][] dp =  new int[N+1][3];

        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][0] = arr[1][0];
        dp[1][1] = arr[1][1];
        dp[1][2] = arr[1][2];
        
        for(int i = 2; i<= N; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
        }
        
        System.out.println(Math.min(dp[N][0],Math.min(dp[N][1], dp[N][2])));
    }
}

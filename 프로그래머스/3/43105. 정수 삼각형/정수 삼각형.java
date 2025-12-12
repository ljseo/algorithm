import java.util.*;

class Solution {
    
    int[][] dp = new int[501][501];
    int[][] grid;
    
    public int solution(int[][] triangle) {
        int n = triangle.length;
        grid = new int[triangle.length][triangle.length];
        for(int i = 0; i < triangle.length; i++){
            for(int j = 0; j < triangle[i].length; j++){
                grid[i][j] = triangle[i][j];
            }
        }
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        dp[0][0] = triangle[0][0];
     

        
        int ans = 0;
        
        for(int i = 0; i < triangle.length; i++){
            ans = Math.max(ans, triangle(triangle.length-1,i));
        }
        
        
        int answer = 0;
        return ans;
    }
    
    int triangle(int row, int col){
        if (col > row) return Integer.MIN_VALUE;
        if(row < 0 || col < 0) return Integer.MIN_VALUE;
        if (dp[row][col] != -1) return dp[row][col];
        if(row == 0) return dp[row][col];
        
        return dp[row][col] = Math.max(triangle(row-1, col), triangle(row-1, col-1)) + grid[row][col];
     
    }
}




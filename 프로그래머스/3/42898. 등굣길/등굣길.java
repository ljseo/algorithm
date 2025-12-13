/*
한칸 당 갈 수 있는 방향이 두 개, 한칸당 2개로 분기됨 
그러면 2^(r+m) 만큼 재귀 ? dfs 로 한다면 

mem[i][j] = path(i + 1, 1) + path(i , j + 1);

종료 조건 row == n, col == m return 1 
row > n || col > m return 0 

*/
import java.util.*;

class Solution {
    
    int[][] mem = new int[101][101];
    int n,m;
    public int solution(int m, int n, int[][] puddles) {
        
        this.m = m;
        this.n = n;
        
        for(var v : mem){
            Arrays.fill(v, -1);
        }
        
        for(int[] puddle : puddles){
            mem[puddle[1]][puddle[0]] = -2;
        }
        
        path(1,1);
        
        return mem[1][1];
    }
            
    int path(int row, int col){
        
        if(row > n || col > m) return 0;
        if(mem[row][col] == -2) return 0;
        if(row == n && col == m) return 1;
        if(mem[row][col] != -1) return mem[row][col];
        
        return mem[row][col] = (path(row + 1, col) + path(row, col + 1)) % 1_000_000_007;
        
    }
            
}






class Solution {
    
    final int[] dr = new int[] { 1, 0,-1};
    final int[] dc = new int[] { 0, 1,-1};
    int n;
    int[][] grid;
    
    public int[] solution(int n) {
        
        this.n = n;
        grid = new int[n][n];
        int v = 1;
        int r = 0;
        int c = 0;
        int d = 0;
        
        while(true){
            grid[r][c] = v++;
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(!inRange(nr, nc) || grid[nr][nc] != 0){
                d = (d+1) % 3;
                nr = r + dr[d];
                nc = c + dc[d];
                if(!inRange(nr, nc) || grid[nr][nc] != 0){
                    break;
                }
            }
            r = nr;
            c = nc;
        }
        
        int[] answer = new int[v-1];
        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer[idx++] = grid[i][j];
            }
        }
        
        return answer;
    }
    
    boolean inRange(int r, int c){
        return 0 <= r && r < n && 0 <= c && c < n;
    }
}
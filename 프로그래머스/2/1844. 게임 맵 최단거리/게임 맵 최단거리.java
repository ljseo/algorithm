import java.util.*;

class Point{
    int r;
    int c;
    public Point (int r, int c){
        this.r = r;
        this.c = c;
    }
}

class Solution {
    
    final int[] dr = new int[]{-1, 1, 0, 0};
    final int[] dc = new int[]{ 0, 0,-1, 1};
    
    int[][] maps;
    int[][] vis;
    int n,m;
    
    public int solution(int[][] maps) {
        
        this.maps = maps;
        n = maps.length;
        m = maps[0].length;
        vis = new int[n][m];
        for(int i = 0; i < maps.length; i++){
            Arrays.fill(vis[i], -1);
        }
        
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0,0));
        vis[0][0] = 1;
        
        while(!queue.isEmpty()){
            
            Point cp = queue.poll();
            
            if(cp.r == n-1 && cp.c == m-1){
                return vis[cp.r][cp.c];
            }
            
            for(int i = 0; i < 4; i++){
                int nr = cp.r + dr[i];
                int nc = cp.c + dc[i];
                
                if(canGo(nr, nc)){
                    vis[nr][nc] = vis[cp.r][cp.c] + 1;
                    queue.add(new Point(nr, nc));
                }
            } 
        }
        
        return -1;
    }
    
    boolean canGo(int r, int c){
        if(!inRange(r, c)) return false;
        if(vis[r][c] != -1) return false;
        if(maps[r][c] != 1) return false;
        return true;
    }
    
    boolean inRange(int r, int c){
        return 0 <= r && r < n && 0 <= c && c < m;
    }
}
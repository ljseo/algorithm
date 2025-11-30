import java.util.*;

class Point{
    long x;
    long y;
    public Point(long x, long y){
        this.x = x;
        this.y = y;
    }
}


class Solution {
    
    int[][] line;
    List<Point> pointList = new ArrayList<>();
    long mnX = Long.MAX_VALUE;
    long mnY = Long.MAX_VALUE;
    long mxX = Long.MIN_VALUE;
    long mxY = Long.MIN_VALUE;
    
    public String[] solution(int[][] line) {
        
        this.line = line;
        int len = line.length;
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                getPoint(i, j);
            }
        }
        
        int lenX = (int)(mxX - mnX + 1);
        int lenY = (int)(mxY - mnY + 1);
        char[][] grid = new char[lenY][lenX];
        for(int i = 0; i < lenY; i++){
            Arrays.fill(grid[i], '.');            
        }
        
        for(Point p : pointList){
            int x = (int)(p.x - mnX);
            int y = (int)(mxY - p.y);
            grid[y][x] = '*';
        }
        
        String[] answer = new String[lenY];
        for(int i = 0; i < lenY; i++){
            answer[i] = String.valueOf(grid[i]);
        }
        return answer;
    }
    
    void getPoint(int i, int j){
        long a1 = line[i][0];
        long b1 = line[i][1];
        long c1 = line[i][2];
        long a2 = line[j][0];
        long b2 = line[j][1];
        long c2 = line[j][2];
        
        double d = (a1 * b2 - a2 * b1);
        if(d == 0) return;
        double x = (c2 * b1 - c1 * b2) / d;
        double y = (c1 * a2 - c2 * a1) / d;
        if(x % 1 == 0 && y % 1 == 0){
            updateMaxMin((long)x,(long)y);
            pointList.add(new Point((long)x, (long)y));
        }
    }
    
    void updateMaxMin(long x, long y){
        mxX = Math.max(mxX, x);
        mxY = Math.max(mxY, y);
        mnX = Math.min(mnX, x);
        mnY = Math.min(mnY, y);
    }
}
import java.util.*;

class Point {
    double r;
    double c;
    public Point (double r, double c){
        this.r = r;
        this.c = c;
    }
}


class Solution {
    
    static List<Point> pointList = new ArrayList<>();
    static double mxR = Integer.MIN_VALUE;
    static double mnR = Integer.MAX_VALUE;
    
    static double mxC = Integer.MIN_VALUE;
    static double mnC = Integer.MAX_VALUE;
    
    public String[] solution(int[][] line) {
        
        int len = line.length;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                getPoint(line[i], line[j]);
            }
        }
        
        Collections.sort(pointList, (o1, o2) -> {
            if(o1.c == o2.c) return (int)o1.r - (int)o2.r;
            return (int)o2.c - (int)o1.c;
        });
    
        int len1 = Math.abs((int)mxC - (int)mnC + 1);
        int len2 = Math.abs((int)mxR - (int)mnR + 1);
        char grid[][] = new char[len1][len2];
        
        for(int i = 0; i < grid.length; i++) Arrays.fill(grid[i], '.');
        for(Point p : pointList){
            int r = (int)p.r;
            int c = (int)p.c;
            r -= mnR;
            c = (int)mxC - c;
            grid[c][r] = '*';
        }
        
        String[] answer = new String[len1];
        for(int i = grid.length-1; i >= 0; i--){
            answer[i] = new String(grid[i]);
        }
        return answer;
    }
    static void getPoint(int[] arr1, int[] arr2){
        long a1 = arr1[0];
        long b1 = arr1[1];
        long c1 = arr1[2];
        long a2 = arr2[0];
        long b2 = arr2[1];
        long c2 = arr2[2];
        long d = a1 * b2 - b1 * a2;
        if(d == 0) return;
        double x = (double)(c2 * b1 - c1 * b2) / (a1 * b2 - a2 * b1);
        double y = (double)(c2 * a1 - c1 * a2) / (b1 * a2 - b2 * a1);
        
        if(x % 1 == 0 && y % 1 == 0){
            mxR = Math.max(mxR, x);
            mnR = Math.min(mnR, x);
            mxC = Math.max(mxC, y);
            mnC = Math.min(mnC, y);
            pointList.add(new Point(x,y));
        }
    }
}
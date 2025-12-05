import java.util.*;

class Solution {
    List<int[]> answer = new ArrayList<>();
    public int[][] solution(int n) {
        hanoi(n, 1, 3);
        return answer.toArray(new int[0][]);
    }
    
    void hanoi(int n, int from, int to){
        
        if(n == 1){
            answer.add(new int[]{from, to});
            return;
        }
        int left = 6 - from - to;
        hanoi(n-1, from, left);
        hanoi(1, from, to);
        hanoi(n-1, left, to);
        
    }
}
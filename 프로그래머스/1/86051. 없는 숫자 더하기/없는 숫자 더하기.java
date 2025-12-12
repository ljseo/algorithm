import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int n : numbers){
            set.add(n);
        }
        
        int answer = 0;
        for(int i = 0; i <= 9; i++){
            if(set.contains(i)) continue;
            answer += i;
        }
        
        return answer;
    }
}
/*


*/
import java.util.*;

class Solution {
    int[] citations;
    public int solution(int[] citations) {
        Arrays.sort(citations);
        this.citations = citations;
        int answer = 0;
        for(int i = 1; i <= 1000; i++){
            if(isValid(i)){
                answer = i;
            }
        }
        
        return answer;
    }
    
    boolean isValid(int h) {
        int cnt = 0;
        for (int c : citations) {
            if (c >= h) cnt++;
        }
        return cnt >= h;
    }
    
    
}
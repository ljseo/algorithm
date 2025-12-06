import java.util.*;

class Solution {
    
    
    int[] cnt = new int[10];
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        for(char c : numbers.toCharArray()){
            cnt[c - '0']++;
        }
        for(int i = 1; i <= numbers.length(); i++){
            createNumber("", 0,i);
        }
        return set.size();
    }
    
    void createNumber(String number, int currentDepth, int targetDepth){
        if(currentDepth == targetDepth){
            if(isPrime(number)) set.add(Integer.parseInt(number));
            return;
        }
        
        int count = 0;
        
        for(int i = 0; i < cnt.length; i++){
            if(cnt[i] == 0) continue;
            cnt[i]--;
            createNumber(number+i, currentDepth+1, targetDepth);
            cnt[i]++;
        }
        
    }
    
    boolean isPrime(String number){
        
        int num = Integer.parseInt(number);
        if(num < 2) return false;
        for(int i = 2; i <= (int) Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
 
}
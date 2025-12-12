import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> map = new HashMap<>();
        for(String s : completion){
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s) + 1);
        }
        
        String answer = "";
        for(String s : participant){
            
            if(!map.containsKey(s) || map.get(s) == 0) {
                answer = s;
                break;
            }
            map.put(s, map.get(s) - 1);
        }
        
        return answer;
    }
}
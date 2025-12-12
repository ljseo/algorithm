/*
처음 생각 나는 것은 counting sort 

하지만 Map 이용해서도 가능 
*/
import java.util.*;

class Solution {
    public int solution(String before, String after) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        
        for(char c : before.toCharArray()){
            map1.putIfAbsent(c, 0);
            map1.put(c, map1.get(c) + 1);
        }
        
        for(char c : after.toCharArray()){
            map2.putIfAbsent(c, 0);
            map2.put(c, map2.get(c) + 1);
        }
        return map2.equals(map1) ? 1 : 0;
    }
}
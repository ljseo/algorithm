/*
- 한번에 한 알파벳만 바꿀 수 있다
- 바꾼 단어는 주어진 words에 있어야 한다 

*/
import java.util.*;

class Pair{
    String s;
    int cnt;
    public Pair(String s, int cnt){
        this.s = s;
        this.cnt = cnt;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        Deque<Pair> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[words.length];
        
        queue.add(new Pair(begin, 0));
        
        int answer = 0;
        while(!queue.isEmpty()){
            Pair cp = queue.poll();
            
            if(cp.s.equals(target)) {
                answer = cp.cnt;
                break;
            }
            
            String cs = cp.s;
            
            for(int i = 0; i < words.length; i++){
                
                if(vis[i]) continue;
                
                String w = words[i];
                int count = 0;
                for(int j = 0; j < w.length(); j++){
                    if(w.charAt(j) != cs.charAt(j)) count++;
                }
                if(count == 1){
                    vis[i] = true;
                    queue.add(new Pair(w, cp.cnt + 1));
                }
            }  
        }
        // System.out.println(queue.size());
        
        return answer;
    }
}
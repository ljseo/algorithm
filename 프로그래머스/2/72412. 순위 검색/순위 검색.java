import java.util.*;

class Solution {
    
    Map<String, List<Integer>> map = new HashMap<>();
    String[] info; 
    String[] query;
    
    public int[] solution(String[] info, String[] query) {
        
        this.info = info;
        this.query = query;
        buildScoresMap();
        
        for(var list : map.values()){
            Collections.sort(list);
        }
        
        int[] answer = sol();
    
        return answer;
    }
    
    int[] sol(){
        
        int[] answer = new int[query.length];
        int idx = 0;
        for(String s : query){
            String[] splited = s.split(" and ");
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < splited.length - 1; i++){
                sb.append(splited[i]);
            }
            String[] last = splited[splited.length-1].split(" ");
            sb.append(last[0]);

            answer[idx++] = findNum(sb.toString(), Integer.parseInt(last[1]));
            // System.out.println(sb);
            
        }
        
        return answer;
        
    }
    
    int findNum(String key, int num){
        
        List<Integer> list = map.get(key);
        if (list == null) return 0;
        int start = 0;
        int end = list.size();
        
        while(start < end){
            int mid = (start + end) / 2;
            
            if(list.get(mid) >= num){
                end = mid;
            }
            else {
                start = mid + 1;
            }
            
        }
        // System.out.print(key + " " + start + " " + list.size() + " ");
        // System.out.print(list.toString());
        // System.out.println(list.size() - start);
        return list.size() - start;
        
    }
    
    
    void buildScoresMap(){       
        for(String s : info){
            String[] ss = s.split(" ");
            forEachKey(ss, 0, "");
        }        
    }
    
    void forEachKey(String[] s, int idx, String currentS){
        if(idx == s.length - 1){
            List<Integer> list = map.getOrDefault(currentS, new ArrayList<>());
            list.add(Integer.parseInt(s[s.length-1]));
            map.put(currentS, list);
            return;
        }
        
        forEachKey(s, idx+1, currentS + s[idx]);
        forEachKey(s, idx+1, currentS + "-");
    }
}
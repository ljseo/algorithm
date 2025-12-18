/*

k번 이상 신고 당하면 정지당하고, 정지가 되면 신고한 아이디에 메일이 간다 

이때 동일 유저에 대한 신고는 1회로 취급, 즉 중복 신고는 가능하지만 카운팅 안됨 

Map<String, Set<String>> map
key: 신고 당한 유저 아이디, value: 해당 유저를 신고한 아이디 

Map을 순회하며 value.size()가 k이상이라면 set에 있는 유저 메일 + 1 

시간복잡도: O(200000 + 1000 * 1000)

*/
import java.util.*;

class Solution {
    
    Map<String, Set<String>> map = new HashMap<>();
    Map<String, Integer> mailCount = new HashMap<>();
    
    public int[] solution(String[] idList, String[] report, int k) {
        
        addMap(report);
        for(var e : map.entrySet()){
            if(e.getValue().size() < k){
                continue;
            }
            addCount(e.getValue());
        }
        
        int[] answer = new int[idList.length];
        int idx = 0;
        for(String s : idList){
            answer[idx++] = mailCount.getOrDefault(s, 0);
        }
        
        return answer;
    }
    
    void addMap(String[] report){
        StringTokenizer st;
        for(String s : report){
            st = new StringTokenizer(s);
            String userId = st.nextToken();
            String reportedId = st.nextToken();
            map.putIfAbsent(reportedId, new HashSet<>());
            Set<String> set = map.get(reportedId);
            set.add(userId);
        }
    }
    
    void addCount(Set<String> set){
        for(String s : set){
            mailCount.putIfAbsent(s, 0);
            int cnt = mailCount.get(s) + 1;
            mailCount.put(s, cnt);
        }
    }
}
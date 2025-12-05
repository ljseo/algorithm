import java.util.*;

class Solution {
    
    final int[] select1 = {1,2,3,4,5};
    final int[] select2 = {2,1,2,3,2,4,2,5};
    final int[] select3 = {3,3,1,1,2,2,4,4,5,5};
    
    public int[] solution(int[] answers) {
        int cnt1 =0;
        int cnt2 =0;
        int cnt3 =0;
        int idx1 = 0;
        int idx2 = 0;
        int idx3 = 0;
        for(int a : answers){
            if(select1[idx1] == a){
                cnt1++;
            }
            if(select2[idx2] == a){
                cnt2++;
            }
            if(select3[idx3] == a){
                cnt3++;
            }
            idx1 = (idx1+1) % select1.length;
            idx2 = (idx2+1) % select2.length;
            idx3 = (idx3+1) % select3.length;
            
        }
        List<Integer> list = new ArrayList<>();
        int mx = Math.max(cnt1, Math.max(cnt2, cnt3));
        if(mx == cnt1){
            list.add(1);
        }
        if(mx == cnt2){
            list.add(2);
        }
        if(mx == cnt3){
            list.add(3);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
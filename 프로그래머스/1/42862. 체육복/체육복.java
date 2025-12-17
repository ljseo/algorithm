/*

여벌을 가지고 있는 학생은 각자 앞, 뒤의 학생에게 체육복을 줄 수 있음 

방법은 두 가지로 보임 
- 앞을 먼저 주고, 뒷 사람 주기 
- 뒤를 먼저 주고, 앞 사람 주기 

*/

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] stu = new int[n + 1];
        Arrays.fill(stu, 1);
        for(var a : lost){
            stu[a] -= 1;
        }
        for(var a : reserve){
            stu[a] += 1;
        }
        
        for(int i = 0; i <= n; i++){
            if(stu[i] < 2){
                continue;
            }
            if(i + 1 <= n && stu[i + 1] == 0){
                stu[i + 1] += 1;
            }
            else if(0 < i - 1 && stu[i - 1] == 0){
                stu[i - 1] += 1;
            }
        }
        
        int cnt = 0;
        for(var a : stu){
            if(a < 1) {
                continue;
            }
            cnt++;
        }
        
        int answer = cnt;
        cnt = 0;
        Arrays.fill(stu, 1);
        for(var a : lost){
            stu[a] -= 1;
        }
        for(var a : reserve){
            stu[a] += 1;
        }
        
        for(int i = 0; i <= n; i++){
            if(stu[i] < 2){
                continue;
            }
            if(0 < i - 1 && stu[i - 1] == 0){
                stu[i - 1] += 1;
            }
            else if(i + 1 <= n && stu[i + 1] == 0){
                stu[i + 1] += 1;
            }
        }
        
        for(var a : stu){
            if(a < 1) {
                continue;
            }
            cnt++;
        }
        
        answer = Math.max(answer, cnt);
        
        return answer - 1;
    }
}




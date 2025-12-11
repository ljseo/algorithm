/*

1. 시간 t를 정하고 해당 시간 내에 모든 인원 n의 입국 심사를 마칠 수 있는지 판단 
2. 시간 t를 정하는 과정은 이분탐색으로 진행 
3. 한 심사관이 시간 t 내에 심사할 수 있는 인원은 t/times[i] 
4. 모든 심사관이 심사할 수 있는 인원을 더했을 때 n이 되면 해당 시간 내에 입국 심사 가능 
5. 가능한 시간 t 중 최솟값을 찾아야 하기에 lower_bound로 진행함
(가능하다면 end = mid)

*/

class Solution {
    
    final long MAX_T = (long)1e13;
    int n;
    int[] times;
    
    public long solution(int n, int[] times) {
        this.n = n;
        this.times = times;
        return binarySearch();
    }
    
    long binarySearch(){
        
        long start = 1;
        long end = MAX_T;
        while(start < end){ // start == end 종료
            
            long mid = (start + end) / 2;
            
            if(isPossible(mid)) {
                end = mid;
            }
            
            else{
                start = mid + 1;
            }
            
        }
        return start;   
    }
    
    boolean isPossible(long t){
        long sum = 0;
        for(long time : times){
            sum += t/time;
        }
        return sum >= n;
    }
    
    
}
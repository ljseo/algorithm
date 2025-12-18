/*
n을 k진수로 변환 Integer.toString(n, k);

변환된 수의 길이가 최대 일때는 k가 2일 때, 즉 이진수로 변환했을 때, 
이진수로 n의 최댓값인 1,000,000을 나타내기 위해 필요한 최대 길이는 2^20 즉 20 

변환된 수에서 0을 기준으로 분리하고 분리된 수들을 List에 저장 (중복되는 수도 따로 세야함)

분리된 수들을 10진수로 변환 후 소수 판별 

*/
import java.util.*;

class Solution {
    public int solution(int n, int k) {
        
        List<String> list = new ArrayList<>();
        String converted = Integer.toString(n, k);
        StringTokenizer st = new StringTokenizer(converted, "0");
        
        while(st.hasMoreTokens()){
            list.add(st.nextToken());
        }
        
        int cnt = 0;
        for(String s : list){
            long num = Long.parseLong(s);
            if(isPrime(num)) cnt++;
        }
        
        return cnt;
    }
    
    boolean isPrime(long num){
        if(num < 2) return false;
        for(int i = 2; i <= (int)Math.sqrt(num); i++){
            if(num % i == 0) return false; 
        }
        return true;
    }
    
}
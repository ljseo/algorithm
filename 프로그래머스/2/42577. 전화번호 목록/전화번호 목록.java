/*
startWith 메서드를 이용해 한 string으로 시작하는 다른 문자열이 있는지 
전체 문자열을 순회하며 확인하는 방법은 
n^2의 시간복잡도가 드는데, 이때 n의 최대가 100만이라 불가능 

현재 문자열에서 substring(0, i)  i는 1 ~ string.length
한 문자열이 HashSet에 존재하는지 확인.

이때 전화번호 길이는 20, 최대 20 반복 그리고 n번 
총 시간 복잡도는 O(20 n) = 2천만으로 가능 

이때 Set에 모든 문자열 추가 후 시작 

*/

import java.util.*;

class Solution {
    
    Set<String> set = new HashSet<>();
    public boolean solution(String[] phone_book) {
        for(var s : phone_book){
            set.add(s);
        }
        
        for(var s : phone_book){
            if(isPrefix(s)) return false;
        }
    
        return true;
    }
    boolean isPrefix(String s){
        for(int i = 1; i < s.length(); i++){
            if(set.contains(s.substring(0, i))){
                return true;
            }
        }
        return false;
    }
}
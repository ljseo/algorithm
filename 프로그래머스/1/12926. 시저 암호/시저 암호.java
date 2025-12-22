import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] arr = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            char c = arr[i];
            if(!Character.isAlphabetic(c)) continue;
            arr[i] = push(n, c);
        }
        
        return String.valueOf(arr);
    }
    char push(int n, char c){
        if(Character.isLowerCase(c)) {
            return (char)(((c - 'a' + n) % ('z' - 'a' + 1)) + 'a');
        }
        return (char)(((c - 'A' + n) % ('Z' - 'A' + 1)) + 'A');
    }
}
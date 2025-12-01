import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();
        boolean isUpper = true;
        for(char c : s.toCharArray()){
            if(!Character.isAlphabetic(c)) {
                builder.append(c);
                isUpper = true;
                continue;
            }
            if(isUpper){
                builder.append(Character.toUpperCase(c));
                isUpper = false;
            }
            else{
                builder.append(Character.toLowerCase(c));
                isUpper = true;
            }
        }
        
        return builder.toString();
    }
}
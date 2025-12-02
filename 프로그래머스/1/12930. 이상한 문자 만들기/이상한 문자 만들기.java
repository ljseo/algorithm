/*
1. 단어는 하나 이상의 공백으로 구분됨 (하나 이상이란 것에 주의)
2. 따라서 모든 공백 이후 알파벳부터 0번으로 취급해야함 
3. 홀수는 소문자, 짝수는 대문자 
4. 0번은 짝수로 취급 
5. 3,4 의 과정을 위해서는 공백 이후부터 단어의 인덱스를 0부터 센 후 나머지 연산을 하거나 
6. boolean 변수를 이용해 공백이 나타나면 다음 알파벳은 짝수, 짝수 이후에는 홀수로 변경하며 
이에 따라 대,소문자를 변환한다 

*/
import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();
        
        boolean isEven = true;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(c == ' '){
                isEven = true;
                builder.append(c);
            }
            else if(isEven){
                c = Character.toUpperCase(c);
                builder.append(c);
                isEven = false;
            }
            else {
                c = Character.toLowerCase(c);
                builder.append(c);
                isEven = true;  
            }
        }
        
        return builder.toString();
    }
}
import java.util.*;

class Solution {
    static final int MAX_STR_LEN = 1000;
    int len;

    String compress(String s, int width){
        
        StringBuilder builder = new StringBuilder();
        String preStr = s.substring(0, width);
        int cnt = 1;
        int leftIdx = -1;
        for(int i = width; i < len; i+=width){
            if(i + width > len) {
                leftIdx = i;
                break;
            }
            
            String currentStr = s.substring(i, i+width);
            if(currentStr.equals(preStr)){
                cnt++;
            }
            else{
                if(cnt != 1){
                    builder.append(cnt);    
                }
                builder.append(preStr);
                cnt = 1;
                preStr = currentStr;
            }
        }
        if(cnt != 1){
            builder.append(cnt);    
        }
        builder.append(preStr);
        if(leftIdx != -1) builder.append(s.substring(leftIdx));
        return builder.toString();
    }
    
    public int solution(String s) {
        len = s.length();
        int mxLen = MAX_STR_LEN + 1;
        for(int i = 0; i < len; i++){
            String compressed = compress(s, i+1);
            mxLen = Math.min(mxLen, compressed.length());
        }
        return mxLen;
    }
}
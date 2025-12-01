class Solution {
    
    int n;
    public String solution(String s, int n) {
        this.n = n;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            chars[i] = push(chars[i]);
        }
        return String.valueOf(chars);
    }
    
    char push(char c){
        if(isLowerCase(c)){
            return (char)((c - 'a' + n) % ('z' - 'a' + 1) + 'a');
        }
        else if(isUpperCase(c)){
            return (char)((c - 'A' + n) % ('Z' - 'A' + 1) + 'A');
        }
        return c;
    }
    
    boolean isLowerCase(char c){
        return 'a' <= c && c <= 'z';
    }
    boolean isUpperCase(char c){
        return 'A' <= c && c <= 'Z';
    }
}
class Solution {
    public String solution(String s, int n) {
        
        StringBuilder builder = new StringBuilder();
        for(char c : s.toCharArray()){
            if(!Character.isAlphabetic(c)) {
                builder.append(c);
                continue;
            }
            char offset = Character.isUpperCase(c) ? 'A' : 'a';
            char len = ('z' - 'a' + 1);
            builder.append((char)((c - offset + n) % len + offset));
        }
        
        return builder.toString();
    }
}
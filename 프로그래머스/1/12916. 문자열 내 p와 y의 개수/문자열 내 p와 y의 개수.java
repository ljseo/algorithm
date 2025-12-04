class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();
        int rs = s.length() - s.replace("p", "").length();
        int ys = s.length() - s.replace("y", "").length();
    
        return rs == ys;
    }
}
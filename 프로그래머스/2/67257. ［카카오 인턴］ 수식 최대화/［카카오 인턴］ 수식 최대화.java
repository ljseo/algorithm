import java.util.*;

class Solution {
    
    char[][] ops = {
        {'*','+','-'}, {'*','-','+'},
        {'+','*','-'}, {'+','-','*'},
        {'-','*','+'}, {'-','+','*'}
    };
    
    public long solution(String expression) {
        
        StringTokenizer st = new StringTokenizer(expression, "*+-", true);
        List<String> tokens = new ArrayList<>();
        while(st.hasMoreTokens()){
            tokens.add(st.nextToken());
        }
        
        long mx = -1;
        for(int i = 0; i < ops.length; i++){
            long res = calculate(new ArrayList<>(tokens), ops[i]);
            res = Math.abs(res);
            mx = Math.max(mx,res);
        }
        return mx;
    }
    
    long calculate(List<String> tokens, char[] ops){
        
        for(int i = 0; i < ops.length; i++){
            for(int j = 0; j < tokens.size(); j++){
                if(tokens.get(j).charAt(0) == ops[i]){
                    long lhs = Long.parseLong(tokens.get(j-1));
                    long rhs = Long.parseLong(tokens.get(j+1));
                    long res = calculate(lhs, rhs, ops[i]);
                    tokens.remove(j-1);
                    tokens.remove(j-1);
                    tokens.remove(j-1);
                    tokens.add(j-1, Long.toString(res));
                    j -= 1;
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }
    
    long calculate(long lhs, long rhs, char op){
        return switch(op) {
            case '*' -> lhs * rhs;
            case '+' -> lhs + rhs;
            case '-' -> lhs - rhs;
            default -> 0;
        };
    }
}
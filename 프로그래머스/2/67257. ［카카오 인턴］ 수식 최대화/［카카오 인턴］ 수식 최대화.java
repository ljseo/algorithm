class Solution {
    
    final char[][] priority = {
        {'*','+','-'}, {'*','-','+'},
        {'+','*','-'}, {'+','-','*'},
        {'-','*','+'}, {'-','+','*'}
    };
    
    public long solution(String expression) {
        
        long mx = 0;
        for(int i = 0; i < priority.length; i++){
            long res = cal(i, expression);
            mx = Math.max(mx, Math.abs(res));
        }
        
        return mx;
    }
    
    long cal(int idx, String expression){
        char[] operators = priority[idx];        

        for(int i = 0; i < operators.length; i++){
            char operator = operators[i];

            while (true) {
                int pos = findOperator(expression, operator);
                if (pos == -1) break;
                expression = create(operator, expression, pos);
            }
        }
        return Long.parseLong(expression);
    }

    // ★ 연산자 위치를 올바르게 찾는 메서드: 음수부호 '-'는 제외
    int findOperator(String expression, char operator) {
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) != operator) continue;

            // '-'가 연산자인지 판별 (앞이 숫자일 때만 연산자)
            if (operator == '-') {
                if (i == 0 || !Character.isDigit(expression.charAt(i - 1))) {
                    continue;
                }
            }

            return i; // 연산자 위치 반환
        }
        return -1; 
    }

    // 실제 계산된 결과로 식을 치환
    String create(char operator, String expression, int mid) {

        // ------ 왼쪽 숫자 파싱 ------
        int start = -1;
        for (int j = mid - 1; j >= 0; j--) {
            char c = expression.charAt(j);

            if (Character.isDigit(c)) continue;

            // 음수부호인지?
            if (c == '-') {
                if (j == 0 || !Character.isDigit(expression.charAt(j - 1))) {
                    start = j; 
                    break;
                }
            }
            start = j + 1;
            break;
        }
        if (start == -1) start = 0;

        // ------ 오른쪽 숫자 파싱 ------
        int end = -1;
        int len = expression.length();

        for (int j = mid + 1; j < len; j++) {
            char c = expression.charAt(j);

            // 첫 글자가 '-'라면 단항 음수
            if (j == mid + 1 && c == '-') continue;

            if (Character.isDigit(c)) continue;

            end = j;
            break;
        }
        if (end == -1) end = len;

        // ------ 부분식 계산 ------
        String first = expression.substring(start, mid);
        String second = expression.substring(mid + 1, end);
        String res = calc(first, second, operator);

        // ------ 식 치환 ------
        return expression.substring(0, start) + res + expression.substring(end);
    }

    String calc(String f, String s, char o){
        long first = Long.parseLong(f);
        long second = Long.parseLong(s);
        if(o == '*') return Long.toString(first * second);
        if(o == '+') return Long.toString(first + second);
        return Long.toString(first - second);
    }
}

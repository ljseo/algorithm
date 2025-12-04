class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int zeroCnt = 0;
        while(!s.equals("1")){
            cnt++;
            for(char c : s.toCharArray()){
                if(c == '0') zeroCnt++;
            }
            s = s.replace("0", "");
            int len = s.length();
            s = Integer.toString(len, 2);
        }
        
        int[] answer = new int[] {cnt, zeroCnt};
        return answer;
    }
}
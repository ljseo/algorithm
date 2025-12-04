class Solution {
    public int solution(int n) {
        
        StringBuilder builder = new StringBuilder(Integer.toString(n, 3));
        builder.reverse();
        int answer = Integer.parseInt(builder.toString(),3);

        return answer;
    }
}
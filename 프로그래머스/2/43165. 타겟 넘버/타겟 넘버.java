/*



*/

class Solution {
    
    int[] numbers;
    int target;
    int answer = 0;
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        dfs(0, 0);
        return answer;
    }
    
    public void dfs(int idx, int currentNum){
        if(idx == numbers.length){
            if(currentNum == target){
                answer++;
            }
            return;
        }
        
        dfs(idx + 1, currentNum + numbers[idx]);
        dfs(idx + 1, currentNum - numbers[idx]);
        
    }
    
}
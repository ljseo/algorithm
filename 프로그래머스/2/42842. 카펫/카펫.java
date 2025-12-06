/*
3x3 이상 
가로의 최대 길이를 생각해보면 
세로가 3으로 고정되고 가로가 최대가 되면 갈색격자가 최대가 됨 
양옆 3+3 + 2*x - 4= 5000
가로는 최대 2501 
이때 세로는 가로와 같거나 작아야 함 

격자의 개수는 i * j
이때 갈색 격자의 개수는 2*i + 2*j - 4 
노란 격자 수는 총 격자의 수 - 갈색 격자

*/

class Solution {
    public int[] solution(int brown, int yellow) {
        
        for(int i = 3; i <= 2501; i++){
            for(int j = 3; j <= i; j++){
                int total = i * j;
                int b = 2 * i + 2 * j - 4;
                int y = total - b;
                if(y == yellow && b == brown){
                    return new int[]{i, j};
                }
            }
        }
        int[] answer = {};
        return answer;
    }
}
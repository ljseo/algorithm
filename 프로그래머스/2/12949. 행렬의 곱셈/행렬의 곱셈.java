/*
1. 계산 결과의 자료형 20 * 20 * 100 = 40000 -> int형으로 가능 
2. 행렬의 곱셈에는 조건이 있다 
행렬 A의 크기가 r1 c1 이고 
행렬 B의 크기가 r2 c2 라면 
행렬 A에 행렬 B를 곱하기 위해서는 
c1 과 r2가 같아야 한다는 것이다 
(r1 * c1) * (r2 * c2)
이렇게 나란히 세워보면 
행렬 A의 행의 길이와 
행렬 B의 열의 길이가 같다는 것을 알 수 있다 
해당 사실로 인해 행렬 A의 행에 해당 하는 각 원소와 
행렬 B의 열에 해당하는 각 원소를 곱해 더하는 것을 유추할 수 있다 
어떤 행렬의 열과 행을 곱해야하는지 헷갈릴 때 위 사실로 인해 감을 잡을 수 있다 

3. 결과 행렬의 크기는 행렬 A의 c1 행렬 B의 r2 
*/


class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int lenR = arr1.length;
        int lenC = arr2[0].length;
        
        int[][] answer = new int[lenR][lenC];
        
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < answer[i].length; j++){
                int sum = 0;    
                for(int k = 0; k < arr1[i].length; k++){
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        
        return answer;
    }
}

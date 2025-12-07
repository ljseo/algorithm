/*
1. 두 개의 수를 뽑아 조합 
2. nC2 를 계산해서 배열 크기를 만들 수도 있지만 그냥 List 사용
(시간 복잡도가 차이 나지 않는 이상 가장 실수가 발생할 가능성이 적고 구현이 쉬운 쪽으로 작성해야한다)

중복은 안됨 -> Set으로 할건데, HashSet은 정렬이 안됨 (순서를 고려하지 않아서)
TreeSet으로 해야함

*/

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}
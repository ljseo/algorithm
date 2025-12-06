import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        List<Integer> list = new ArrayList<>();
        for(int[] cmd : commands){
            int i = cmd[0]-1;
            int j = cmd[1]-1;
            int k = cmd[2]-1;
            int [] a = IntStream.range(i,j+1)
                .map(idx -> array[idx])
                .sorted()
                .toArray();
            list.add(a[k]);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
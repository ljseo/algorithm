import java.util.*;

class Solution {
    
    public String solution(int[] numbers) {
        
        numbers = Arrays.stream(numbers)
            .boxed()
            .sorted((o1, o2) -> {
                String s1 = o1.toString();
                String s2 = o2.toString();
                
                int original = Integer.parseInt(s1 + s2);
                int reverse = Integer.parseInt(s2 + s1);
                return reverse - original;
                
            })
            .mapToInt(i -> i)
            .toArray();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length; i++){
            sb.append(numbers[i]);
        }
        return sb.toString().replaceAll("^0+", "0");
    }
}
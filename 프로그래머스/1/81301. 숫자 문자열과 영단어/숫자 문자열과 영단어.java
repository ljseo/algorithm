class Solution {
    
    final String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public int solution(String s) {
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        int len = s.length();
        for(int i = 0; i < len; i++){
            if(!Character.isAlphabetic(chars[i])){
                builder.append(chars[i]);
                continue;
            }
            for(int j = 0; j < words.length; j++){
                String find = words[j];
                int endIdx = i + find.length();
                if(endIdx > len) continue;
                String sub = s.substring(i, endIdx);
                if(find.equals(sub)){
                    builder.append(j);
                }
            }
        }
        
        int answer = Integer.parseInt(builder.toString());
        return answer;
    }
}




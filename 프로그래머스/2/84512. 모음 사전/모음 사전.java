class Solution {
    String word;
    int answer = 0;
    int cnt = 0;
    char[] words = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        this.word = word;
        StringBuilder builder = new StringBuilder();
        recur(builder,0);
        return answer;
    }
    
    void recur(StringBuilder builder, int order){
        if(builder.toString().equals(word)){
            answer = cnt;
        }
        if(builder.length() == words.length){
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            cnt++;
            recur(builder.append(words[i]), order+1);
            builder.deleteCharAt(order);
        }
    }
    
}
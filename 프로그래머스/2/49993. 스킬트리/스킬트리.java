/*
skillTrees의 skillTree가 가능한지 아닌지 skill을 통해 판단하고 
가능한 skillTree의 개수를 return 

idx는 skill의 첫번째 인덱스를 가리키고 
skillTree의 원소가 idx가 가리키는 원소와 다르다면 
skillTree의 원소가 skill에 있는지 확인, 만약 있다면 
순서가 지켜지지 않았으므로 return false 
없다면 continue

skillTree의 현재 원소와 idx가 가리키는 원소가 같다면 idx+1한 후 계속 진행 
skillTree를 정상적으로 순회했다면 return true


*/

class Solution {
    
    String skill;
    public int solution(String skill, String[] skillTrees) {
        
        this.skill = skill;
        int cnt = 0;
        for(String skillTree : skillTrees){
            if(isCorrect(skillTree)){
                cnt += 1;    
            }
        }
        
        return cnt;
    }
    
    boolean isCorrect(String skillTree){
        
        int idx = 0;
        for(char c : skillTree.toCharArray()){
            if(c != skill.charAt(idx)){
                if(isInclude(c)){
                    return false;
                }
                continue;
            }
            idx += 1;
            if(idx >= skill.length()) break;
        }
        return true;
    }
    boolean isInclude(char c){
        for(char a : skill.toCharArray()){
            if(a == c) return true;
        }
        return false; 
    }
}

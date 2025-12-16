class Solution {
    
    boolean[] visited;
    int[][] computers;
    int n;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.n = n;
        this.computers = computers;
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(computers[i][j] == 1 && !visited[i]){
                    answer++;
                    dfs(i);
                }
            }
        }
        return answer;
    }
    public void dfs(int node){
        visited[node] = true;
        
        for(int i = 0; i < n; i++){
            if(computers[node][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
        
    }
}
class Point {
    int r;
    int c;
    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}
class Solution {
    static final int[] dr = {-1, 0, 0, 1}; // 상좌우하
    static final int[] dc = { 0,-1, 1, 0}; 
    
    boolean isDistanced(char[][] room, int r, int c){
        
        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(!(0 <= nr && nr < room.length && 0 <= nc && nc < room[0].length)) continue;
            if(room[nr][nc] == 'X') continue;
            if(room[nr][nc] == 'P') return false;
            if(room[nr][nc] == 'O') {
                if(!isDistanced(room, nr, nc, 3-i)) return false;
            }
        }
        return true;
    }
    
    boolean isDistanced(char[][] room, int r, int c, int d){
        
        for(int i = 0; i < 4; i++){
            if(i == d) continue;
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(!(0 <= nr && nr < room.length && 0 <= nc && nc < room[0].length)) continue;
            if(room[nr][nc] == 'X') continue;
            if(room[nr][nc] == 'P') return false;
        }
        return true;
    }
    
    boolean isDistanced(String[] place){
        int rows = place.length;
        int cols = place[0].length();
        char[][] room = new char[rows][cols];
        for(int i = 0; i < rows; i++){
            room[i] = place[i].toCharArray();
        }
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(room[i][j] != 'P') continue;
                if(!isDistanced(room, i, j)) return false;
            }
        }
        return true;
    }
    
    
    public int[] solution(String[][] places) {
        
        int[] answer = new int[places.length];
        for(int i = 0; i < places.length; i++){
            if(isDistanced(places[i])){
                answer[i] = 1;
            }
            else{
                answer[i] = 0;
            }
        }
        
        return answer;
    }
}


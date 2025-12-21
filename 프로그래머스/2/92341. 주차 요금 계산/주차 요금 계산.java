/*
차량번호를 키로하는 맵을 생성하고 입차, 출차 시간을 기록
출차시간은 records에 없는 때를 대비해서 default값을 23:59로 
단위를 분으로 저장

맵의 키를 list로 변환한 후 해당 list를 sort한 후 
list를 순회하며 요금 계산, 

5000 + ((출차 시간 - 입차 시간) - 180  + 5 (반올림)) / 10 


*/
import java.util.*;

class Time {
    String enter;
    String out;
    int sum = 0; 
    
    public Time(String enter){
        this.enter = enter;
        this.out = "23:59";
    }
    
    public String toString(){
        return new String(enter + " " + out);
    }
    
    public void sum(){
        int enterM = toMinute(enter);
        int outM = toMinute(out);
        this.sum += (outM - enterM); 
    }
    
    int toMinute(String s){
        StringTokenizer st = new StringTokenizer(s, ":");
        return Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
    }
}

class Solution {
    Map<String, Time> map = new HashMap<>();
    public int[] solution(int[] fees, String[] records) {
        
        StringTokenizer st;
        
        for(String r : records){     
            st = new StringTokenizer(r);
            String t = st.nextToken();
            String carNum = st.nextToken();
            String type = st.nextToken();
            
            if(type.equals("IN")){
                map.putIfAbsent(carNum, new Time(t));   // 없을 때만 생성
                Time time = map.get(carNum);            // 기존 객체 가져오기
                time.enter = t;                         // 이번 입차시간 갱신
                time.out = "23:59";                     // 아직 출차 전 기본값
            }
            else{
                Time time = map.get(carNum);
                time.out = t;
                time.sum();
            }
        }
        
        for(Time t : map.values()){
            if(t.out.equals("23:59")){
                t.sum();
            }
        }
        
        List<String> list = new ArrayList(map.keySet());
        list.sort((o1, o2) -> {
            return o1.compareTo(o2);
        });
        int[] answer = new int[list.size()];
        int idx = 0;
        for(String s : list){
            answer[idx++] = cal(fees, map.get(s).sum);
        }
        
        return answer;
    }
    int cal(int[] fees, int time){
        int total = fees[1];
        time -= fees[0];
        if(time > 0){
            if(time % fees[2] != 0) time += fees[2];
            time /= fees[2];
            total += time * fees[3];
        }
        return total;
        
    }
}
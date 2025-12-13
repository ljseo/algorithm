/*



*/

class Solution {
    public String solution(int[] numbers, String hand) {
        
        int left = 10;
        int right = 12;
        StringBuilder sb = new StringBuilder();
        System.out.println(getCost(5,8));
        System.out.println(getCost(3,8));
        for(int n : numbers){
    
            switch (n) {
                case 1,4,7 -> {
                    left = n;
                    sb.append("L");
                }
                case 3,6,9 -> {
                    right = n;
                    sb.append("R");
                }
                default -> {
                    if(n == 0) n = 11;
                    int lc = getCost(left, n);
                    int rc = getCost(right, n);

                    if(lc != rc){
                        if(lc > rc){
                            sb.append("R");
                            right = n; 
                        }
                        else{
                            sb.append("L");
                            left = n;
                        }
                    }
                    else{
                        if(hand.equals("left")){
                            sb.append("L");
                            left = n;
                        }
                        else{
                            sb.append("R");
                            right = n;
                        }
                    }
                }
            }
            
        }
        
        return sb.toString();
    }
    int getCost(int m, int n){
        m -= 1;
        n -= 1;
        int cost = 0;
        
        cost += Math.abs(m / 3 - n / 3);
        n %= 3;
        m %= 3;
        cost += Math.abs(n - m);
        return cost;
    }
}
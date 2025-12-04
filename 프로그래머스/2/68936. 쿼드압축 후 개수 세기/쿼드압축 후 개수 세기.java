class Point{
    int r;
    int c;
    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}
class Count{
    int one;
    int zero;
    public Count(int one, int zero){
        this.one = one;
        this.zero = zero;
    }
}
class Solution {
    int[][] arr;
    public int[] solution(int[][] arr) {
        this.arr = arr;
        int sr = 0;
        int sc = 0;
        int er = arr.length;
        int ec = arr[0].length;
        Count cnt = recursion(sr, er, sc, ec);
        return new int[] {cnt.zero, cnt.one};
    }
    
    Count recursion(int sr, int er, int sc, int ec){
        
        if(er - sr == 1 && ec - sc == 1) {
            Count cnt;
            if(arr[sr][sc] == 1){
                cnt = new Count(1,0);
            }
            else{
                cnt = new Count(0, 1);
            }
            return cnt;
        }
        
        int mr = (er + sr) / 2;
        int mc = (ec + sc) / 2;

        Count c1 = recursion(sr, mr, sc, mc);
        Count c2 = recursion(mr, er, sc, mc);
        Count c3 = recursion(sr, mr, mc, ec);
        Count c4 = recursion(mr, er, mc, ec);
        
        int o = c1.one + c2.one + c3.one + c4.one;
        int z = c1.zero + c2.zero + c3.zero + c4.zero;
        
        if(o == 0){
            return new Count(0, 1);
        }
        if(z == 0){
            return new Count(1, 0);
        }
        
        return new Count(o, z);
        
    }
    
}
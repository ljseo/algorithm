import java.util.*;

public class Main{
    
    static int[] arr;
    static int n,m;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            sb.append(isInclude(a) ? 1 : 0).append("\n");
        }
        System.out.println(sb);
	}
    public static boolean isInclude(int a){
        int start = 0;
        int end = arr.length;
        while(start < end){ // start == end 면 종료
            int mid = (start + end) / 2;
            
            if(arr[mid] == a) return true;
            
            else if(arr[mid] > a){
                end = mid;
            } 
            else {
                start = mid + 1;
            }   
        }
        return false;
    }

}
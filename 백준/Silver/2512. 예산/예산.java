
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class  Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int mn = 0;
        int mx = -1;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(mx < arr[i]) {
                mx = arr[i];
            }
        }
        int total = Integer.parseInt(br.readLine());
        while(mn <= mx){
            int temp = 0;
            int mid = (mn + mx)/2;
            for(int j = 0; j < N; j++){
                int now = arr[j];
                if(now <= mid){
                    temp += now;
                }
                else{
                    temp += mid;
                }
            }
            if(total >= temp){
                mn = mid + 1;
            }
            else{
                mx = mid - 1;
            }
        }
        System.out.println(mx);
    }
}

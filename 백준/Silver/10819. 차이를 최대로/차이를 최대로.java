
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] A;
    static int[] B;
    static boolean [] V;
    static int n;
    static int mx = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new int[n];
        B = new int[n];
        V = new boolean[n];

        String[] str = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(str[i]);
        }

        dfs(0);
        System.out.println(mx);

    }

    private static void dfs(int idx) {

        if(idx == n) {
            int sum = 0;
            for(int i = 0; i < n - 1; i++) {
                sum += Math.abs(B[i] - B[i+1]);
            }
            if(sum > mx) {
                mx = sum;
            }
        }
        else{
            for(int i = 0; i < n; i++) {
                if(!V[i]){
                    V[i] = true;
                    B[idx] = A[i];
                    dfs(idx+1);
                    V[i] = false;
                }
            }
        }

    }
}

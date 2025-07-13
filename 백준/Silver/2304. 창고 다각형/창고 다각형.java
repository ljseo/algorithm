
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int [] heights = new int[1001];

        int mxH = 0;
        int mxIndex = 0;

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            heights[L] = H;
            if(H > mxH){
                mxH = H;
                mxIndex = L;
            }
        }

        int answer = 0;
        int currentMx = 0;
        for(int i=1; i<=mxIndex; i++){
            if(heights[i] > currentMx){
                currentMx = heights[i];
            }
            answer += currentMx;
        }

        currentMx = 0;
        for(int i = 1000; i>mxIndex; i--){
            if(heights[i] > currentMx){
                currentMx = heights[i];
            }
            answer += currentMx;
        }
        System.out.println(answer);
    }
}

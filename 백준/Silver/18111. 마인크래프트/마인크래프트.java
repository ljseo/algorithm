
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int [][] map = new int[N][M];

        int mn = 257;
        int mx = -1;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                mn = Math.min(mn, map[i][j]);
                mx = Math.max(mx, map[i][j]);
            }
        }

        int result = Integer.MAX_VALUE;
        int resultH = -1;
        for(int h = mn; h <= mx; h++){
            int time = 0;
            int tempB = B;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    int now = map[i][j];
                    if(now > h) {
                        int diff = now - h;
                        time += diff * 2;
                        tempB += diff;
                    }
                    else if(now < h){
                        int diff = h - now;
                        time += diff;
                        tempB -= diff;
                    }
                }
            }
            if(time <= result && tempB > -1){
                result = time;
                resultH = h;
            }
        }
        System.out.println(result +" " + resultH);
    }
}

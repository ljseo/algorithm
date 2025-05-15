
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] winCnt = new int[2];
        int[] winTime = new int[2];
        int prevTime = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            String time = st.nextToken();
            int cTime = convert(time);

            if(winCnt[0] > winCnt[1]){
                winTime[0] += cTime - prevTime;
            }
            else if(winCnt[0] < winCnt[1]){
                winTime[1] += cTime - prevTime;
            }
            prevTime = cTime;
            winCnt[team-1]++;
        }
        if(winCnt[0] > winCnt[1]){
            winTime[0] += convert("48:00") - prevTime;
        }
        else if(winCnt[0] < winCnt[1]){
            winTime[1] += convert("48:00") - prevTime;
        }

//        System.out.println(winTime[0] /60 + ":" + winTime[0] % 60);
//        System.out.println(winTime[1] /60 + ":" + winTime[1] % 60);
        System.out.printf("%02d:%02d\n", winTime[0]/60, winTime[0]%60);
        System.out.printf("%02d:%02d", winTime[1]/60, winTime[1]%60);
    }

    private static int convert(String time) {
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
}

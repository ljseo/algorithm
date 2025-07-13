
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        int S[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            S[i] = A[i];
        }
        Arrays.sort(S);
        Map<Integer, Integer> map = new HashMap<>();

        int index = 0;
        for (int i = 0; i < N; i++) {
            int now = S[i];
            if(!map.containsKey(now)) {
                map.put(now, index++);
            }
        }
        for (int i = 0; i < N; i++) {
            int now = A[i];
            sb.append(map.get(now)).append(" ");
        }
        System.out.println(sb);
    }
}

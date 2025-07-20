import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{

    // 지름길 정보를 저장하기 위한 내부 클래스
    static class Shortcut {
        int start;
        int end;
        int length;

        public Shortcut(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 지름길의 개수, D: 고속도로의 길이
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        // 지름길 정보를 담을 리스트
        List<Shortcut> shortcutList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 유효하지 않은 지름길은 제외
            // 1. 지름길의 도착점이 고속도로 길이를 초과하는 경우
            // 2. 지름길의 길이가 일반 주행 거리보다 길거나 같은 경우
            if (e > D || (e - s) <= v) {
                continue;
            }
            shortcutList.add(new Shortcut(s, e, v));
        }

        // DP 배열 선언 (0부터 D까지의 거리를 저장)
        int[] dp = new int[D + 1];

        // DP 배열 초기화: 지름길이 없을 경우의 거리로 설정
        for (int i = 0; i <= D; i++) {
            dp[i] = i;
        }

        // 0부터 D까지 모든 위치를 순회하며 최소 거리 계산
        for (int i = 0; i <= D; i++) {
            // i가 0보다 클 때만, (i-1)에서 오는 경우를 고려
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }
            for (Shortcut sc : shortcutList) {
                if (sc.start == i) {
                    // 지름길의 도착점까지의 현재 최소 거리와
                    // (현재 위치까지의 최소거리 + 지름길 길이)를 비교하여 갱신
                    dp[sc.end] = Math.min(dp[sc.end], dp[i] + sc.length);
                }
            }
        }

        // 최종 목적지 D까지의 최소 거리를 출력
        System.out.println(dp[D]);
    }
}
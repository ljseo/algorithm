
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] ans = new int[N];  // 0..N-1

        for (int i = 0; i < N; i++) {
            int leftLarges = Integer.parseInt(input[i]);
            int cnt = 0;
            int idx = 0;

            // 빈 자리만 세면서, leftLarges만큼 건너뛸 때까지 이동
            while (true) {
                if (ans[idx] == 0) {      // 빈 자리면
                    if (cnt == leftLarges) {
                        break;           // 원하는 위치에 도달
                    }
                    cnt++;
                }
                idx++;
            }

            ans[idx] = i + 1;  // 사람 번호 배치
        }

// 최종 출력: ans[0]부터 ans[N-1]
        for (int i = 0; i < N; i++) {
            System.out.print(ans[i] + " ");
        }


    }
}

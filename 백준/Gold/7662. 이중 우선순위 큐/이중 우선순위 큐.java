import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();  // 값 → 개수

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if (cmd == 'I') {
                    // 삽입: 개수 증가
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if (!map.isEmpty()) {
                    // 삭제: 비어있지 않을 때만
                    int key;
                    if (num == 1) {
                        // 최댓값 삭제
                        key = map.lastKey();
                    } else {
                        // 최솟값 삭제
                        key = map.firstKey();
                    }
                    // 해당 key의 개수 감소 또는 제거
                    int cnt = map.get(key);
                    if (cnt == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, cnt - 1);
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey())
                  .append(" ")
                  .append(map.firstKey())
                  .append("\n");
            }
        }

        System.out.print(sb);
    }
}

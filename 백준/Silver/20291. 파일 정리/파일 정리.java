
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] split = str.split("\\.");
            map.put(split[1], map.getOrDefault(split[1],0) + 1);

        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort(String::compareTo);

        for(String s : list) {
            sb.append(s).append(" ").append(map.get(s)).append("\n");
        }
        System.out.println(sb);

    }
}

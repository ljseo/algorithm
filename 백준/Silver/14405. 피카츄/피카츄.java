
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String s = new BufferedReader(new InputStreamReader(System.in))
                .readLine();
        // (pi|ka|chu) 패턴이 1회 이상 반복되어야 전체가 매칭됨
        boolean valid = s.matches("(pi|ka|chu)+");
        System.out.println(valid ? "YES" : "NO");
    }

}

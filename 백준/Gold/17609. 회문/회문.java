
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            String str = br.readLine();
            System.out.println(check(str, 0, str.length() - 1, false));
        }
    }

    private static int check(String str, int left, int right, boolean removed) {

        while (left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                if(removed) return 2;
                if(check(str, left + 1, right, true) == 0 || check(str, left, right - 1, true) == 0) {
                    return 1;
                }
                return 2;
            }
            left++;
            right--;
        }
        return 0;
    }
}

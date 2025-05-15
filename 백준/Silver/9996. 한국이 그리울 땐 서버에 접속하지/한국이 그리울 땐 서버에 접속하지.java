
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String prefix;
    private static String suffix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [] pattern = br.readLine().split("\\*");

        prefix = pattern[0];
        suffix = pattern[1];

        for (int i = 0; i < n; i++) {
            if(isMatch(br.readLine())){
                System.out.println("DA");
            }
            else{
                System.out.println("NE");
            }
        }

    }
    private static boolean isMatch(String s){

        if(s.length() < prefix.length() + suffix.length()){
            return false;
        }

        for(int i = 0; i < prefix.length(); i++){
            if(s.charAt(i) != prefix.charAt(i)){
                return false;
            }
        }

        int sLen = s.length() - 1;
        int suffixLen = suffix.length() - 1;
        for(int i = 0; i <= suffixLen; i++){
            if(s.charAt(sLen - i) != suffix.charAt(suffixLen - i)){
                return false;
            }
        }
        return true;
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i = 0; i< n; i++){
            if(isGroup(br.readLine())){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    private static boolean isGroup(String str){

        boolean [] flag = new boolean[26];
        char[] chars  = str.toCharArray();
        char prevChar = '-';
        for(int i = 0; i < chars.length; i++){
            char current = chars[i];
            if(prevChar != current){
                if(flag[current-'a']) return false;
                flag[current-'a'] = true;
                prevChar = current;
            }
        }
        return true;
    }
}

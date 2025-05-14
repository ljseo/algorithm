
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        String[] s = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for(String str : s){
            int idx = sb.indexOf(str);

            while(idx != -1){
                sb.replace(idx, idx + str.length(), "1");
                idx = sb.indexOf(str);
            }
        }
        System.out.println(sb.length());
    }
}
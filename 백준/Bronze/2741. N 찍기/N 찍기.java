
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}

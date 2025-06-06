
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer(new Scanner(System.in).nextLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(a > b) System.out.println(">");
        else if(a < b) System.out.println("<");
        else System.out.println("==");
    }
}

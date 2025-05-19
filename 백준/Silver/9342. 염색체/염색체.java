
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String pattern = "^[A-F]A*F+C+[A-F]*$";

        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            if (line.matches(pattern)) {
                System.out.println("Infected!");
            } else {
                System.out.println("Good");
            }
        }
    }
}

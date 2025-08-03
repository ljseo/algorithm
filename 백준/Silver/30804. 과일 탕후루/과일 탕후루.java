
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] fruits = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int maxLength = 0;
        int[] fruitCount = new int[10];
        int distinctFruits = 0;

        for (int end = 0; end < N; end++) {
            int currentFruit = fruits[end];
            if (fruitCount[currentFruit] == 0) {
                distinctFruits++;
            }
            fruitCount[currentFruit]++;

            while (distinctFruits > 2) {
                int startFruit = fruits[start];
                fruitCount[startFruit]--;
                if (fruitCount[startFruit] == 0) {
                    distinctFruits--;
                }
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        System.out.println(maxLength);
    }
}
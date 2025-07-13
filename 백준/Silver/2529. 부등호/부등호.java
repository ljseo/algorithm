
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int k;
    private static char[] sign;
    private static boolean[] used;
    private static List<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        k = Integer.parseInt(br.readLine());
        sign = new char[k];
        used = new boolean[10];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            sign[i] = st.nextToken().charAt(0);
        }
        result = new ArrayList<>();

        backtracking(0, "");
        result.sort(((o1, o2) -> o1.compareTo(o2)));
        System.out.println(result.get(result.size()-1));
        System.out.println(result.get(0));



    }

    private static void backtracking(int index, String num) {
        if(num.length() == k+1){
            result.add(num);
            return;
        }
        for(int i = 0; i < 10; i++){
            if(used[i])continue;
            if(num.isEmpty() || check(num.charAt(index-1) - '0',i ,sign[index-1])){
                used[i] = true;
                backtracking(index+1, num + i);
                used[i] = false;
            }
        }

    }

    private static boolean check(int a, int b, char op) {
        if(op == '>') return a>b;
        else return a<b;
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            char [] chars = br.readLine().toCharArray();
            Stack<Character> left = new Stack<Character>();
            Stack<Character> right = new Stack<Character>();

            for(char ch : chars) {
                if(ch == '<') {
                    if(!left.empty()) {
                        right.push(left.pop());
                    }
                }
                else if(ch == '>') {
                    if(!right.empty()) {
                        left.push(right.pop());
                    }
                }
                else if(ch == '-'){
                    if(!left.empty()) {
                        left.pop();
                    }
                }
                else{
                    left.push(ch);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(Character ch : left) {
                sb.append(ch);
            }
            while(!right.empty()) {
                sb.append(right.pop());
            }
            System.out.println(sb);
        }
    }
}

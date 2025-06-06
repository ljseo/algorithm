
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < T; t++) {
            String orders = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String array = br.readLine();
            String substring = array.substring(1, array.length() - 1);
            StringTokenizer st = new StringTokenizer(substring, ",");
            String[] arr = new String[st.countTokens()];
            int idx = 0;
            while(st.hasMoreTokens()) {
                String s = st.nextToken();
                arr[idx++] = s;
            }

            int rCnt = 0;
            int left = 0;
            int right =  arr.length - 1 ;
            boolean flag = true;
            for(char order : orders.toCharArray()) {
                if(order == 'R'){
                    rCnt++;
                }else{
                    if(left > right) {
                        flag = false;
                        break;
                    }
                    if(rCnt % 2 == 0){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
            if(!flag){
                sb.append("error").append("\n");
                continue;
            }

            if (left > right) {
                // 전부 삭제되었거나 애초에 비어 있었던 경우
                sb.append("[]\n");
            }
            else {
                sb.append("[");
                if(left == right) sb.append(arr[left]);
                else if (rCnt % 2 == 0) {
                    for (int i = left; i < right; i++) {
                        sb.append(arr[i]).append(",");
                    }
                    sb.append(arr[right]);
                } else {
                    for (int i = right; i > left; i--) {
                        sb.append(arr[i]).append(",");
                    }
                    sb.append(arr[left]);
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb);
    }
}

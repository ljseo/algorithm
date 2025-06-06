
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//
//public class 단어정렬 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        Map <String, Boolean> map = new HashMap <> ();
//        List<String> words = new ArrayList <> ();
//
//        for (int i = 0; i < n; i++) {
//            String word = br.readLine();
//            if(!map.containsKey(word)) {
//                words.add(word);
//                map.put(word, true);
//            }
//        }
//
//        words.sort(new Comparator<>() {
//            @Override
//            public int compare (String o1, String o2){
//                if(o1.length() == o2.length()) {
//                    return o1.compareTo(o2);
//                }
//                return o1.length() - o2.length();
//            }
//        });
//
//        for(String word : words) {
//            System.out.println(word);
//        }
//
//    }
//}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String [] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare (String o1, String o2){
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });
        System.out.println(words[0]);
        for(int i = 1; i < n; i++){
            if(!words[i].equals(words[i-1])) {
                System.out.println(words[i]);
            }
        }

    }
}

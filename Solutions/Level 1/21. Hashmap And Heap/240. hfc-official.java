import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        HashMap<Character, Integer> fmap = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            Character ch = str.charAt(i);
            if(fmap.containsKey(ch) == true){
                int of = fmap.get(ch);
                int nf = of + 1;
                fmap.put(ch, nf);
            } else {
                fmap.put(ch, 1);
            }
        }

        Set<Character> keys = fmap.keySet();
        Character ch = str.charAt(0);
        for(Character key : keys){
            if(fmap.get(key) > fmap.get(ch)){
                ch = key;
            }
        }

        System.out.println(ch);
    }
}
import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n1 = Integer.parseInt(br.readLine());
    int[] a1 = new int[n1];
    for(int i = 0; i < n1; i++){
       a1[i] = Integer.parseInt(br.readLine());
    }

    int n2 = Integer.parseInt(br.readLine());
    int[] a2 = new int[n2];
    for(int i = 0; i < n2; i++){
       a2[i] = Integer.parseInt(br.readLine());
    }

    HashMap<Integer, Integer> fmap = new HashMap<>();
    for(int val: a1){
       if(fmap.containsKey(val)){
         int of = fmap.get(val);
         int nf = of + 1;
         fmap.put(val, nf);
       } else {
          fmap.put(val, 1);
       }
    }

    for(int val: a2){
       if(fmap.containsKey(val)){
          System.out.println(val);
          fmap.remove(val);
       }
    }
 }

}
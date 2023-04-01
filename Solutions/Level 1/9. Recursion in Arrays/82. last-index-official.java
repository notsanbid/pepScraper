import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }
      int x = Integer.parseInt(br.readLine());
      int fi = lastIndex(arr, 0, x);
      System.out.println(fi);
   }

   public static int lastIndex(int[] arr, int idx, int x) {
      if(idx == arr.length){
         return -1;
      }

      int liisa = lastIndex(arr, idx + 1, x);
      if(liisa != -1){
         return liisa;
      } else if(arr[idx] == x){
         return idx;
      } else {
         return -1;
      }
   }

}
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

      int max = maxOfArray(arr, 0);
      System.out.println(max);
   }

   public static int maxOfArray(int[] arr, int idx) {
      if(idx == arr.length - 1){
         return arr[idx];
      }
      
      int misa = maxOfArray(arr, idx + 1);
      if(misa > arr[idx]){
         return misa;
      } else {
         return arr[idx];
      }
   }

}
import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      long[] arr = new long[n + 1];
      arr[0] = 1;

      for (int i = 1; i <= n; i++) {
         if(i >= 1){
            arr[i] += arr[i - 1];
         }

         if(i >= 2){
            arr[i] += arr[i - 2];
         }

         if(i >= 3){
            arr[i] += arr[i - 3];
         }
      }

      System.out.println(arr[n]);
   }

}
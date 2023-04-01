import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      for (int i = 0; i < arr.length; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int omax = 0;
      int[] dp = new int[arr.length];
      for(int i = 0; i < arr.length; i++){
         Integer max = null;

         for(int j = 0; j < i; j++){
            if(arr[j] <= arr[i]){
               if(max == null || dp[j] > max){
                  max = dp[j];
               }
            }
         }

         if(max != null){
            dp[i] = max + 1;
         } else {
            dp[i] = 1;
         }
         
         if(dp[i] > omax){
            omax = dp[i];
         }
      }

      System.out.println(omax);
   }

}
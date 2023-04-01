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

      int[] dp = new int[n + 1];
      dp[n] = 1;

      for (int i = n - 1; i >= 0; i--) {
         if (arr[i] > 0) {
            for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
               dp[i] += dp[i + j];
            }
         }
      }

      System.out.println(dp[0]);
   }

}
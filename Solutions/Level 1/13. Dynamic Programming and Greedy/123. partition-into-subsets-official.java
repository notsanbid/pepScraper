import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());

      if (n == 0 || k == 0 || n < k) {
         System.out.println(0);
         return;
      }

      long[][] dp = new long[k + 1][n + 1];
      for (int i = 1; i <= k; i++) {
         for (int j = i; j <= n; j++) {
            if (i == 1 || j == 1 || i == j) {
               dp[i][j] = 1;
            } else {
               dp[i][j] = dp[i - 1][j - 1] + i * dp[i][j - 1];
            }
         }
      }

      System.out.println(dp[k][n]);
   }

}
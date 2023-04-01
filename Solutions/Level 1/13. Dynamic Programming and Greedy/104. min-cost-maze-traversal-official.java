import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         String str = br.readLine();
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(str.split(" ")[j]);
         }
      }

      int[][] dp = new int[arr.length][arr[0].length];
      for(int i = arr.length - 1; i >= 0; i--){
         for(int j = arr[0].length - 1; j >= 0; j--){
            if(i == arr.length - 1 && j == arr[0].length - 1){
               dp[i][j] = arr[i][j];
            } else if(i == arr.length - 1){
               dp[i][j] = arr[i][j] + dp[i][j + 1];
            } else if(j == arr[0].length - 1){
               dp[i][j] = arr[i][j] + dp[i + 1][j];
            } else {
               dp[i][j] = arr[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
            }
         }
      }

      System.out.println(dp[0][0]);
   }

}
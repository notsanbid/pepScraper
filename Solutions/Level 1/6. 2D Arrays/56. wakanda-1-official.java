import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(br.readLine());
         }
      }

      for (int j = 0; j < m; j++) {
         if (j % 2 == 0) {
            for (int i = 0; i < n; i++) {
               System.out.println(arr[i][j]);
            }
         } else {
            for (int i = n - 1; i >= 0; i--) {
               System.out.println(arr[i][j]);
            }
         }
      }
   }

}
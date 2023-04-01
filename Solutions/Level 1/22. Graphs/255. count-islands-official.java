import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      boolean[][] visited = new boolean[m][n];
      int count = 0;
      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr[0].length; j++) {
            if (arr[i][j] == 0 && visited[i][j] == false) {
               gcc(arr, i, j, visited);
               count++;
            }
         }
      }

      System.out.println(count);
   }

   public static void gcc(int[][] arr, int i, int j, boolean[][] visited) {
      if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || 
          arr[i][j] == 1 || visited[i][j] == true) {
            return;
      }

      visited[i][j] = true;
      gcc(arr, i + 1, j, visited);
      gcc(arr, i, j + 1, visited);
      gcc(arr, i - 1, j, visited);
      gcc(arr, i, j - 1, visited);
   }

}
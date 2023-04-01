import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][n];

      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            arr[i][j] = Integer.parseInt(br.readLine());
         }
      }

      int x = Integer.parseInt(br.readLine());

      // search
      int i = 0;
      int j = arr[0].length - 1;
      while(i < arr.length && j >= 0){
         if(x == arr[i][j]){
            System.out.println(i);
            System.out.println(j);
            return;
         } else if(x > arr[i][j]){
            i++;
         } else {
            j--;
         }
      }

      System.out.println("Not Found");
   }


}
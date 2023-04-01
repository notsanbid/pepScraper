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

      // diagonal traversal
      for(int i = 0; i < arr.length; i++){
         // find min of the row
         int min = arr[i][0];
         int minc = 0;
         for(int j = 1; j < arr[0].length; j++){
            if(arr[i][j] < min){
               min = arr[i][j];
               minc = j;
            }
         }

         // check if no value is higher than this value in it's column
         boolean flag = true;
         for(int k = 0; k < arr.length; k++){
            if(arr[k][minc] > arr[i][minc]){
               flag = false;
               break;
            }
         }

         if(flag == true){
            System.out.println(arr[i][minc]);
            return;
         }
      }

      System.out.println("Invalid input");
   }


}
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

      int[] lis = new int[arr.length];
      for(int i = 0; i < arr.length; i++){
         Integer max = null;

         for(int j = 0; j < i; j++){
            if(arr[j] <= arr[i]){
               if(max == null || lis[j] > max){
                  max = lis[j];
               }
            }
         }

         if(max != null){
            lis[i] = max + 1;
         } else {
            lis[i] = 1;
         }
      }

      int[] lds = new int[arr.length];
      for(int i = arr.length - 1; i >= 0; i--){
         Integer max = null;

         for(int j = arr.length - 1; j > i; j--){
            if(arr[j] <= arr[i]){
               if(max == null || lds[j] > max){
                  max = lds[j];
               }
            }
         }

         if(max != null){
            lds[i] = max + 1;
         } else {
            lds[i] = 1;
         }
      }

      int omax = 0;
      for(int i = 0; i < arr.length; i++){
         if(lis[i] + lds[i] - 1> omax){
            omax = lis[i] + lds[i] - 1;
         }
      }
      System.out.println(omax);
   }

}
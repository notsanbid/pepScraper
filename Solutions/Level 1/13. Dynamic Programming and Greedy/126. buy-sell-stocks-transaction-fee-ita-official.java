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
      int fee = Integer.parseInt(br.readLine());

      int bstp = -arr[0];
      int sstp = 0;
      for(int i = 1; i < arr.length; i++){
         int nsstp = 0;
         int nbstp = 0;

         if(sstp - arr[i] > bstp){
            nbstp = sstp - arr[i];
         } else {
            nbstp = bstp;
         }

         if(bstp + arr[i] - fee > sstp){
            nsstp = bstp + arr[i] - fee;
         } else {
            nsstp = sstp;
         }

         bstp = nbstp;
         sstp = nsstp;
      }

      System.out.println(sstp);
   }

}
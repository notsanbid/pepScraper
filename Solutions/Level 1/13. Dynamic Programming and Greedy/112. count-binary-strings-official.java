import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      int zeroes = 1;
      int ones = 1;
      for(int i = 2; i <= n; i++){
         int nzeroes = ones;
         int nones = ones + zeroes;

         zeroes = nzeroes;
         ones = nones;
      }

      System.out.println(zeroes + ones);
   }

}
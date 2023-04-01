import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());

      long zeroes = 1;
      long ones = 1;
      for (int i = 2; i <= n; i++) {
         long nzeroes = ones;
         long nones = ones + zeroes;

         zeroes = nzeroes;
         ones = nones;
      }

      long oneside = zeroes + ones;
      System.out.println(oneside * oneside);
   }

}
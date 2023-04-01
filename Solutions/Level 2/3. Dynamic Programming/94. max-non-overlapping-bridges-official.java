import java.io.*;
import java.util.*;

public class Main {
   public static class Bridge implements Comparable<Bridge> {
      int n;
      int s;

      public int compareTo(Bridge o){
         if(this.n != o.n){
            return this.n - o.n;
         } else {
            return this.s - o.s;
         }
      }
   }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      Bridge[] brdgs = new Bridge[n];
      for (int i = 0; i < brdgs.length; i++) {
         String str = br.readLine();
         brdgs[i] = new Bridge();
         brdgs[i].n = Integer.parseInt(str.split(" ")[0]);
         brdgs[i].s = Integer.parseInt(str.split(" ")[1]);
      }

      Arrays.sort(brdgs);
      int[] lis = new int[brdgs.length];
      for(int i = 0; i < brdgs.length; i++){
         Integer max = null;

         for(int j = 0; j < i; j++){
            if(brdgs[j].s <= brdgs[i].s){
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

      int omax = 0;
      for(int i = 0; i < brdgs.length; i++){
         if(lis[i] > omax){
            omax = lis[i];
         }
      }
      System.out.println(omax);
   }

}
import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    int max = Integer.MIN_VALUE;
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
       max = Math.max(max, arr[i]);
    }

    for(int i = 0; i < max; i++){
       for(int val: arr){
         if(val >= max - i){
            System.out.print("*\t");
         } else {
            System.out.print("\t");
         }
       }

       System.out.println();
    }
 }

}
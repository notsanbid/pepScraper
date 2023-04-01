import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n1 = Integer.parseInt(br.readLine());
    int[] a1 = new int[n1];
    for(int i = 0; i < n1; i++){
       a1[i] = Integer.parseInt(br.readLine());
    }

    int n2 = Integer.parseInt(br.readLine());
    int[] a2 = new int[n2];
    for(int i = 0; i < n2; i++){
       a2[i] = Integer.parseInt(br.readLine());
    }

    int[] diff = new int[n2];
    int i = n1 - 1;
    int j = n2 - 1;
    int k = diff.length - 1;
    int c = 0;
    while(k >= 0){
       int v;

       if(i >= 0){
         v = a1[i];
       } else {
         v = 0;
       }

       if(a2[j] + c >= v){
         diff[k] = a2[j] + c - v;
         c = 0;
      } else {
        diff[k] = a2[j] + c + 10 - v;
        c = -1;
      }

       i--;
       j--;
       k--;
    }

    int idx = 0;
    while(idx < diff.length){
      if(diff[idx] != 0){
        break;
      } else {
        idx++;
      }
    }

    while(idx < diff.length){
      System.out.println(diff[idx]);
      idx++;
    }
 }

}
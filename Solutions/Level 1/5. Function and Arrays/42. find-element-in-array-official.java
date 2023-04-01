import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }

    int d = Integer.parseInt(br.readLine());

    for(int i = 0; i < arr.length; i++){
       if(d == arr[i]){
         System.out.println(i);
         return;
       }
    }

    System.out.println(-1);
 }

}
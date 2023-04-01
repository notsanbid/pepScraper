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

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < arr.length; i++){
       for(int j = i; j < arr.length; j++){
          for(int k = i; k <= j; k++){
            sb.append(arr[k] + "\t");
          }
          sb.append("\n");
       }
    }

    System.out.println(sb);
 }

}
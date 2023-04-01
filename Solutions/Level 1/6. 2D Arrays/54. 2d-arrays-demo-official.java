import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][m];

    for(int i = 0; i < n; i++){
       for(int j = 0; j < m; j++){
         arr[i][j] = Integer.parseInt(br.readLine());
       }
    }

    for(int i = 0; i < arr.length; i++){
       for(int j = 0; j < arr[0].length; j++){
          System.out.print(arr[i][j] + " ");
       }
       System.out.println();
    }
 }

}
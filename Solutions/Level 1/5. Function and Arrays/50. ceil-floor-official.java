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
    int data = Integer.parseInt(br.readLine());

    int left = 0;
    int right = arr.length - 1;
    int ceil = 0;
    int floor =  0;
    while(left <= right){
       int mid = (left + right) / 2;
       if(data > arr[mid]){
         left = mid + 1;
         floor = arr[mid];
       } else if(data < arr[mid]){
         right = mid - 1;
         ceil = arr[mid];
       } else  {
         floor = arr[mid];
         ceil = arr[mid];
         break;
       }
    }

    System.out.println(ceil); 
    System.out.println(floor);
 }

}
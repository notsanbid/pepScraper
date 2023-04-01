import java.util.*;

public class Main {

    public static int findMinimum(int[]arr) {
        //write your code here
        int lo = 0;
        int hi = arr.length-1;
        
        if(arr[lo] <= arr[hi]) {
            //array is not rotated at all
            return arr[lo];
        }
        
        while(lo <= hi) {
           int mid = (lo + hi)/2;
           
           if(arr[mid] > arr[mid+1]) {
               return arr[mid+1];
           }
           else if(arr[mid] < arr[mid-1]) {
               return arr[mid];
           }
           else if(arr[lo] <= arr[mid]) {
               lo = mid+1;
           }
           else if(arr[mid] <= arr[hi]) {
               hi = mid-1;
           }
        }
        
        return -1;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findMinimum(arr);
        System.out.println(ans);
    }
}
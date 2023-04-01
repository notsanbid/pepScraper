import java.util.*;
import java.io.*;

public class Main {

    /*find 'k' closest element to 'x' and return answer list*/
    /*elements in answer list should be in ascending order*/
    public static ArrayList<Integer> findClosest(int[]arr,int k,int x) {

        //write your code here
         ArrayList<Integer>list = new ArrayList<>();
        
        //first find closest element
        int lo = 0;
        int hi = arr.length-1;
        int mid = 0;
        
        while(lo <= hi) {
            mid = (lo + hi)/2;
            
            if(arr[mid] == x) {
                break;
            }
            else if(arr[mid] < x) {
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
        }
    
        
        lo = mid-1;
        hi = mid;
        
        while(lo >= 0 && hi < arr.length && k-- > 0) {
            if(Math.abs(arr[lo]-x) < Math.abs(arr[hi]-x)) {
                list.add(arr[lo]);
                lo--;
            }
            else if(Math.abs(arr[lo]-x) > Math.abs(arr[hi]-x)) {
                list.add(arr[hi]);
                hi++;
            }
            else {
                list.add(arr[lo]);
                lo--;
            }
        }
        
        while(lo >= 0 && k-- > 0) {
            list.add(arr[lo]);
            lo--;
        }
        
        while(hi < arr.length && k-- > 0) {
            list.add(arr[hi]);
            hi++;
        }
        
        
        Collections.sort(list);
        return list;
    }

    public static void main(String[]args) {

        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();
        int x = scn.nextInt();

        ArrayList<Integer>ans = findClosest(arr,k,x);

        for(int val : ans) {
            System.out.print(val + " ");
        }

    }
}
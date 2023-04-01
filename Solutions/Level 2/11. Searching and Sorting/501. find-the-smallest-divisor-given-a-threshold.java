import java.util.*;
import java.io.*;

public class Main {
    public static int findSmallestDivisor(int[]nums,int th) {
        //write your code here
         int max = 0;
        
        for(int val : nums) {
            max = Math.max(val,max);
        }
        
        if(th == nums.length) {
            return max;
        }
        
        int lo = 1;
        int hi = max;
        int divisor = 0;
        
        while(lo <= hi) {
            int div = lo + (hi-lo)/2;
            
            boolean temp = isPossible(nums,div,th);
            
            if(temp == true) {
                divisor = div;
                hi = div-1;
            }
            else {
                lo = div+1;
            }
        }
        
        return divisor;
    }

     public static boolean isPossible(int[]nums,int div,int th) {
        int ans = 0;
        
        for(int i=0; i < nums.length ; i++) {
            ans = ans + (int)Math.ceil(nums[i]*1.0/div);
        }
        
        return ans <= th;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]nums = new int[n];

        for(int i=0 ; i < n ; i++) {
            nums[i] = scn.nextInt();
        }

        int th = scn.nextInt();

        int speed = findSmallestDivisor(nums,th);
        System.out.println(speed);
    }
}
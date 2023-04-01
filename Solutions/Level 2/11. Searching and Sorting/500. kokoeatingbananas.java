import java.util.*;
import java.io.*;

public class Main {
    public static int minEatingSpeed(int[]piles,int h) {
        //write your code here
        int max = 0;
        
        for(int val : piles) {
            max = Math.max(max,val);
        }
        
        if(h == piles.length) {
            return max;
        }
        
        int lo = 0;
        int hi = max;
        int speed = 0;
        
        while(lo <= hi) {
            int sp = lo + (hi-lo)/2; 
            boolean temp = isPossible(piles,sp,h);
            
            if(temp == true) {
                speed = sp;
                hi = sp - 1;
            }
            else {
                lo = sp + 1;
            }
        }
        
        return speed;
    }

    public static boolean isPossible(int[]piles,int sp,int h) {
        
        int ans = 0;
        for(int i=0; i < piles.length;i++) {
            ans = ans + (int)Math.ceil(piles[i]*1.0/sp);
        }
        
        if(ans <= h) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]piles = new int[n];

        for(int i=0 ; i < n ; i++) {
            piles[i] = scn.nextInt();
        }

        int h = scn.nextInt();

        int speed = minEatingSpeed(piles,h);
        System.out.println(speed);
    }
}
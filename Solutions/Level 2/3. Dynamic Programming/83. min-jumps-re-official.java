import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    public static class Pair{
        int idx;
        String asf;
        int jmps;
        Pair(int idx,String asf,int jmps){
            this.idx = idx;
            this.asf = asf;
            this.jmps = jmps;
        }
    }
    
    public static void minJumpRE(int []arr,int []dp){
        
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0 , ""+ 0 , dp[0]));

        while(queue.size() > 0){
            Pair tmp = queue.remove();

            if(tmp.jmps == 0){
                System.out.println(tmp.asf+" .");
                continue;
            }
    
            for(int step = 1 ; step <= arr[tmp.idx] ; step++){
                if(tmp.idx+step < arr.length && tmp.jmps-1 == dp[tmp.idx+step]){
                    queue.add(new Pair(tmp.idx+step, tmp.asf +" -> " + (tmp.idx+step), tmp.jmps-1));
                }
            }
        }
    }
    public static int[] minJumps(int []arr){
        int dp[] = new int[arr.length];

        // dp[arr.length-1] = ;

        for(int idx = arr.length-2 ; idx >=0 ; idx--){
            int steps = arr[idx];
        
            int min = Integer.MAX_VALUE;
            if(steps > 0){
                for(int i = 1 ; i <= steps ;i++){
                    if(idx + i < arr.length)
                        min = Math.min(min,dp[idx+i]);
                }
            }
            dp[idx] = min == Integer.MAX_VALUE ? min : min+1;
            // System.out.print(dp[idx]+" ");
        }
        return dp;
        
    }

    public static void Solution(int arr[]){
        int dp[] = minJumps(arr);
        System.out.println(dp[0]);
        minJumpRE(arr, dp);
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        scn.close();
    }
}
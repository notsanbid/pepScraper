import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
        int m = scn.nextInt();
        int k = scn.nextInt();
        // System.out.println(solution(arr, m , k));
        System.out.println(maxSumTab(arr,m,k));
	}

	public static int solution(int[] arr, int m, int k){
        int n = arr.length;
        int[] prefixSum = new int[n];
        for(int i = 0 ; i < k; i++){
            prefixSum[0] += arr[i];
        }
        for(int i = 1; i <= n - k; i++){
            prefixSum[i] = prefixSum[i - 1] + arr[i + k - 1] - arr[i - 1];
        }
        return maxSum(prefixSum, arr, m, k, 0);
    }

    public static int maxSum(int[] prefixSum, int[] arr, int m , int k, int vidx){
        if(m == 0){
            return 0;
        }
        if(vidx >= arr.length){
            return 0;
        }
        //include-exclude call
        int include = prefixSum[vidx] + maxSum(prefixSum, arr, m - 1, k, vidx + k);
        int exclude = 0 + maxSum(prefixSum, arr, m, k, vidx + 1);
        return Math.max(include, exclude);
    }

    public static int maxSumTab(int[] arr, int m, int k){
        int[] ssum = new int[arr.length];
        for(int i = arr.length - 1; i >= arr.length - k; i--){
            ssum[arr.length - 1] += arr[i];
        }
        for(int i = arr.length - 2; i >= k - 1; i--){
            ssum[i] = ssum[i + 1] + arr[i - k + 1] - arr[i + 1];
        }

        int[][] dp = new int[arr.length + 1][m + 1];
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                dp[i][j] = Math.max(dp[i - 1][j],i - k >= 0 ? dp[i - k][j - 1] + ssum[i - 1] : 0);
            }
        }
        
        return dp[dp.length - 1][dp[0].length - 1];
    }

}
import java.io.*;
import java.util.*;

public class Main {

	public static int mcm(int[] arr){
		int n = arr.length;
		int[][] dp  =new int[n][n];
		for(int gap = 2; gap < n; gap++){
			int si = 0, ei = gap;
			while(ei < n){
				dp[si][ei] = Integer.MAX_VALUE;
				for(int i = si + 1; i < ei; i++){
					dp[si][ei] = Math.min(dp[si][ei], dp[si][i] + dp[i][ei] + (arr[si] * arr[i] * arr[ei]));
				}
				si++;
				ei++;
			}
		}
		return dp[0][n - 1];
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(mcm(arr));
	}

	
}
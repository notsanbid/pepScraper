import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0 ; j < n; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		int ans = Math.max(0,Solution(0, 0, 0, arr, new int[n][n][n]));
		System.out.println(ans);
	}

	public static int Solution(int r1, int c1, int r2, int[][] arr, int[][][] dp) {
		int c2 = r1 + c1 - r2;
		// negative base case
		if (r1 >= arr.length || c1 >= arr.length || r2 >= arr.length || c2 >= arr.length)
			return 0;

		if(arr[r1][c1] == -1 || arr[r2][c2] == -1) {
			return Integer.MIN_VALUE;
		}
		//using dp
		if (dp[r1][c1][r2] != 0)
			return dp[r1][c1][r2];

		// if person 1 reached the bottom right
		if (r1 == arr.length - 1 && c1 == arr.length - 1)
			return arr[r1][c1];

		// if person 2 reached the bottom right
		if (r2 == arr.length - 1 && c2 == arr.length - 1)
			return arr[r2][c2];

		int cherries = 0;

		if (r1 == r2 && c1 == c2)
			cherries = arr[r1][c1];
		else
			cherries = arr[r1][c1] + arr[r2][c2];

		int f1 = Solution(r1 + 1, c1, r2 + 1, arr, dp);
		int f2 = Solution(r1, c1 + 1, r2, arr, dp);
		int f3 = Solution(r1 + 1, c1, r2, arr, dp);
		int f4 = Solution(r1, c1 + 1, r2 + 1, arr, dp);

		cherries += Math.max(Math.max(f1, f2), Math.max(f3, f4));
		dp[r1][c1][r2] = cherries;
		return cherries;
	}

}
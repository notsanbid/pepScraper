import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = scn.nextInt();
		}
		optimalStrategy(a);
	}

	public static void optimalStrategy(int[] arr) {
		int[][] dp = new int[arr.length][arr.length];
		for (int gap = 0; gap < arr.length; gap++) {
			int i = 0, j = gap;
			while (j < arr.length) {
				int x = ((i + 2) <= j) ? dp[i + 2][j] : 0;
				int y = ((i + 1) <= (j - 1)) ? dp[i + 1][j - 1] : 0;
				int z = (i <= (j - 2)) ? dp[i][j - 2] : 0;
				dp[i][j] = Math.max(arr[i] + Math.min(x, y), arr[j] + Math.min(y, z));
				i++;
				j++;
			}
		}
		System.out.println(dp[0][dp[0].length - 1]);
	}

}
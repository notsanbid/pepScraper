import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] keys = new int[n];
		for (int i = 0; i < n; i++) {
			keys[i] = scn.nextInt();
		}
		int[] frequency = new int[n];
		for (int i = 0; i < n; i++) {
			frequency[i] = scn.nextInt();
		}

		optimalbst(keys, frequency, n);
	}

	private static void optimalbst(int[] keys, int[] frequency, int n) {
		// make prefix sum of frequencies
		int[] fsum = new int[n];
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				fsum[i] = frequency[i];
			} else {
				fsum[i] = frequency[i] + fsum[i - 1];
			}
		}

		int[][] cost = new int[n][n];
		for (int gap = 0; gap < n; gap++) {
			int si = 0;
			int ei = gap;
			while (ei < n) {
				if (gap == 0) {
					// diagonal
					cost[si][ei] = frequency[si];
				} else if (gap == 1) {
					int sum = fsum[ei];
					if (si - 1 >= 0) {
						sum -= fsum[si - 1];
					}
					cost[si][ei] = Math.min(cost[si][ei - 1], cost[si + 1][ei]) + sum;
				} else {
					cost[si][ei] = Integer.MAX_VALUE;
					int sum = fsum[ei];
					if (si - 1 >= 0) {
						sum -= fsum[si - 1];
					}
					for (int i = si; i < ei - 1; i++) {
						cost[si][ei] = Math.min(cost[si][i] + cost[i + 2][ei] + sum, cost[si][ei]);
					}
					cost[si][ei] = Math.min(Math.min(cost[si][ei - 1], cost[si + 1][ei]) + sum, cost[si][ei]);
				}
				si++;
				ei++;
			}
		}
		System.out.println(cost[0][n - 1]);
	}
}
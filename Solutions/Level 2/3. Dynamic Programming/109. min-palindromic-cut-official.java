import java.io.*;
import java.util.*;

public class Main {

	public static int minPalindromicCut(String s) {
		int n = s.length();
		boolean[][] dp = new boolean[s.length()][s.length()];
		for (int gap = 0; gap < s.length(); gap++) {
			int si = 0, ei = gap;
			while (ei < s.length()) {
				if (gap == 0) {
					dp[si][ei] = true;
				} else if (gap == 1) {
					dp[si][ei] = s.charAt(si) == s.charAt(ei);
				} else {
					if (s.charAt(si) == s.charAt(ei)) {
						dp[si][ei] = dp[si + 1][ei - 1];
					} else {
						dp[si][ei] = false;
					}
				}
				si++;
				ei++;
			}
		}

		int[] cuts = new int[n];
		for (int i = 0; i < n; i++) {
			if (dp[0][i] == true) {
				cuts[i] = 0;
			} else {
				cuts[i] = Integer.MAX_VALUE;
				for (int j = 0; j < i; j++) {
					if(dp[j + 1][i] == true && 1 + cuts[j] < cuts[i]){
						cuts[i] = 1 + cuts[j];
					}
				}
			}
		}
		return cuts[n - 1];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(minPalindromicCut(str));
	}
}
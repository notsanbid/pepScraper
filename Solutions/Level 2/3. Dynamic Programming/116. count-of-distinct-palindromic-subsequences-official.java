import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

	public static int solution(String str) {
		int n = str.length();
		int[] low = new int[n];
		int[] high = new int[n];
		HashMap<Character, Integer> map = new HashMap<>();
		high[0] = -1;
		map.put(str.charAt(0), -1);
		for (int i = 1; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (map.containsKey(ch)) {
				high[i] = map.get(ch);
				map.put(ch, i);
			} else {
				high[i] = -1;
				map.put(ch, i);
			}
		}
		map.clear();
		map.put(str.charAt(n - 1), n);
		low[n - 1] = n;
		for (int i = n - 2; i >= 0; i--) {
			char ch = str.charAt(i);
			if (map.containsKey(ch)) {
				low[i] = map.get(ch);
				map.put(ch, i);
			} else {
				low[i] = n;
				map.put(ch, i);
			}
		}
		int[][] dp = new int[n][n];
		char[] arr = str.toCharArray();
		for (int gap = 0; gap < n; gap++) {
			int si = 0;
			int ei = gap;
			while (ei < n) {
				if (gap == 0) {
					dp[si][ei] = 1;
				} else if (arr[si] != arr[ei]) {
					dp[si][ei] += dp[si + 1][ei] + dp[si][ei - 1] - dp[si + 1][ei - 1];
				} else {
					int lo = low[si];
					int hi = high[ei];
					if (lo == hi) {
						dp[si][ei] = (2 * dp[si + 1][ei - 1]) + 1;
					} else if (lo > hi) {

						// character not found!!
						// test case -> a (b-z) a
						// +2 -> 'a' and 'aa'
						dp[si][ei] = dp[si + 1][ei - 1] * 2 + 2;
					} else {
						dp[si][ei] = (2 * dp[si + 1][ei - 1]) - dp[lo + 1][hi - 1];
					}
				}
				si++;
				ei++;

			}
		}

		return (dp[0][n - 1]);
	}

}
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(isScrambleTab(s1,s2));
	}

	public static boolean isScrambleTab(String s1, String s2) {
		if (s1.equals(s2))
			return true;

		int[] letters = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			letters[s1.charAt(i) - 'a']++;
			letters[s2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; i++)
			if (letters[i] != 0)
				return false;

		int len = s1.length();

		boolean[][][] dp = new boolean[len][len][len + 1];
		for (int k = 1; k <= len; ++k)
			for (int i = 0; i + k <= len; ++i)
				for (int j = 0; j + k <= len; ++j)
					if (k == 1)
						dp[i][j][k] = s1.charAt(i) == s2.charAt(j);
					else
						for (int q = 1; q < k && !dp[i][j][k]; ++q) {
							dp[i][j][k] = (dp[i][j][q] && dp[i + q][j + q][k - q])
									|| (dp[i][j + k - q][q] && dp[i + q][j][k - q]);
						}
		return dp[0][0][len];
	}

}
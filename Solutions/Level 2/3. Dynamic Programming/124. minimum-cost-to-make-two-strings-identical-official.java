import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		int x = scn.nextInt();
		int y = scn.nextInt();
		System.out.println(solution(s1, s2,x, y));
	}

	public static int solution(String s1, String s2, int c1, int c2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for(int i = 1; i <= s1.length(); i++) {
			for(int j = 1; j <= s2.length() ; j++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		int lcs = dp[s1.length()][s2.length()];
		int l1 = s1.length() - lcs;
		int l2 = s2.length() - lcs;
		return l1 * c1 + l2 * c2;
	}

}
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

	public static int solution(String str1, String str2) {
		int n1 = str1.length();
		int n2 = str2.length();
		int[][] dp = new int[n1 + 1][n2 + 1];
		for (int i = 0; i <= n1; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i <= n2; i++) {
			dp[0][i] = i;
		}
		
		for(int i = 1; i <= n1; i++) {
			for(int j = 1; j <= n2; j++) {
				if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				}else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][ j - 1])) + 1;
				}
			}
		}
		return (dp[n1][n2]);
	}

}
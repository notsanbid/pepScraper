import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

	public static int solution(String s1, String s2){
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		int ans = 0 ;
		for(int i = 1 ; i <= s1.length(); i++) {
			for(int j = 1 ; j <= s2.length() ;j++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				ans = Math.max(ans, dp[i][j]);
			}
		}
		return ans;
	}

}
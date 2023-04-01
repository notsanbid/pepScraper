import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1, s2));
	}

	public static int solution(String s, String t) {
		int m = t.length();
		int n = s.length();
		int[][] dp = new int[m + 1][n + 1];
		for(int i = 0 ; i < dp.length ; i++) {
			dp[i][0] = 0;
		}
		
		for(int i = 0 ; i < dp[0].length; i++){
			dp[0][i] = 1;
		}
		
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j  < dp[0].length ;j++) {
				if(s.charAt(j - 1) != t.charAt(i - 1)) {
					dp[i][j] = dp[i][j - 1];
				}else {
					dp[i][j] = dp[i - 1][j - 1] + dp[i][ j - 1];
				}
			}
		}
		return (dp[dp.length - 1][dp[0].length - 1]);
	}

}
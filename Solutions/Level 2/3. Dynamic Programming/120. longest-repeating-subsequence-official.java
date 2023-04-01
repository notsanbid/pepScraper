import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

	public static int solution(String str){
		int n = str.length();
		int[][] dp = new int[n + 1][n + 1];
		for(int i = 1 ; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n][n];
	}

}
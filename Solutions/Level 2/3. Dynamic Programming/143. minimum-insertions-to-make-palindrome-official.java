import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(str.length() - solution(str));
	}

	public static int solution(String str) {
		int n = str.length();
		int[][] dp = new int[n][n];
		for(int gap = 0; gap < n; gap++){
			int si = 0, ei = gap;
			while(ei < n){
				if(gap == 0){
					dp[si][ei] = 1;
				}else if(gap == 1){
					dp[si][ei] = str.charAt(si) == str.charAt(ei) ? 2 : 1;
				}else{
					dp[si][ei] = (str.charAt(si) == str.charAt(ei)) ? (dp[si + 1][ei - 1] + 2) : Math.max(dp[si + 1][ei],dp[si][ei - 1]);
				}
				si++;
				ei++;
			}
		}
		return dp[0][n - 1];
	}

}
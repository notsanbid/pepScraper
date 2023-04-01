import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m =scn.nextInt();
		int[][] arr = new int[n][m];
		for(int i = 0 ; i < n; i++){
			for(int j = 0 ; j < m; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		System.out.println(solution(arr));
	}

	public static int solution(int[][] arr) {
		int[][] dp = new int[arr.length][arr[0].length];
		int ans = 0;
		for(int i = arr.length - 1; i >= 0; i--){
			for(int j = arr[0].length - 1; j >= 0; j--){
				if(arr[i][j] == 0){
					dp[i][j] = 0;
				}else{
					if(i == arr.length - 1 || j == arr[0].length - 1){
						dp[i][j] = 1;
					}else{
						dp[i][j] = Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
					}
				}
				ans = Math.max(ans,dp[i][j]);
			}
		}
		return ans;
	}

}
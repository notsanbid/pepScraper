import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

	public static boolean solution(String s, String p) {
		boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for(int i = 1 ; i < dp.length; i++){
            for(int j = 0 ; j < dp[0].length; j++){
                if(j == 0 ){
                    if(p.charAt(i - 1) == '*')
                        dp[i][j] = dp[i - 2][j];
                }else{
                    if(p.charAt(i - 1) == '.' || p.charAt(i - 1) == s.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }else if(p.charAt(i - 1) == '*'){
                        dp[i][j] = dp[i - 2][j];
                        if(p.charAt(i - 2) == s.charAt(j - 1) || p.charAt(i - 2) == '.')
                            dp[i][j] = dp[i][j - 1] || dp[i - 2][j];
                    }
                }
                
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
	}

}
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

    public static int solution(int n){
        if(n < 3){
            return 0;
        }
        int[] dp = new int[n - 1];
        dp[0] = dp[1] = 1;

        for(int i = 2; i < dp.length; i++){
            for(int j = 0 ; j < i; j++){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[dp.length - 1];
    }

}
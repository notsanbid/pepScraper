import java.io.*;
import java.util.*;

public class Main {

    public static long NumberOfChords(int n){
        long[] dp = new long[2*n + 1];
        dp[0] = dp[2] = 1;
        for(int i = 4 ; i < dp.length; i += 2){
            for(int j = 0 ; j < i - 1; j += 2){
                dp[i] += dp[j] * dp[i - 2 - j];
            }
        }
        return dp[dp.length - 1];
    }
  public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(NumberOfChords(n));
	}
}
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int k = scn.nextInt();
    int r = scn.nextInt();
    int c = scn.nextInt();
    System.out.println(solution(k, r, c));
  }

  public static double solution(int k, int r, int c) {
    double[][] dp = new double[k + 1][k + 1];
    dp[0][0] = k;
    for (int i = 0 ; i <= r; i++) {
      for (int j = 0 ; j <= i; j++) {

        if (dp[i][j] > 1.0) {
          double spare = dp[i][j] - (double)1;
          dp[i][j] = 1.0;
          dp[i + 1][j] += spare / (double)2;
          dp[i + 1][j + 1] += spare / (double)2;
        }

      }
    }
    return dp[r][c];
  }

}
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    int ar[] = new int[n];
    for (int i = 0; i < n; i++)ar[i] = scn.nextInt();

    int dp[] = new int[n];// dp[i] max for who took decision for i'th slice
    int postsum = 0;

    dp[n - 1] = ar[n - 1];
    postsum = ar[n - 1];

    for (int i = n - 2; i >= 0; i--) {
      // postsum = ar[i+1] + ar[i+2]...ar[n-1]
      dp[i] = Math.max(
        dp[i + 1],
        ar[i] + postsum - dp[i + 1]
      );
      postsum += ar[i];
    }

    int sec = dp[0];
    int fir = postsum - sec;

    System.out.println(fir + " " + sec);
  }
}
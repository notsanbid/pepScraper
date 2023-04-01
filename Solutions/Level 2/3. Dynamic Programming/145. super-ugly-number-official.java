import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int k = scn.nextInt();
    int[] primes = new int[k];
    for (int i = 0 ; i < k; i++) {
      primes[i] = scn.nextInt();
    }
    int n = scn.nextInt();
    System.out.println(solution(primes, n));
  }

  public static int solution(int[] primes, int n) {
    int[] dp = new int[n + 1];
    dp[1] = 1;
    int[] pointers = new int[primes.length];
    Arrays.fill(pointers, 1);

    for (int i = 2; i <= n; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = 0; j < primes.length; j++) {
        min = Math.min(min, primes[j] * dp[pointers[j]]);
      }
      dp[i] = min;
      for (int j = 0; j < primes.length; j++) {
        if (min ==  (primes[j] * dp[pointers[j]])) {
          pointers[j]++;
        }
      }
    }
    return dp[n];
  }

}
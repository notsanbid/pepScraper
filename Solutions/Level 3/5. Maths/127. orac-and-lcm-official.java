import java.util.*;

public class Main {
  public static long getGCD(long a, long b) {
    if (b == 0) {
      return a;
    }
    return getGCD(b, a % b);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    long[] arr = new long[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    long[] gcd = new long[n];
    gcd[n - 1] = arr[n - 1];

    for (int i = n - 2; i >= 0; i--) {
      gcd[i] = getGCD(arr[i], gcd[i + 1]);
    }

    long ans = 0;
    for (int i = 0; i < n - 1; i++) {
      if (i == 0) {
        ans = arr[i] * gcd[i + 1] / gcd[i];
      } else {
        ans = getGCD(ans, arr[i] * gcd[i + 1] / gcd[i]);
      }
    }
    System.out.println(ans);
  }
}
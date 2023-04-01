import java.io.*;
import java.util.*;

public class Main {
  public static long func(long h, long[] height, long[] cost) {
    long sum = 0;
    for (int i = 0; i < height.length; i++) {
      sum += cost[i] * Math.abs(height[i] - h);
    }
    return sum;
  }
  public static void main(String[] args) throws Exception
  {
    Scanner sc = new Scanner(System.in);
    int testCase = sc.nextInt();

    while (testCase-- > 0) {
      int n = sc.nextInt();

      long[] height = new long[n];
      long[] cost = new long[n];

      for (int i = 0; i < n; i++) {
        height[i] = sc.nextLong();
      }

      for (int i = 0; i < n; i++) {
        cost[i] = sc.nextLong();
      }

      long l = 0;
      long r = 10000;

      while (l < r) {
        long m1 = l + (r - l) / 3;
        long m2 = r - (r - l) / 3;

        long fm1 = func(m1, height, cost);
        long fm2 = func(m2, height, cost);

        if (fm1 > fm2) {
          l = m1 + 1;
        } else if (fm1 < fm2) {
          r = m2 - 1;
        } else {
          l = m1 + 1;
          r = m2 - 1;
        }
      }

      long ans = func(l, height, cost);
      System.out.println(ans);
    }
  }
}
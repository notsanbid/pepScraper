import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
  public static long GCD(long a, long b)
  {
    if (b == 0) return a;
    return GCD(b, a % b);
  }

  public static void main (String[] args) throws java.lang.Exception
  {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();

    long[] a = new long[n];

    long gcd = 0;
    for (int i = 0; i < n; i++)
    {
      a[i] = scn.nextLong();
      gcd = GCD(gcd, Math.abs(a[i] - a[0]));
    }

    for (int i = 0; i < m; i++)
    {
      long b = scn.nextLong();
      long ans = GCD(gcd, b + a[0]);
      System.out.print(ans + " ");
    }
  }
}
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

    int t = scn.nextInt();
    while (t-- > 0)
    {
      int n = scn.nextInt();
      long k = scn.nextLong();
      long[] arr = new long[n];
      for (int i = 0; i < n; i++)
        arr[i] = scn.nextLong();

      long gcd = 0;
      for (int i = 1; i < n; i++)
        gcd = GCD(arr[i] - arr[0], gcd);

      if ((k - arr[0]) % gcd == 0) System.out.println("YES");
      else System.out.println("NO");
    }
  }
}
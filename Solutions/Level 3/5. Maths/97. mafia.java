import java.util.*;

public class six {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    long n = scn.nextLong();
    long sum = 0;
    long maxi = 0;
    for (int i = 0; i < n; i++) {
      long x = scn.nextLong();
      sum += x;
      maxi = Math.max(maxi, x);
    }
    long res = sum / (long)(n - 1);
    if (res < maxi) res = maxi;
    while (res * (n - 1) < sum) res++;
    System.out.println(res);
  }
}
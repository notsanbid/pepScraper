import java.util.Scanner;

public class Main {
  static long a, r, m;
  static long height[];

  public static long func(long h) {
    long p = 0;
    long q = 0;
    for (int i = 0; i < height.length; i++) {
      if (height[i] < h) {
        p += (h - height[i]);
      } else {
        q += (height[i] - h);
      }
    }
    long cost = 0;
    if (p >= q) {
      cost = a * (p - q) + m * q;
    } else {
      cost = r * (q - p) + m * p;
    }

    return cost;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    a = sc.nextLong();
    r = sc.nextLong();
    m = sc.nextLong();

    m = Math.min(m, a + r);

    height = new long[n];
    for (int i = 0; i < n; i++) {
      height[i] = sc.nextLong();
    }

    long l = 0;
    long r = (long)1e9;

    while (r > l) {
      long m1 = l + (r - l) / 3;
      long m2 = r - (r - l) / 3;

      long fm1 = func(m1);
      long fm2 = func(m2);

      if (fm1 > fm2) {
        l = m1 + 1;
      } else if (fm1 < fm2) {
        r = m2 - 1;
      } else {
        l = m1 + 1;
        r = m2 - 1;
      }
    }

    long ans = func(l);
    System.out.println(ans);
  }
}
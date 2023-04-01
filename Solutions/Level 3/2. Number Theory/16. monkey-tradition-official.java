import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int testCases = scn.nextInt();

    for (int i = 1; i <= testCases; i++) {
      int n = scn.nextInt();

      long n1 = scn.nextLong();
      long a1 = scn.nextLong();
      boolean flag = true;

      for (int j = 1; j < n; j++) {
        long n2 = scn.nextLong();
        long a2 = scn.nextLong();

        Pair p = euclids(n1, n2);
        long x1 = p.x;
        long gcd = p.gcd;


        if ((a1 - a2) % gcd != 0) {
          flag = false;
          break;
        } else {
          long k = (a1 - a2) / gcd;
          long lcm = (n1 / gcd) * n2;

          long ans = a1 - n1 * (k * x1 % (n2 / gcd));

          if (ans < 0) {
            ans += lcm;
          }

          a1 = ans;
          n1 = lcm;
        }
      }

      if (flag) {
        System.out.println("Case " + i + ": " + a1);
      } else {
        System.out.println("Case " + i + ": " + "Impossible");
      }
    }
  }

  public static class Pair {
    long x;
    long y;
    long gcd;

    public Pair(long x, long y, long gcd) {
      this.x = x;
      this.y = y;
      this.gcd = gcd;
    }
  }

  public static Pair euclids(long a, long b) {
    if (b == 0) {
      return new Pair(1, 0, a);
    }
    Pair dash = euclids(b, a % b);

    return new Pair(dash.y, dash.x - ((a / b) * dash.y), dash.gcd);
  }
}
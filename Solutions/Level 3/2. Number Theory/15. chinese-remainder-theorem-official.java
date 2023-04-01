import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    //Write code here
    Scanner scn = new Scanner(System.in);

    long a1 = scn.nextLong();
    long n1 = scn.nextLong();

    long a2 = scn.nextLong();
    long n2 = scn.nextLong();

    Pair p = euclids(n1, n2);
    long x1 = p.x;
    long gcd = p.gcd;

    if ( (a1 - a2) % gcd != 0 ) {
      System.out.println("no solution");
    } else {
      long lcm = (n1 / gcd) * n2;
      long k = (a1 - a2) / gcd;

      long ans = a1 - n1 * (k * x1 % (n2 / gcd));

      if (ans < 0) {
        ans += lcm;
      }

      System.out.println(ans + " " + lcm);
    }
  }

  //========= Extended Euclidean Algorithm =========//
  //------------------------------------------------//

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
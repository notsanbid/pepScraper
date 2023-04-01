import java.util.*;

public class Main {
  public static long hashCode(String s) {
    //Write your code here
    // NOTE: use prime number = 31 and mod = 1000000007
    long ans = s.charAt(0) - 'a' + 1;
    long mod = 1000000007;
    long p = 31;
    long pow = p;

    for (int i = 1; i < s.length(); i++) {
      ans = (ans + (s.charAt(i) - 'a' + 1) * pow) % mod;
      pow = (pow * p) % mod;
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int T = scn.nextInt();
    while (T-- > 0) {
      String s = scn.next();
      System.out.println(hashCode(s));
    }
    scn.close();
  }
}
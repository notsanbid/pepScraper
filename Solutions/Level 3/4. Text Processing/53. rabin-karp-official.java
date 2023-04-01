import java.util.*;

class Main {
  static Scanner scn = new Scanner(System.in);

  public static void solve() {
    String s = scn.next();
    String p = scn.next();

    ArrayList<Long> ans = new ArrayList<Long>(0);

    long hashVal = 0;
    long pr = 31;
    long pow = 1;
    long mod = 1000000007;

    for (int i = 0; i < p.length(); i++) {
      char c = p.charAt(i);
      hashVal = (hashVal + (c - 'a' + 1) * pow) % mod;
      pow = (pow * pr) % mod;
    }

    long[] dp = new long[s.length()];
    long[] pa = new long[s.length()];
    dp[0] = (s.charAt(0) - 'a' + 1);
    pa[0] = 1;
    pow = pr;
    for (int i = 1; i < s.length(); i++) {
      dp[i] = (dp[i - 1] + (s.charAt(i) - 'a' + 1) * pow) % mod;
      pa[i] = pow;
      pow = (pow * pr) % mod;
    }

    for (int ep = p.length() - 1, sp = 0; ep < s.length(); ep++, sp++) {
      long chash = dp[ep];
      if (sp > 0) chash = (chash - dp[sp - 1] + mod) % mod;
      if ((hashVal * pa[sp]) % mod == chash) ans.add((long)sp);
    }
    if (ans.size() == 0) {
      System.out.println("Not Found");
    } else {
      System.out.println(ans.size());
      for (long x : ans) {
        System.out.print(x + 1 + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    // Scanner scn = new Scanner(System.in);
    int t = scn.nextInt();
    while (t-- > 0) {
      solve();
    }
    scn.close();
  }
}
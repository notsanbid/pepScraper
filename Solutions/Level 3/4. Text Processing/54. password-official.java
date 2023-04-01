import java.util.*;

public class jsol {

  static long[] dp;
  static long[] pa;
  static long mod = 1000000007;

  public static void preProcess(String s) {
    int n = s.length();
    dp = new long[n];
    pa = new long[n];

    dp[0] = s.charAt(0) - 'a' + 1;

    pa[0] = 1;

    long p = 31;
    long pow = p;

    for (int i = 1; i < n; i++) {
      char c = s.charAt(i);
      dp[i] = (dp[i - 1] + (c - 'a' + 1) * pow) % mod;
      pa[i] = pow;
      pow = ((pow % mod) * (p % mod)) % mod;
    }
  }

  public static long substringHasher(int l, int r) {
    long ans = dp[r];
    if (l > 0) ans = ((ans - dp[l - 1]) + mod) % mod;
    return ans % mod;
  }


  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s = scn.nextLine();
    int n = s.length();

    preProcess(s);

    int len = -1;

    for (int i = 0; i < n - 1; i++) {
      long pref = dp[i];
      long suff = substringHasher(n - 1 - i, n - 1);
      // System.out.println(s.substring(0,i+1) + " " + ((pref%mod)*(pa[n-1-i]%mod))%mod + " " + suff);
      // cout<<s.substring(0,i+1)<<" "<<(pref*pa[n-1-i])%mod<<" "<<suff<<endl;
      if ((pref * pa[n - 1 - i]) % mod == suff) {
        for (int j = 1, k = i + 1; k < n - 1; j++, k++) {
          long middle = substringHasher(j, k);
          if ((pref * pa[j]) % mod == middle) {
            len = i;
            break;
          }
        }
      }
    }
    if (len == -1) System.out.println("Just a legend");
    else System.out.println(s.substring(0, len + 1));

    scn.close();
  }
}
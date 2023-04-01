import java.util.*;

public class Main {

  public static String longestPrefix(String s) {
    int n = s.length();
    long prime = 31;
    long pow = 31;
    long prefHash = (s.charAt(0) - 'a' + 1);
    long suffHash = (s.charAt(n - 1) - 'a' + 1);
    long mod = 1000000007;
    int ans = prefHash == suffHash ? 1 : 0;

    for (int i = 1; i < n - 1; i++) {
      prefHash = (prefHash * prime + (s.charAt(i) - 'a' + 1)) % mod;
      suffHash = (suffHash + (s.charAt(n - i - 1) - 'a' + 1) * pow) % mod;
      pow = (pow * prime) % mod;
      if (prefHash == suffHash) ans = i + 1;
    }
    return s.substring(0, ans);
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    // Write Code here
    String s = scn.next();
    System.out.println(longestPrefix(s));
    scn.close();
  }
}
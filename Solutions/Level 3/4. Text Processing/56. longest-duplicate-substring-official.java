import java.util.*;

public Main {
  public static String findAns(String s, int len) {
    int n = s.length();
    int sp = 0, ep = len;
    Map<Long, List<Integer>> hs = new HashMap<Long, List<Integer>>();
    long p = 31;
    long pow = 1;
    long chash = 0;
    long mod = 1000000007;
    for (int i = len - 1; i >= 0; i--) {
      char c = s.charAt(i);
      chash = (chash + ((c - 'a' + 1) * pow) % mod + mod) % mod;
      if (i > 0)pow = (pow * p) % mod;
    }
    List<Integer> empList = new LinkedList<Integer>();
    hs.put(chash, empList);
    hs.get(chash).add(0);

    while (ep < n) {
      char sc = s.charAt(sp);
      char ec = s.charAt(ep);

      chash = (chash - ((sc - 'a' + 1) * pow) % mod + mod) % mod;
      chash = (chash * p) % mod;
      chash = (chash + (ec - 'a' + 1)) % mod;

      if (hs.containsKey(chash)) {
        String curr = s.substring(sp + 1, ep + 1);
        for (int sx : hs.get(chash)) {
          if (curr.equals(s.substring(sx, sx + len))) {
            return curr;
          }
        }
        hs.get(chash).add(sp + 1);
      } else {
        hs.put(chash, empList);
        hs.get(chash).add(sp + 1);
      }
      sp++;
      ep++;
    }
    return "";
  }

  public static String longestDupSubstring(String s) {
    int n = s.length();
    int l = 0;
    int r = n;
    String ans = "";

    // insights-
    // why binary search? to find the length of longest possible efficiently, if not found anything in curr mid, this means nothing in right and visa-viss
    // why make hashMap<Long,List<String>>? Collisions are very much possible in this question
    while (l <= r) {
      int mid = (l + r) / 2;
      String currAns = findAns(s, mid);

      if (currAns != "") {
        ans = currAns;
        l = mid + 1;
      } else r = mid - 1;
    }
    return ans;
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s = scn.next();
    System.out.println(longestDupSubstring(s));
    scn.close();
  }
}
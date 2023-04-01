class Solution {
  public int longestAwesome(String s) {

    Integer map[] = new Integer[1 << (10)];
    //HashMap<Integer, Integer> map = new HashMap<>();
    // map.put(0, -1);
    map[0] = -1;

    int ans = 0;
    int state = 0;
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);

      int mask = (1 << (ch - '0'));
      state = state ^ mask;

      Integer j = map[state];
      if (j != null) {
        ans = Math.max(ans, i - j);
      }

      for (int odd = 0; odd < 10; odd++) {
        mask = 1 << odd;
        j = map[state ^ mask];
        if (j != null) {
          ans = Math.max(ans, i - j);
        }
      }

      if (map[state] == null) {
        map[state] = i;
      }
    }

    return ans;
  }
}
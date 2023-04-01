import java.io.*;
import java.util.*;

public class Main {

  static long tree[][];
  static int ar[];
  static int k;

  static long[] sum(long []l, long []r) {
    long ans[] = new long[k + 1];

    for (int i = 1; i <= k; i++) {
      ans[i] = l[i] + r[i];
    }
    return ans;
  }

  static void update(int node, int start, int end, int val, long[]ans) {

    if (start == end) {
      tree[node] = ans;
    } else {
      int mid = (start + end) >> 1;
      if (start <= val && val <= mid) {
        update(node * 2, start, mid, val, ans);
      } else {
        update(node * 2 + 1, mid + 1, end, val, ans);
      }
      tree[node] = sum(tree[node * 2], tree[node * 2 + 1]);
    }
  }

  static long[] query(int node, int start, int end, int l, int r) {
    if (end < l || r < start )return new long[k + 1];

    if (start == end) {
      return tree[node];
    } else if (l <= start && end <= r) {
      return tree[node];
    } else {
      int mid = (start + end) >> 1;
      long []la = query(node * 2, start, mid, l, r);
      long []ra = query(node * 2 + 1, mid + 1, end, l, r);
      return sum(la, ra);
    }

  }



  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    k = Integer.parseInt(read.readLine());

    ar = new int[n];

    for (int i = 0; i < n; i++) {
      ar[i] = Integer.parseInt(read.readLine());
    }
    // write your code here

    tree = new long[4 * n][k + 1];

    for (int i = 0; i < n; i++) {
      long ans[];
      if (ar[i] == 1) {
        ans = new long[k + 1];
        ans[1] = 1;
      } else { // 1..ar[i]-1
        long []sum = query(1, 1, n, 1, ar[i] - 1);
        ans = new long[k + 1];
        for (int l = 2; l <= k; l++) {
          ans[l] = sum[l - 1];
        }
        ans[1] = 1;
      }

      update(1, 1, n, ar[i], ans);
    }

    long ans = tree[1][k];

    System.out.println(ans);

  }
}
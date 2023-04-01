import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static PrintWriter out = new PrintWriter(System.out);
  /*
  use in for reading input
  use out for printing output
  */

  static int ar[];
  static int MAXBIT = 20;
  static Pair[]tree;
  static int lazy[];

  static class Pair {
    long sum = 0;
    int count1[] = new int[MAXBIT];
    Pair() {};
    Pair(int s) {
      sum = s;
      for (int i = 0; i < MAXBIT; i++) {
        int mask = 1 << i;
        if ((s & mask) > 0) {
          count1[i] = 1;
        }
      }
    }
    Pair(Pair l, Pair r) {
      sum = l.sum + r.sum;
      for (int i = 0; i < MAXBIT; i++) {
        count1[i] = l.count1[i] + r.count1[i];
      }
    }
  }

  static void build(int node, int start, int end) {
    if (start == end) {
      int val = ar[start];
      tree[node] = new Pair(val);
    } else {
      int mid = (start + end) / 2;
      build(node * 2, start, mid);
      build(node * 2 + 1, mid + 1, end);
      tree[node] = new Pair(tree[node * 2], tree[node * 2 + 1]);
    }
  }

  static void propagate(int node, int start, int end) {

    if (lazy[node] == 0)return;

    if (start == end) {
      int val = ((int)(tree[node].sum)) ^ lazy[node];
      lazy[node] = 0;
      tree[node] = new Pair(val);
    } else {
      int x = lazy[node];
      lazy[node] = 0;
      lazy[node * 2] ^= x;
      lazy[node * 2 + 1] ^= x;

      long sum = tree[node].sum;

      for (int i = 0; i < MAXBIT; i++) {
        int mask = 1 << i;
        if ((x & mask) > 0) {

          int one = tree[node].count1[i];
          int zero = (end - start + 1) - one;

          long diff = (zero - one);
          sum += diff * mask;
          tree[node].count1[i] = zero;
        }
      }

      tree[node].sum = sum;
    }

  }

  static long query(int node, int start, int end, int l, int r) {
    propagate(node, start, end);
    if (end < l || r < start)return 0;

    if (start == end) {
      return tree[node].sum;
    } else if (l <= start && end <= r) {
      return tree[node].sum;
    } else {
      int mid = (start + end) / 2;
      return query(node * 2, start, mid, l, r) + query(node * 2 + 1, mid + 1, end, l, r);
    }
  }

  static void update(int node, int start, int end, int l, int r, int x) {
    propagate(node, start, end);

    if (end < l || r < start)return;

    if (start == end) {
      lazy[node] ^= x;
      propagate(node, start, end);
    } else if (l <= start && end <= r) {
      lazy[node] ^= x;
      propagate(node, start, end);
    } else {
      int mid = (start + end) / 2;
      update(node * 2, start, mid, l, r, x);
      update(node * 2 + 1, mid + 1, end, l, r, x);
      tree[node] = new Pair(tree[node * 2], tree[node * 2 + 1]);
    }

  }

  public static void main(String[] args) throws IOException {

    // write your code here.
    int n = Integer.parseInt(in.readLine());
    ar = new int[n];
    tree = new Pair[4 * n];
    lazy = new int[4 * n];

    String inp[] = in.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      ar[i] = Integer.parseInt(inp[i]);
    }

    build(1, 0, n - 1);

    int q = Integer.parseInt(in.readLine());

    while (q-- > 0) {
      inp = in.readLine().split(" ");
      int t = Integer.parseInt(inp[0]);
      int l = Integer.parseInt(inp[1]) - 1;
      int r = Integer.parseInt(inp[2]) - 1;

      if (t == 1) {
        long ans = query(1, 0, n - 1, l, r);
        out.println(ans);
      } else {
        int x = Integer.parseInt(inp[3]);
        update(1, 0, n - 1, l, r, x);
      }
    }

    out.close();
  }
}
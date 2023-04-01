import java.io.*;
import java.util.*;

public class Main {

  public static class Pair {
    int sum = 0;
    int max = 0;
    Pair(int s, int m) {
      sum = s;
      max = m;
    }
  }

  static Pair tree[];
  static int arr[];

  static void build(int node, int start, int end) {
    if (start == end) {
      tree[node] = new Pair(arr[start], arr[start]);
    } else {
      int mid = (start + end) >> 1;
      build(node * 2, start, mid);
      build(node * 2 + 1, mid + 1, end);
      tree[node] = calc(tree[node * 2], tree[node * 2 + 1]);
    }
  }
  static Pair calc(Pair l, Pair r) {
    Pair ans = new Pair(0, 0);

    ans.sum = Math.max(l.sum, r.sum);
    ans.sum = Math.max(ans.sum, l.max + r.max);

    ans.max = Math.max(l.max, r.max);
    return ans;
  }

  static void update(int node, int start, int end, int idx, int val) {

    if (start == end) {
      arr[start] = val;
      tree[node].max = tree[node].sum = val;
    } else {
      int mid = (start + end) >> 1;
      if (start <= idx && idx <= mid) {
        update(node * 2, start, mid, idx, val);
      } else {
        update(node * 2 + 1, mid + 1, end, idx, val);
      }
      tree[node] = calc(tree[node * 2], tree[node * 2 + 1]);
    }

  }

  static Pair query(int node, int start, int end, int l, int r) {
    if (end < l || r < start) {
      return new Pair(0, 0);
    }

    if (start == end) {
      return tree[node];
    } else if (l <= start && end <= r) {
      return tree[node];
    } else {
      int mid = (start + end) >> 1;
      Pair la = query(node * 2, start, mid, l, r);
      Pair ra = query(node * 2 + 1, mid + 1, end, l, r);
      return calc(la, ra);
    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());

    arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(read.readLine());
    }
    tree = new Pair[4 * n];
    build(1, 0, n - 1);

    int q = Integer.parseInt(read.readLine());

    while (q-- > 0) {
      String inp[] = read.readLine().split(" ");
      int t = Integer.parseInt(inp[0]);
      int a = Integer.parseInt(inp[1]);
      int b = Integer.parseInt(inp[2]);

      if (t == 0) {
        update(1, 0, n - 1, a, b);
      } else {
        Pair ans = query(1, 0, n - 1, a, b);
        System.out.println(ans.sum);
      }
    }
  }

}
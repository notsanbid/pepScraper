import java.io.*;
import java.util.*;

public class Main {

  public static class SegmentTree {

    static class Pair {
      long sum;
      long sumSq;
      Pair(long s, long sq) {
        sum = s;
        sumSq = sq;
      }
    }

    int ar[];
    Pair tree[];
    long lazy[];

    SegmentTree(int arr[]) {
      int n = arr.length;
      ar = arr;
      tree = new Pair[n * 4];
      lazy = new long[n * 4];
      build(1, 0, n - 1);
    }

    private Pair calc(Pair l, Pair r) {
      Pair ans = new Pair(l.sum + r.sum, l.sumSq + r.sumSq);
      return ans;
    }

    private void build(int node, int start, int end) {
      if (start == end) {
        tree[node] = new Pair(ar[start], ar[start]*ar[start]);
      } else {
        int mid = (start + end) / 2;
        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);
        tree[node] = calc(tree[node * 2], tree[node * 2 + 1]);
      }
    }

    private void propagate(int node, int start, int end) {
      if (lazy[node] == 0)return;
      if (start == end) {
        tree[node].sum += lazy[node];
        tree[node].sumSq = tree[node].sum * tree[node].sum;
      } else {
        Pair p = tree[node];
        int count = (end - start + 1);
        p.sumSq += count * lazy[node] * lazy[node] + 2 * lazy[node] * p.sum;
        p.sum += count * lazy[node];

        lazy[node * 2] += lazy[node];
        lazy[node * 2 + 1] += lazy[node];
      }
      lazy[node] = 0;
    }

    void update(int l, int r, int val) {
      update(1, 0, ar.length - 1, l, r, val);
    }

    private void update(int node, int start, int end, int l, int r, int val) {
      propagate(node, start, end);
      if (end < l || r < start)return;
      if (start == end) {
        lazy[node] += val;
        propagate(node, start, end);
      } else if (l <= start && end <= r) {
        lazy[node] += val;
        propagate(node, start, end);
      } else {
        int mid = (start + end) / 2;
        update(node * 2, start, mid, l, r, val);
        update(node * 2 + 1, mid + 1, end, l, r, val);
        tree[node] = calc(tree[node * 2], tree[node * 2 + 1]);
      }
    }

    long query(int l, int r) {
      return query(1, 0, ar.length - 1, l, r).sumSq;
    }

    private Pair query(int node, int start, int end, int l, int r) {
      propagate(node, start, end);
      if (end < l || r < start)return new Pair(0, 0);

      if (start == end) {
        return tree[node];
      } else if ( l <= start && end <= r) {
        return tree[node];
      } else {
        int mid = (start + end) / 2;
        Pair la = query(node * 2, start, mid, l, r);
        Pair ra = query(node * 2 + 1, mid + 1, end, l, r);
        return calc(la, ra);
      }

    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int arr[] = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(read.readLine());
    }

    SegmentTree obj = new SegmentTree(arr);

    int q = Integer.parseInt(read.readLine());

    StringBuilder out = new StringBuilder();
    while (q-- > 0) {
      String[] inp = read.readLine().split(" ");

      int t = Integer.parseInt(inp[0]);
      int l = Integer.parseInt(inp[1]);
      int r = Integer.parseInt(inp[2]);

      if (t == 0) {
        long ans = obj.query(l, r);
        out.append(ans + "\n");
      } else {
        int val = Integer.parseInt(inp[3]);
        obj.update(l, r, val);
      }
    }

    System.out.println(out);
  }

}
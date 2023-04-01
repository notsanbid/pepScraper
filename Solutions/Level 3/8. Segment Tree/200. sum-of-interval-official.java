import java.io.*;
import java.util.*;

public class Main {

  public static class SegmentTree {

    int tree[];
    int ar[];

    SegmentTree(int arr[]) {
      ar = arr;
      tree = new int[4 * ar.length];
      build(1, 0, ar.length - 1);
    }

    private void build(int node, int start, int end) {
      if (start == end) { // leaf
        tree[node] = ar[start];
      } else {
        int mid = (start + end) / 2;
        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
      }
    }

    void update(int pos, int val) {
      update(1, 0, ar.length - 1, pos, val);
    }

    private void update(int node, int start, int end, int pos, int val) {
      if (start == end) {
        ar[start] = val;
        tree[node] = val;
      } else {
        int mid = (start + end) / 2;
        if (start <= pos && pos <= mid) {
          update(node * 2, start, mid, pos, val);
        } else {
          update(node * 2 + 1, mid + 1, end, pos, val);
        }

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
      }
    }

    int query(int l, int r) {
      return query(1, 0, ar.length - 1, l, r);
    }

    private int query(int node, int start, int end, int l, int r) {
      if (end < l || r < start)return 0;

      if (start == end) {
        return tree[node];
      } else if (l <= start && end <= r) {
        return tree[node];
      } else {
        int mid = (start + end) / 2;
        int left = query(node * 2, start, mid, l, r);
        int right = query(node * 2 + 1, mid + 1, end, l, r);
        return left + right;
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
      String[]inp = read.readLine().split(" ");

      int t = Integer.parseInt(inp[0]);
      int l = Integer.parseInt(inp[1]);
      int r = Integer.parseInt(inp[2]);

      if (t == 0) {
        obj.update(l, r);
      } else {
        int ans = obj.query(l, r);
        out.append(ans);
        out.append("
                   ");
      }
    }

    System.out.println(out);
  }

}
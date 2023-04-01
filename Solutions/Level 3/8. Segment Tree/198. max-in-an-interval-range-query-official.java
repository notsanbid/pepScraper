import java.io.*;
import java.util.*;

public class Main {

  public static class SegmentTree {

    int tree[];
    int arr[];

    SegmentTree(int ar[]) {
      arr = ar;
      tree = new int[4 * arr.length];
      build(1, 0, arr.length - 1);
    }

    private void build(int node, int start, int end) {
      if (start == end) {
        tree[node] = arr[start];
      } else {
        int mid = (start + end) / 2;
        int left = node * 2;
        int right = node * 2 + 1;
        build(left, start, mid);
        build(right, mid + 1, end);
        tree[node] = Math.max(tree[left], tree[right]);
      }
    }

    private int query(int node, int start, int end, int l, int r) {
      if (end < l || r < start)return Integer.MIN_VALUE;

      if (start == end) {
        return tree[node];
      } else if (l <= start && end <= r) {
        return tree[node];
      } else {
        int mid = (start + end) / 2;
        int left = query(node * 2, start, mid, l, r);
        int right = query(node * 2 + 1, mid + 1, end, l, r);

        return Math.max(left, right);
      }
    }

    int query(int l, int r) {
      return query(1, 0, arr.length - 1, l, r);
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

      int l = Integer.parseInt(inp[0]);
      int r = Integer.parseInt(inp[1]);

      int ans = obj.query(l, r);
      out.append(ans);
      out.append("
                 ");
    }

    System.out.println(out);
  }

}
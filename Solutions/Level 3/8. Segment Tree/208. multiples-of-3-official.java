import java.io.*;
import java.util.*;

public class Main {

  static int tree[][];
  static int lazy[];

  static void build(int node, int start, int end) {

    if (start == end) {
      tree[node][0] = 1;
    } else {
      int mid = (start + end) / 2;
      build(node * 2, start, mid);
      build(node * 2 + 1, mid + 1, end);
      copy(tree[node * 2], tree[node * 2 + 1], tree[node]);
    }
  }

  static void copy(int l[], int []r, int ans[]) {
    for (int i = 0; i <= 2; i++)
      ans[i] = l[i] + r[i];
  }

  static void shift(int ar[]) {
    int i0 = ar[0];
    ar[0] = ar[2];
    ar[2] = ar[1];
    ar[1] = i0;
  }

  static void propagate(int node, int start, int end) {
    lazy[node] = lazy[node] % 3;
    if (lazy[node] == 0)return;

    int t = lazy[node];
    while (lazy[node] > 0) {
      shift(tree[node]);
      lazy[node]--;
    }
    if (start != end) {
      lazy[node * 2] += t;
      lazy[node * 2 + 1] += t;
    }
  }

  static void update(int node, int start, int end, int l, int r) {
    propagate(node, start, end);
    if (end < l || r < start)return;

    if (start == end) {
      shift(tree[node]);
    } else if (l <= start && end <= r) {
      lazy[node]++;
      propagate(node, start, end);
    } else {
      int mid = (start + end) / 2;
      update(node * 2, start, mid, l, r);
      update(node * 2 + 1, mid + 1, end, l, r);
      copy(tree[node * 2], tree[node * 2 + 1], tree[node]);
    }

  }

  static int query(int node, int start, int end, int l, int r) {
    if (end < l || r < start)return 0;
    propagate(node, start, end);

    if (start == end) {
      return tree[node][0];
    } else if (l <= start && end <= r) {
      return tree[node][0];
    } else {
      int mid = (start + end) / 2;
      return query(node * 2, start, mid, l, r) + query(node * 2 + 1, mid + 1, end, l, r);
    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int q = Integer.parseInt(read.readLine());

    // write your code here

    tree = new int[n * 4][3];
    lazy = new int[4 * n];

    build(1, 1, n);

    while ( q-- > 0 ) {
      String inp[] = read.readLine().split(" ");

      int t = Integer.parseInt(inp[0]);
      int A = Integer.parseInt(inp[1]);
      int B = Integer.parseInt(inp[2]);

      if (t == 1) {
        update(1, 1, n, A, B);
      } else {
        int ans = query(1, 1, n, A, B);
        System.out.println(ans);
      }
    }

  }
}
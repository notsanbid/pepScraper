import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static PrintWriter out = new PrintWriter(System.out);
  /*
  use in for reading input
  use out for printing output
  */
  static int MAXBIT = 30;
  static int tree[], ar[];

  static void build(int node, int start, int end) {
    if (start == end) {
      tree[node] = ar[start];
    } else {
      int mid = (start + end) / 2;
      build(node * 2, start, mid);
      build(node * 2 + 1, mid + 1, end);
      tree[node] = tree[node * 2] & tree[node * 2 + 1];
    }
  }


  static int query(int node, int start, int end, int l, int r) {
    if (end < l || r < start)return Integer.MAX_VALUE;

    if (l <= start && end <= r) {
      return tree[node];
    } else {
      int mid = (start + end) / 2;
      return query(node * 2, start, mid, l, r) & query(node * 2 + 1, mid + 1, end, l, r);
    }
  }

  public static void main(String[] args) throws IOException {

    // write your code here.

    String inp[] = in.readLine().split(" ");
    int n = Integer.parseInt(inp[0]);
    int m = Integer.parseInt(inp[1]);

    int l[] = new int[m];
    int r[] = new int[m];
    int q[] = new int[m];
    for (int i = 0; i < m; i++) {
      inp = in.readLine().split(" ");
      l[i] = Integer.parseInt(inp[0]) - 1;
      r[i] = Integer.parseInt(inp[1]) - 1;
      q[i] = Integer.parseInt(inp[2]);
    }

    ar = new int[n];

    for (int b = 0; b < MAXBIT; b++) {
      int mask = 1 << b;

      int pre[] = new int[n];
      for (int i = 0; i < m; i++) {
        if ((q[i]&mask) > 0) {
          pre[l[i]]++;
          if (r[i] + 1 < n) {
            pre[r[i] + 1]--;
          }
        }
      }

      int sum = 0;

      for (int i = 0; i < n; i++) {
        sum += pre[i];
        if (sum > 0) {
          ar[i] |= mask;
        }
      }
    }

    tree = new int[4 * n];
    build(1, 0, n - 1);

    boolean ok = true;
    for (int i = 0; i < m; i++) {
      // int and=ar[l[i]];
      // and = ar[l[i]]....ar[r[i]]
      // for(int j=l[i]; j<=r[i]; j++){
      //     and = and & ar[j];
      // }

      int and = query(1, 0, n - 1, l[i], r[i]);
      if ( and != q[i]) {
        ok = false;
        break;
      }
    }

    if (ok) {
      out.println("YES");
      for (int val : ar) {
        out.print(val + " ");
      }
      out.println();
    } else {
      out.println("NO");
    }

    out.close();
  }
}
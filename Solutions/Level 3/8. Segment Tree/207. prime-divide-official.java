import java.io.*;
import java.util.*;

public class Main {

  static int tree[][];
  static int ar[];

  static void updateR(int node, int start, int end, int l, int r, int pIdx) {
    if (end < l || r < start)return;

    if (l <= start && end <= r) {
      tree[node][pIdx]++;
    } else {
      int mid = (start + end) / 2;
      updateR(node * 2, start, mid, l, r, pIdx);
      updateR(node * 2 + 1, mid + 1, end, l, r, pIdx);
    }
  }

  static void propagate(int node, int start, int end) {
    if (start != end) {
      for (int i = 0; i <= 2; i++)
        tree[node * 2][i] += tree[node][i];

      for (int i = 0; i <= 2; i++)
        tree[node * 2 + 1][i] += tree[node][i];
    } else {
      while (ar[start] % 2 == 0 && tree[node][0] > 0) {
        ar[start] /= 2;
        tree[node][0]--;
      }
      while (ar[start] % 3 == 0 && tree[node][1] > 0) {
        ar[start] /= 3;
        tree[node][1]--;
      }
      while (ar[start] % 5 == 0 && tree[node][2] > 0) {
        ar[start] /= 5;
        tree[node][2]--;
      }

    }
    for (int i = 0; i <= 2; i++)
      tree[node][i] = 0;
  }

  static void updateP(int node, int start, int end, int l, int d) {
    propagate(node, start, end);

    if (start == end) {
      ar[start] = d;
    } else {
      int mid = (start + end) / 2;
      if (start <= l && l <= mid) {
        updateP(node * 2, start, mid, l, d);
      } else {
        updateP(node * 2 + 1, mid + 1, end, l, d);
      }
    }
  }

  static void propagateAll(int node, int start, int end) {
    propagate(node, start, end);
    if (start == end)return;
    int mid = (start + end) / 2;
    propagateAll(node * 2, start, mid);
    propagateAll(node * 2 + 1, mid + 1, end);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());

    ar = getAr(read.readLine());

    tree = new int[4 * n][3]; // [2, 3, 5]

    int q = Integer.parseInt(read.readLine());

    while (q-- > 0) {
      int qry[] = getAr(read.readLine());// [ 0 , 1 ]
      if (qry[1] == 1) { // 1 l r p
        int idx = 0;
        if (qry[4] == 3)idx = 1;
        if (qry[4] == 5) idx = 2;
        updateR(1, 1, n, qry[2], qry[3], idx);
      } else {
        // 2 l d
        updateP(1, 1, n, qry[2], qry[3]);
      }
    }

    propagateAll(1, 1, n);

    for (int i = 1; i <= n; i++) {
      System.out.println(ar[i]);
    }

  }

  static int[] getAr(String inp) {
    String inps[] = inp.split(" ");// 0
    int ar[] = new int[inps.length + 1]; // 1
    for (int i = 0; i < inps.length; i++) {
      ar[i + 1] = Integer.parseInt(inps[i]);
    }
    return ar;
  }
}
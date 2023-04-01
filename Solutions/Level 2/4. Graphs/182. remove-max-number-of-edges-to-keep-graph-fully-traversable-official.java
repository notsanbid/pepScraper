import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    int[][] edges = new int[m][3];
    for (int i = 0; i < m; i++) {
      st = br.readLine().split(" ");
      edges[i][0] = Integer.parseInt(st[0]);
      edges[i][1] = Integer.parseInt(st[1]);
      edges[i][2] = Integer.parseInt(st[2]);
    }
    Main obj = new Main();
    System.out.println(obj.maxNumEdgesToRemove(n, edges));
  }

  public int maxNumEdgesToRemove(int n, int[][] edges) {
    Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));
    int[] parenta = new int[n + 1];
    int[] parentb = new int[n + 1];
    int[] ranka = new int[n + 1];
    int[] rankb = new int[n + 1];
    int counta = 1;
    int countb = 1;

    for (int i = 0; i <= n; i++) {
      parenta[i] = i;
      parentb[i] = i;
    }

    int removedEdges = 0;

    for (int[] e : edges) {
      if (e[0] == 3) {
        boolean mergeda = union(e[1], e[2], parenta, ranka);
        boolean mergedb = union(e[1], e[2], parentb, rankb);
        if (mergeda == true) {
          counta++;
        }
        if (mergedb == true) {
          countb++;
        }

        if (!mergeda && !mergedb) {
          removedEdges++;
        }
      } else if (e[0] == 1) {
        boolean mergeda = union(e[1], e[2], parenta, ranka);
        if (mergeda == true) {
          counta++;
        }

        if (!mergeda) {
          removedEdges++;
        }
      } else {
        boolean mergedb = union(e[1], e[2], parentb, rankb);
        if (mergedb == true) {
          countb++;
        }
        if (!mergedb) {
          removedEdges++;
        }
      }
    }

    if (countb != n || counta != n) {
      return -1;
    }

    return removedEdges;
  }

  public int find(int x, int[] parent) {
    if (parent[x] == x) {
      return x;
    }
    int temp = find(parent[x], parent);
    parent[x] = temp;
    return temp;
  }

  public boolean union(int x, int y, int[] parent, int[] rank) {
    int lx = find(x, parent);
    int ly = find(y, parent);

    if (lx == ly)
      return false;

    if (rank[lx] > rank[ly]) {
      parent[ly] = lx;
    } else if (rank[lx] < rank[ly]) {
      parent[lx] = ly;
    } else {
      parent[lx] = ly;
      rank[ly]++;
    }
    return true;
  }
}
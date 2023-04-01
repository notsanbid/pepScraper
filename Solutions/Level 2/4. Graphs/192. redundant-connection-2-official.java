import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);

    int[][] pos = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      pos[i][0] = Integer.parseInt(st[0]);
      pos[i][1] = Integer.parseInt(st[1]);
    }

    int[] ans = findRedundantDirectedConnection(pos);
    System.out.println(ans[0] + " " + ans[1]);
  }

  static int[] parent;
  static int[] rank;

  public static int[] findRedundantDirectedConnection(int[][] edges) {
    int n = edges.length;
    int[] indegree = new int[n + 1];
    Arrays.fill(indegree, -1);
    int bl1 = -1;
    int bl2 = -1;
    for (int i = 0; i < edges.length; i++) {
      int[] edge = edges[i];
      int u = edge[0];
      int v = edge[1];

      if (indegree[v] == -1) {
        indegree[v] = i;
      } else {
        bl1 = i;
        bl2 = indegree[v];
      }
    }
    parent = new int[n + 1];
    rank = new int[n + 1];
    for (int i = 1; i < parent.length; i++) {
      parent[i] = i;
      rank[i] = 1;
    }
    for (int i = 0; i < edges.length; i++) {
      if (bl1 == i) {
        continue;
      }
      int[] edge = edges[i];
      int u = edge[0];
      int v = edge[1];
      boolean flag = union(u, v);
      if (flag == true) {
        if (bl1 == -1) {
          return edge;
        } else {
          return edges[bl2];
        }
      }
    }
    return edges[bl1];
  }

  public static int find(int x) {
    if (parent[x] == x) {
      return x;
    }
    int temp = find(parent[x]);
    parent[x] = temp;
    return temp;
  }

  public static boolean union(int x, int y) {
    int lx = find(x);
    int ly = find(y);

    if (lx == ly) {
      return true;
    }

    if (rank[lx] > rank[ly]) {
      parent[ly] = lx;
    } else if (rank[lx] < rank[ly]) {
      parent[lx] = ly;
    } else {
      parent[lx] = ly;
      rank[ly]++;
    }

    return false;
  }

}
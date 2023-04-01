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

    int[] ans = findRedundantConnection(pos);
    System.out.println(ans[0] + " " + ans[1]);
  }

  public static int[] findRedundantConnection(int[][] edges) {
    int[] parent = new int[2001];
    for (int i = 0; i < parent.length; i++)
      parent[i] = i;

    for (int[] edge : edges) {
      int f = edge[0], t = edge[1];
      if (find(parent, f) == find(parent, t))
        return edge;
      else
        parent[find(parent, f)] = find(parent, t);
    }

    return new int[2];
  }

  private static int find(int[] parent, int f) {
    if (f != parent[f]) {
      parent[f] = find(parent, parent[f]);
    }
    return parent[f];
  }
}
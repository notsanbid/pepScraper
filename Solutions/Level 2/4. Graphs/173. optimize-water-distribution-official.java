import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int v = Integer.parseInt(st[0]);
    int e = Integer.parseInt(st[1]);

    int[] wells = new int[v];
    String[] words = br.readLine().split(" ");

    for (int i = 0; i < wells.length; i++) {
      wells[i] = Integer.parseInt(words[i]);
    }

    int[][] pipes = new int[e][3];
    for (int i = 0; i < e; i++) {
      String[] st1 = br.readLine().split(" ");
      pipes[i][0] = Integer.parseInt(st1[0]);
      pipes[i][1] = Integer.parseInt(st1[1]);
      pipes[i][2] = Integer.parseInt(st1[2]);

    }

    System.out.println(minCostToSupplyWater(v, wells, pipes));

  }

  public static class Pair implements Comparable<Pair> {
    int u;
    int v;
    int wt;

    Pair(int u, int v, int wt) {
      this.u = u;
      this.v = v;
      this.wt = wt;
    }

    @Override
    public int compareTo(Pair o) {
      return this.wt - o.wt;
    }
  }

  public static  int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
    Pair[] edges = new Pair[pipes.length + n];

    int idx = 0;
    for (int i = 0; i < pipes.length; i++) {
      int u = pipes[i][0];
      int v = pipes[i][1];
      int wt = pipes[i][2];
      edges[idx] = new Pair(u, v, wt);
      idx++;
    }

    for (int i = 0; i < wells.length; i++) {
      int u = 0;
      int v = i + 1;
      int wt = wells[i];
      edges[idx] = new Pair(u, v, wt);
      idx++;
    }

    ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < edges.length; i++) {
      int u = edges[i].u;
      int v = edges[i].v;
      int wt = edges[i].wt;
      graph.get(u).add(new Pair(0, v, wt));
      graph.get(v).add(new Pair(0, u, wt));
    }
    int ans = 0;
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(0, 0, 0));
    boolean[] vis = new boolean[n + 1];
    while (pq.size() > 0) {
      Pair rem = pq.remove();
      if (vis[rem.v] == true) {
        continue;
      }
      vis[rem.v] = true;
      ans += rem.wt;
      ArrayList<Pair> nbrs = graph.get(rem.v);

      for (Pair nbr : nbrs) {
        if (vis[nbr.v] == false) {
          pq.add(new Pair(0, nbr.v, nbr.wt));
        }
      }
    }
    return ans;
  }


}
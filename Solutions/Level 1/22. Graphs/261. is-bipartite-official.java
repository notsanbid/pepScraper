import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      HashMap<Integer, Integer> visited = new HashMap<>();
      for (int v = 0; v < vtces; v++) {
         if (!visited.containsKey(v)) {
            boolean bip = IsBipartite(graph, v, visited);
            if (!bip) {
               System.out.println(false);
               return;
            }
         }
      }

      System.out.println(true);
   }

   static class Pair {
      int vtx;
      int level;

      Pair(int vtx, int level) {
         this.vtx = vtx;
         this.level = level;
      }
   }

   public static boolean IsBipartite(ArrayList<Edge>[] graph, int src, HashMap<Integer, Integer> visited) {
      ArrayDeque<Pair> queue = new ArrayDeque<>();
      queue.add(new Pair(src, 0));
      while (queue.size() > 0) {
         Pair rem = queue.remove();

         if (visited.containsKey(rem.vtx)) {
            if (visited.get(rem.vtx) % 2 != rem.level % 2) {
               return false;
            }
         } else {
            visited.put(rem.vtx, rem.level);
         }

         for (Edge e : graph[rem.vtx]) {
            if (!visited.containsKey(e.nbr)) {
               queue.add(new Pair(e.nbr, rem.level + 1));
            }
         }
      }

      return true;
   }

}
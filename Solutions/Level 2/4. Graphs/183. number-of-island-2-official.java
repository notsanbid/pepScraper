import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int m = Integer.parseInt(st[0]);
    int n = Integer.parseInt(st[1]);
    int q = Integer.parseInt(st[2]);

    int[][] pos = new int[q][2];
    for (int i = 0; i < q; i++) {
      st = br.readLine().split(" ");
      pos[i][0] = Integer.parseInt(st[0]);
      pos[i][1] = Integer.parseInt(st[1]);
    }

    System.out.println(numIslands2(m, n, pos));
  }

  public static List<Integer> numIslands2(int m, int n, int[][] positions) {
    List<Integer> res = new LinkedList<>();
    if (m <= 0 || n <= 0) {
      return res;
    }

    int count = 0;
    int[] roots = new int[m * n];
    int[] size = new int[m * n];
    Arrays.fill(roots, -1);
    int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    for (int[] p : positions) {
      int island = p[0] * n + p[1];
      roots[island] = island;
      size[island]++;
      count++;

      for (int[] dir : directions) {
        int x = p[0] + dir[0], y = p[1] + dir[1];
        int neighbor = x * n + y;

        if (x < 0 || x >= m || y < 0 || y >= n || roots[neighbor] == -1) {
          continue;
        }
        int neighborRoot = find(neighbor, roots);
        int islandRoot = find(island, roots);
        if (islandRoot != neighborRoot) {

          if (size[islandRoot] >= size[neighborRoot]) {
            size[islandRoot] += size[neighborRoot];
            roots[neighborRoot] = islandRoot;
          } else {
            size[neighborRoot] += size[islandRoot];
            roots[islandRoot] = neighborRoot;
          }
          count--;
        }
      }

      res.add(count);
    }

    return res;
  }

  private static int find(int id, int[] roots) {
    if (roots[id] == id) {
      return id;
    } else {
      roots[id] = find(roots[id], roots);
      return roots[id];
    }
  }
}
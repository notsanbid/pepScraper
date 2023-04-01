import java.util.*;

public class Main {
  static int[] par;
  static int[] size;

  public static int findPar(int u) {
    if (par[u] == u) return u;

    return par[u] = findPar(par[u]);
  }

  public static void merge(int p1, int p2) {
    if (size[p1] > size[p2]) {
      par[p2] = p1;
      size[p1] += size[p2];
    } else {
      par[p1] = p2;
      size[p2] += size[p1];
    }
  }

  public static int makeConnected(int n, int[][] connections) {

    if (n - 1 > connections.length) return -1;

    par = new int[n];
    size = new int[n];

    for (int i = 0; i < n; i++) {
      par[i] = i;
      size[i] = 1;
    }

    for (int[] c : connections) {
      int u = c[0];
      int v = c[1];

      int p1 = findPar(u);
      int p2 = findPar(v);

      if (p1 != p2) {
        merge(p1, p2);
      }
    }

    int count = 0;
    for (int i = 0; i < n; i++) {
      int p = findPar(i);
      if (p == i) {
        count++;
      }
    }

    return count - 1;
  }

  public static void main(String[] args) {

    Scanner scn = new Scanner(System.in);
    int numberOfHouses = scn.nextInt();
    int n = scn.nextInt();
    int[][] connections = new int[n][2];
    for (int i = 0; i < n; i++) {
      connections[i][0] = scn.nextInt();
      connections[i][1] = scn.nextInt();
    }

    int ans = makeConnected(numberOfHouses, connections);
    System.out.println(ans);
  }
}
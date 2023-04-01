import java.io.*;

public class Main {
  static int par[];
  public static int fp(int u) {
    if (par[u] == u) return u;

    return par[u] = fp(par[u]);
  }
  public static void merge(int u, int v) {
    // System.out.println(u+" "+v);
    int p1 = fp(u);
    int p2 = fp(v);

    if (p1 != p2) {
      par[p2] = p1;
    }
  }

  public static int parkRegions(String[] grid) {
    int n = grid.length;
    par = new int[4 * n * n];

    for (int i = 0; i < par.length; i++) {
      par[i] = i;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < grid[i].length(); j++) {
        int root = 4 * (i * n + j);
        char c = grid[i].charAt(j);

        if (c != '\\') {
          merge(root, root + 1);
          merge(root + 3, root + 2);
        }
        if (c != '/') {
          merge(root, root + 3);
          merge(root + 1, root + 2);
        }

        if (j + 1 < n) {
          merge(root + 2, root + 4);
        }
        if (j - 1 >= 0) {
          merge(root, root - 2);
        }

        if (i + 1 < n) {
          merge(root + 3, root + 4 * n + 1);
        }

        if (i - 1 >= 0) {
          merge((root - 4 * n) + 3, root + 1);
        }
      }
    }

    int ans = 0;
    for (int i = 0; i < par.length; i++) {
      if (fp(i) == i) {
        ans++;
      }
    }
    return ans;
  }
  public static void main(String[] args) throws Exception{
    InputStreamReader r = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(r);
    int n = Integer.parseInt(br.readLine());

    String[] park = new String[n];
    for (int i = 0; i < n; i++) {
      park[i] = br.readLine();
    }

    int ans = parkRegions(park);
    System.out.println(ans);
  }
}
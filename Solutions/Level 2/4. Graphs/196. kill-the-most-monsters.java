import java.util.*;
import java.io.*;

public class Main {
  static int[] par;
  static int[] size;
  static int mons;
  public static int findPar(int u) {
    if (par[u] == -1) {
      mons++;
      par[u] = u;
    }

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

  public static int removeMonsters(int[][] monsters) {
    mons = 0;
    par = new int[20001];
    Arrays.fill(par, -1);
    size = new int[20001];
    Arrays.fill(size, 1);
    for (int[] m : monsters) {
      int p1 = findPar(m[0]);
      int p2 = findPar(m[1] + 10000);

      if (p1 != p2) {
        mons--;
        merge(p1, p2);
      }
    }

    return monsters.length - mons;
  }

  public static void main(String[] args) {

    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[][] monsters = new int[n][2];
    for (int i = 0; i < n; i++) {
      monsters[i][0] = scn.nextInt();
      monsters[i][1] = scn.nextInt();
    }

    int ans = removeMonsters(monsters);
    System.out.println(ans);
  }
}
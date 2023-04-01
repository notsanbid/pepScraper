import java.util.ArrayList;
import java.util.Scanner;

class Main {
  static final int MAXN = 100001;

  static int spf[] = new int[MAXN];

  static void sieve() {
    spf[1] = 1;
    for (int i = 2; i < MAXN; i++) {
      spf[i] = i;
    }
    for (int i = 2; i * i < MAXN; i++) {
      if (spf[i] == i) {
        for (int j = i * i; j < MAXN; j += i) {
          if (spf[j] == j) {
            spf[j] = i;
          }
        }
      }
    }
  }

  static ArrayList<Integer> getFactorization(int x) {
    ArrayList<Integer> ret = new ArrayList<>();
    while (x != 1) {
      ret.add(spf[x]);
      x = x / spf[x];
    }
    return ret;
  }

  public static void main(String args[]) {
    Scanner scn = new Scanner(System.in);
    sieve();
    int t = scn.nextInt();
    while (t-- > 0) {
      int x = scn.nextInt();

      ArrayList<Integer> p = getFactorization(x);

      for (int i = 0; i < p.size(); i++) {
        System.out.print(p.get(i) + " ");
      }

      System.out.println();
    }
  }
}
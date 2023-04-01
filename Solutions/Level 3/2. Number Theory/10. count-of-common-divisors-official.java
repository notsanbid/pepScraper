import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
  static final int MAXN = 1000005;

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


  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    sieve();

    while (t-- > 0) {
      String[]st = br.readLine().split(" ");
      int a = Integer.parseInt(st[0]);
      int b = Integer.parseInt(st[1]);

      int temp = gcd(a, b);

      ArrayList<Integer> list = getFactorization(temp);
      if (temp == 1) {
        sb.append("1\n");
        continue;
      }

      int ans = 1;

      int count = 1;
      for (int i = 1; i < list.size(); i++) {
        if (list.get(i) == list.get(i - 1)) {
          count++;
        } else {
          ans = ans * (count + 1);
          count = 1;
        }
      }
      ans = ans * (count + 1);

      sb.append(ans + "\n");

    }

    System.out.println(sb);
  }

  public static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }

    return gcd(b, a % b);
  }
}
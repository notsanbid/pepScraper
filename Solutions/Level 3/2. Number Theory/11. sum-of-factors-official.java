import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
  static final int MAXN = 600005;

  static long spf[] = new long[MAXN];

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

  static ArrayList<Long> getFactorization(long x) {
    ArrayList<Long> ret = new ArrayList<>();
    while (x != 1) {
      ret.add(spf[(int) x]);
      x = x / spf[(int) x];
    }
    return ret;
  }

  public static long xpown(long x, long n) {
    long res = 1;
    while (n != 1) {
      if (n % 2 != 0) {
        res = res * x;
        n--;
      } else {
        x = x * x;
        n = n / 2;
      }
    }
    return res * x;
  }

  public static long check(long n) {
    long sum = 0;
    ArrayList<Long> list = new ArrayList<>();
    for (long i = 1; i < n; i++) {

      if (n % i == 0) {
        list.add(i);
        sum += i;
      }
    }
    System.out.println(list);
    return sum;
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sieve();
    StringBuilder sb = new StringBuilder();
    long t = Long.parseLong(br.readLine());

    while (t-- > 0) {
      long n = Long.parseLong(br.readLine());
      ArrayList<Long> list = getFactorization(n);
      if (n == 1) {
        sb.append("0\n");
        continue;
      }

      long ans = 1;

      long count = 1;
      for (int i = 1; i < list.size(); i++) {
        long val1 = list.get(i);
        long val2 = list.get(i - 1);
        if (val1 == val2) {
          count++;
        } else {
          ans = ans * ((xpown(val2, count + 1) - 1) / (val2 - 1));
          count = 1;
        }
      }

      long temp = list.get(list.size() - 1);
      ans = ans * ((xpown(temp, count + 1) - 1) / (temp - 1));
      sb.append((ans - n) + "\n");
    }

    System.out.print(sb);
  }
}
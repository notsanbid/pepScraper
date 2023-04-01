import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    int k = scn.nextInt();

    long[] arr = new long[n];
    for (int z = 0; z < n; z++) {
      arr[z] = scn.nextInt();
    }

    Arrays.sort(arr);
    long product = 1;
    int m = 1000000007;
    int m1 = 1000000006;
    long[] countarr = new long[arr.length];
    long[][] arrt = ncrcoll(arr.length, k, m1);
    long perm = arrt[arr.length - 1][k - 1];

    for (int i = 1; i <= arr.length / 2; i++) {
      long first = 0;
      long last = 0;
      if (arr.length - i >= k) {
        first = arrt[arr.length - 1 - i][k - 1];
      }
      if (i >= k - 1) {
        last = arrt[i][k - 1];
      }
      long total = (perm - first + m1) % m1;
      total = (total - last + m1) % m1;
      countarr[i] = total;
      countarr[arr.length - i - 1] = total;
    }

    for (int i = 1; i < countarr.length - 1; i++) {
      long pow = xpown(arr[i], countarr[i]);
      product = (product * pow) % m;
    }

    System.out.println(product);

  }

  static long[][] ncrcoll(int n, int k, int p) {
    long[][] arr = new long[n + 1][k + 1];
    for (int i = 1; i < arr.length; i++) {
      arr[i][0] = 1;
    }
    for (int i = 1; i < arr.length; i++) {
      for (int j = 1; j <= i && j < arr[0].length; j++) {
        if (i == 1 && j == 1) {
          arr[i][j] = 1;
        } else {
          arr[i][j] = (arr[i - 1][j] + arr[i - 1][j - 1]) % p;
        }
      }
    }
    return arr;
  }

  public static long xpown(long x, long n) {
    long res = 1;
    while (n > 0) {
      if (n % 2 != 0) {
        res = (res * x) % 1000000007;
        n--;
      } else {
        x = (x * x) % 1000000007;
        n = n / 2;
      }
    }
    return res;
  }

}
import java.util.Scanner;

public class Main {
  public static long findX(long range, int[] p) {
    long n = range / p.length;
    long rem = range % p.length;

    long x = n * p[p.length - 1] + p[(int)rem];
    return x;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int q = sc.nextInt();

      int[] prefixSum = new int[a * b];
      prefixSum[0] = 0;

      for (int x = 1; x < a * b; x++) {
        prefixSum[x] = prefixSum[x - 1];
        if ((x % a) % b != (x % b) % a) {
          prefixSum[x]++;
        }
      }

      while (q-- > 0) {
        long l = sc.nextLong();
        long r = sc.nextLong();

        long ans = findX(r, prefixSum) - findX(l - 1, prefixSum);
        System.out.print(ans + " ");
      }
      System.out.println();
    }
  }
}
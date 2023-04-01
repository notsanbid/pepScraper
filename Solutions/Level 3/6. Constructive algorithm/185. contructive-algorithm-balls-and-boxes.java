import java.util.*;

public class ballsAndBoxes {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    long mini = Integer.MAX_VALUE;

    long[] a = new long[n];
    for (int i = 0; i < n; i++) {
      a[i] = scn.nextInt();
      mini = Math.min(a[i], mini);
    }
    for (int i = 0; i < n; i++) a[i] -= mini;   // this nullifies loop overs
    int j = m - 1; // last one which got a ball
    long rem = 0;
    while (a[j] != 0) {
      a[j] -= 1;
      rem++;
      j = ((j - 1) % n + n) % n;
    }
    a[j] = n * mini + rem; // n * mini means number of rounds which it got
    for (int i = 0; i < n; i++) System.out.print(a[i] + " ");
    System.out.println();
  }
}
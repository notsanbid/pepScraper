import java.util.*;

public class Main {

  public static void strtb() {
    Scanner scn = new Scanner(System.in);
    int T = scn.nextInt();
    while (T-- > 0) {
      int n = scn.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) a[i] = scn.nextInt();
      int[] b = new int[n - 1];
      for (int i = 0; i < n - 1; i++) b[i] = scn.nextInt();
      Arrays.sort(a);
      Arrays.sort(b);
      // System.out.println((Math.min(b[0] - a[0]<=0?Integer.MAX_VALUE:b[0] - a[0],b[0] - a[1]<=0?Integer.MAX_VALUE:b[0] - a[1])));
      if (n == 2) System.out.println((Math.min(b[0] - a[0] <= 0 ? Integer.MAX_VALUE : b[0] - a[0], b[0] - a[1] <= 0 ? Integer.MAX_VALUE : b[0] - a[1])));
      else if (b[0] - a[0] == b[1] - a[1] && b[0] - a[1] == b[1] - a[2]) System.out.println(Math.min(b[0] - a[0] <= 0 ? Integer.MAX_VALUE : b[0] - a[0], b[0] - a[1] <= 0 ? Integer.MAX_VALUE : b[0] - a[1]));
      else if (b[0] - a[0] == b[1] - a[1]) System.out.println((b[0] - a[0]));
      else System.out.println(b[1] - a[2]);
    }
  }
  public static void main(String[] args) {
    strtb();
  }
}
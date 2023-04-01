import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int T = scn.nextInt();

    while (T-- > 0) {
      int n = scn.nextInt();
      int k = scn.nextInt();
      if (k + 1 < n) {
        System.out.println(k);
        continue;
      }

      if (k % (n - 1) > 0) { // we are lowerbound
        long curr = n * (k / (n - 1));
        // System.out.println(curr);
        System.out.println(curr + (k - ((k / (n - 1)) * (n - 1))));
      } else {             // we are upper bound
        // long curr = n*(k/(n-1));    // subtract from curr
        System.out.println(n * (k / (n - 1)) - 1);
      }

    }

  }
}
import java.util.*;
public class two {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    // we fix one position and find all others according to that

    int T = scn.nextInt();
    while (T-- > 0) {
      int n = scn.nextInt();
      int k = scn.nextInt();
      int ans = -1;
      int x = -1;
      if (k > n || n % 2 > 0 && k % 2 == 0) {
        System.out.println("NO");
        continue;
      } else if (k == 1) {
        System.out.println("YES");
        System.out.println(n);
        continue;
      }
      for (int i = 1; i < n; i++) {
        if ((n - i) % (k - 1) == 0 && i % 2 == (n - i) / (k - 1) % 2) {
          x = i;
          ans = (n - i) / (k - 1);
          break;
        }
      }
      if (ans != -1) {
        System.out.println("YES");
        for (int i = 0; i < k - 1; i++) System.out.print((n - x) / (k - 1) + " ");
        System.out.println(x);
      } else System.out.println("NO");
    }



  }
}
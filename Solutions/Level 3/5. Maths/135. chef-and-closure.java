import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int T = scn.nextInt();
    while (T-- > 0) {
      int n = scn.nextInt();
      int bc = 0, m1c = 0, oc = 0, zc = 0;
      for (int i = 0; i < n; i++) {
        int x = scn.nextInt();
        if (x == -1) m1c++;
        else if (x == 1) oc++;
        else if (x == 0) zc++;
        else bc++;
      }

      if (bc >= 2) System.out.println(0);
      else if (bc == 1 && m1c > 0) System.out.println(0);
      else if (bc == 1 && m1c == 0) System.out.println(1);
      else if (m1c >= 2 && oc > 0) System.out.println(1);
      else if (m1c >= 2 && oc == 0) System.out.println(0);
      else System.out.println(1);
    }
  }
}
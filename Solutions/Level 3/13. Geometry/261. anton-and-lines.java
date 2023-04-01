import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    int x1 = scn.nextInt();
    int x2 = scn.nextInt();

    long yy[][] = new long[n][2];

    for (int i = 0; i < n; i++) {
      long k = scn.nextInt();
      long b = scn.nextInt();
      yy[i][0] = k * x1 + b;
      yy[i][1] = k * x2 + b;
    }

    Arrays.sort(yy, (a, b)->{
      return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
    });

    boolean ok = false;
    for (int flag = 0, i = 0; i < n; i++) {

      if (yy[flag][0] < yy[i][0] && yy[flag][1] > yy[i][1]) {
        ok = true;
        break;
      }
      if (yy[flag][1] < yy[i][1])flag = i;
    }

    System.out.println(ok ? "YES" : "NO");
  }
}
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);

    int t = scn.nextInt();
    PrintWriter out = new PrintWriter(System.out);
    while (t-- > 0) {
      long n = scn.nextLong();

      long ans = 0;
      boolean count = true;

      while (n > 0) {
        long take = 0;
        if (n % 2 == 0) {
          if ((n / 2) % 2 == 0 && n != 4) {
            take = 1;
          } else {
            take = n / 2;
          }
        } else {
          take = 1;
        }
        if (count)ans += take;
        count = !count;
        n -= take;
      }
      out.println(ans);
    }

    out.close();
  }
}
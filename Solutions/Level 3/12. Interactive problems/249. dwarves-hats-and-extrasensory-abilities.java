import java.io.*;
import java.util.*;

public class Main {

  static Scanner scn = new Scanner(System.in);

  static int y = 3;

  static boolean query(int x) { // true black false white
    System.out.println(x + " " + y);
    System.out.flush();
    return scn.next().charAt(0) == 'b';
  }

  public static void main(String[] args) throws IOException {

    int n = scn.nextInt();

    boolean first = query(0);

    int l = 1;
    int r = 1000000000;

    for (int i = 1; i < n; i++) {
      int mid = (l + r) / 2;
      boolean col = query(mid);

      if (col == first) {
        l = mid;
      } else {
        r = mid;
      }
    }

    System.out.println(l + " " + (y - 1) + " " + r + " " + (y + 1));
    System.out.flush();
  }
}
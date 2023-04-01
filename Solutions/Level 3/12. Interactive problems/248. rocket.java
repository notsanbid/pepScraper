import java.io.*;
import java.util.*;

public class Main {
  static Scanner scn = new Scanner(System.in);

  static int query(int y) {
    System.out.println(y);
    System.out.flush();
    return scn.nextInt();
  }

  public static void main(String[] args) throws IOException {

    int m = scn.nextInt();
    int n = scn.nextInt();

    int p[] = new int[n];// 1 true      -1 false

    for (int i = 0; i < n; i++) {
      int ans = query(1);
      if (ans == 0) {
        return;
      }
      p[i] = ans;
    }

    int low = 2;
    int high = m;
    int i = 0;

    while (low < high) {
      int mid = low + (high - low) / 2;

      int ans = query(mid);// ans can be false

      ans = ans * p[i++];
      if (i == n)i = 0;

      if (ans == 0) {
        return;
      } else if (ans == 1) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    System.out.println(low);
    System.out.flush();
  }
}
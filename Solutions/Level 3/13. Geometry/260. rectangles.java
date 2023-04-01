import java.io.*;
import java.util.*;

public class Main {

  static class Rect {
    int x1;
    int x2;
    int y1, y2;
    Rect(int x11, int y11, int x22, int y22) {
      x1 = x11;
      y1 = y11;
      x2 = x22;
      y2 = y22;
    }
  }

  static Rect merge(Rect a, Rect b) {
    return new Rect(Math.max(a.x1, b.x1), Math.max(a.y1, b.y1), Math.min(a.x2, b.x2), Math.min(a.y2, b.y2));
  }

  static boolean check(Rect ans) {
    if (ans.x1 > ans.x2 || ans.y1 > ans.y2)return false;
    return true;
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    Rect recs[] = new Rect[n];

    for (int i = 0; i < n; i++) {
      recs[i] = new Rect(scn.nextInt(), scn.nextInt(), scn.nextInt(), scn.nextInt());
    }

    Rect preC[] = new Rect[n];

    preC[0] = recs[0];
    for (int i = 1; i < n; i++) {
      preC[i] = merge(preC[i - 1], recs[i]);
    }

    Rect sufC[] = new Rect[n];
    sufC[n - 1] = recs[n - 1];

    for (int i = n - 2; i >= 0; i--) {
      sufC[i] = merge(sufC[i + 1], recs[i]);
    }

    for (int i = 0; i < n; i++) {
      Rect ans;
      if (i == 0)ans = sufC[i + 1];
      else if (i == n - 1)ans = preC[i - 1];
      else ans = merge(preC[i - 1], sufC[i + 1]);

      if (check(ans)) {
        System.out.println(ans.x1 + " " + ans.y1);
        break;
      }
    }
  }
}
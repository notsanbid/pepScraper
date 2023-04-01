import java.util.*;

public class three {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int T = scn.nextInt();
    // arithmetic progression
    // find d and start adding from last element
    // d will always be divisor of y-x
    while (T-- > 0) {
      int n = scn.nextInt();
      int x = scn.nextInt();
      int y = scn.nextInt();

      int diff = y - x;

      for (int cd = 1; cd <= diff; cd++) {
        if (diff % cd > 0) continue;
        boolean xFound = false;

        ArrayList<Integer> ar = new ArrayList<Integer>();
        int num = y;
        while (num > 0 && ar.size() < n) {
          if (num == x) xFound = true;
          ar.add(num);
          num -= cd;
        }
        if (!xFound) continue;
        num = y + cd;
        while (ar.size() < n) {
          ar.add(num);
          num += cd;
        }
        Collections.sort(ar);
        for (int p : ar) System.out.print(p + " ");
        System.out.println();
        break;
      }

    }
  }
}
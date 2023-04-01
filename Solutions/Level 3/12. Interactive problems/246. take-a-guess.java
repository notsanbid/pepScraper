import java.io.*;
import java.util.*;

public class Main {
  static Scanner scn = new Scanner(System.in);

  static int query(String op, int i, int j) {
    System.out.println(op + " " + i + " " + j);
    System.out.flush();
    return scn.nextInt();
  }

  public static void main(String[] args) throws IOException {

    int n = scn.nextInt();
    int k = scn.nextInt();

    int ar[] = new int[n + 1];

    int ab = query("or", 1, 2) + query("and", 1, 2);
    int bc = query("or", 3, 2) + query("and", 3, 2);
    int ac = query("or", 1, 3) + query("and", 1, 3);

    int b = (ab + bc - ac) / 2;
    ar[2] = b;
    ar[1] = ab - b;
    ar[3] = bc - b;

    for (int i = 4; i <= n; i++) {
      ar[i] = query("or", i, 2) + query("and", i, 2) - b;
    }

    Arrays.sort(ar);
    System.out.println("finish " + ar[k]);
    System.out.flush();
  }
}
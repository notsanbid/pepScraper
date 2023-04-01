import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);

    long R = scn.nextInt();
    long x1 = scn.nextInt();
    long y1 = scn.nextInt();
    long x2 = scn.nextInt();
    long y2 = scn.nextInt();


    if (R * R <= (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)) {
      System.out.println(x1 + " " + y1 + " " + R);
    } else if (x1 == x2 && y1 == y2) {
      System.out.println((x1 + R / 2.0) + " " + y1 + " " + (R / 2.00));
    } else {

      double dis = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

      double a = (dis + R) * (x1 - x2) / (2 * dis) + x2;
      double b = (dis + R) * (y1 - y2) / (2 * dis) + y2;

      System.out.println(a + " " + b + " " + ((R + dis) / 2.00));
    }

  }
}
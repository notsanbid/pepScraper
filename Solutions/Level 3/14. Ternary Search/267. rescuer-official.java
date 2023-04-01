import java.util.Scanner;

public class Main {
  static double x1, y1;
  static double x2, y2;
  static double v1, v2;

  public static double func(double x) {
    double d1 = Math.sqrt((x1 - x) * (x1 - x) + y1 * y1);
    double t1 = d1 / v1;

    double d2 = Math.sqrt((x2 - x) * (x2 - x) + y2 * y2);
    double t2 = d2 / v2;

    return t1 + t2;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int testCase = sc.nextInt();
    for (int i = 0; i < testCase; i++) {
      x1 = sc.nextDouble();
      y1 = sc.nextDouble();
      x2 = sc.nextDouble();
      y2 = sc.nextDouble();

      v1 = sc.nextDouble();
      v2 = sc.nextDouble();

      double l = x1;
      double r = x2;

      if (x1 > x2) {
        l = x2;
        r = x1;
      }

      while (r - l > 0.000001) {
        double m1 = l + (r - l) / 3.0;
        double m2 = r - (r - l) / 3.0;

        double tm1 = func(m1);
        double tm2 = func(m2);

        if (tm1 > tm2) {
          l = m1;
        } else if (tm1 < tm2) {
          r = m2;
        } else {
          l = m1;
          r = m2;
        }
      }
      double time = func(l);
      System.out.printf("%.5f", time);
      System.out.println();
    }
  }
}
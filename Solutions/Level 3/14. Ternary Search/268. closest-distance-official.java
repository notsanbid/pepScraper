import java.util.Scanner;

public class Main {
  public static class Point {
    double x;
    double y;
    public Point() {

    }
    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }

  public static double distance(Point A, Point B) {
    return Math.sqrt((A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y));
  }

  public static double solve(Point A, Point B, Point C, Point D) {
    while (distance(A, B) > 0.00000000001) {

      Point am1, am2, cm1, cm2;

      am1 = new Point(A.x + (B.x - A.x) / 3, A.y + (B.y - A.y) / 3);
      am2 = new Point(B.x - (B.x - A.x) / 3, B.y - (B.y - A.y) / 3);

      cm1 = new Point(C.x + (D.x - C.x) / 3, C.y + (D.y - C.y) / 3);
      cm2 = new Point(D.x - (D.x - C.x) / 3, D.y - (D.y - C.y) / 3);

      double dm1 = distance(am1, cm1);
      double dm2 = distance(am2, cm2);

      if (dm1 > dm2) {
        A = am1;
        C = cm1;
      } else if (dm1 < dm2) {
        B = am2;
        D = cm2;
      } else {
        A = am1;
        B = am2;
        C = cm1;
        D = cm2;
      }
    }
    return distance(A, C);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int testCase = sc.nextInt();

    for (int i = 1; i <= testCase; i++) {
      Point A = new Point();
      Point B = new Point();
      Point C = new Point();
      Point D = new Point();

      A.x = sc.nextDouble();
      A.y = sc.nextDouble();

      B.x = sc.nextDouble();
      B.y = sc.nextDouble();

      C.x = sc.nextDouble();
      C.y = sc.nextDouble();

      D.x = sc.nextDouble();
      D.y = sc.nextDouble();

      double res = solve(A, B, C, D);

      if (res - Math.floor(res) > 0.0000001) {
        System.out.printf("Case %d: %.10f", i, res);
        System.out.println();
      } else {
        System.out.println("Case " + i + ": " + (int)(res));
      }
    }
  }
}
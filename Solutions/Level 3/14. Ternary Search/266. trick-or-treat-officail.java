import java.io.*;

public class Main {
  public static class Point {
    double x;
    double y;

    Point(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }

  public static double func(double x, Point[] points) {
    double max_dist = Double.MIN_VALUE;
    for (int i = 0; i < points.length; i++) {
      Point p = points[i];
      double distance = Math.sqrt((p.x - x) * (p.x - x) + p.y * p.y);
      max_dist = Math.max(max_dist, distance);
    }
    return max_dist;
  }

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      int n = Integer.parseInt(br.readLine());
      if (n == 0) {
        break;
      }

      Point[] points = new Point[n];

      for (int i = 0; i < n; i++) {
        String[] input = br.readLine().split(" ");
        double x = Double.parseDouble(input[0]);
        double y = Double.parseDouble(input[1]);

        points[i] = new Point(x, y);
      }

      double l = -200000;
      double r = 200000;

      while (r - l > 0.00000001) {
        double m1 = l + (r - l) / 3;
        double m2 = r - (r - l) / 3;


        double fm1 = func(m1, points);
        double fm2 = func(m2, points);

        if (fm1 > fm2) {
          l = m1;
        } else if (fm1 < fm2) {
          r = m2;
        } else {
          l = m1;
          r = m2;
        }
      }

      double ans = func(l, points);
      System.out.printf("%.9f %.9f\n", l, ans);
      br.readLine();
    }
  }
}
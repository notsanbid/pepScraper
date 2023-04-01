import java.util.*;

public class convexHull {


  static class Point {
    int x;
    int y;
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  public static int distance(Point a, Point b, Point c) {
    int y1 = a.y - b.y;
    int y2 = a.y - c.y;
    int x1 = a.x - b.x;
    int x2 = a.x - c.x;
    return Integer.compare(y1 * y1 + x1 * x1, y2 * y2 + x2 * x2);
  }

  // > 0 = c is on left
  public static int crossProduct(Point a, Point b, Point c) {
    int y1 = a.y - b.y;
    int y2 = a.y - c.y;
    int x1 = a.x - b.x;
    int x2 = a.x - c.x;
    return y2 * x1 - y1 * x2;
  }

  public static ArrayList<Point> hull(Point[] points) {
    Point start = points[0];
    for (int i = 1; i < points.length; i++) {
      if (points[i].x < start.x) {
        start = points[i];
      }
    }
    Point curr = start;

    Set<Point> result = new HashSet<>();
    result.add(start);
    List<Point> collinearPoints = new ArrayList<>();
    while (true) {
      Point next = points[0];
      for (int i = 1; i < points.length; i++) {
        if (points[i] == curr) {
          continue;
        }
        int val = crossProduct(curr, next, points[i]);
        // good
        if (val > 0) {
          next = points[i];
          collinearPoints = new ArrayList<>();
        } else if (val == 0) { // collinear

          if (distance(curr, next, points[i]) < 0) {
            collinearPoints.add(next);
            next = points[i];
          } else {
            collinearPoints.add(points[i]);
          }
        }
      }


      for (Point p : collinearPoints) {
        result.add(p);
      }
      if (next == start) {
        break;
      }
      result.add(next);
      curr = next;
    }
    return new ArrayList<>(result);
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    Point[] ar = new Point[n];
    for (int i = 0; i < n; i++) {
      int x = scn.nextInt();
      int y = scn.nextInt();
      Point p = new Point(x, y);
      ar[i] = p;
    }
    ArrayList<Point> ch = hull(ar);
    System.out.println(ch.size());
    // for(Point cp: ch) System.out.println(cp.x+" "+cp.y);
  }
}
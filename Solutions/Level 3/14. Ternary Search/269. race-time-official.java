import java.util.Scanner;

public class Main {
  public static double func(double t, int[] speed, int[] start) {
    double min = Double.MAX_VALUE;
    double max = Double.MIN_VALUE;

    for (int i = 0; i < speed.length; i++) {
      double distance = speed[i] * t + start[i];
      min = Math.min(min, distance);
      max = Math.max(max, distance);
    }

    return max - min;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();

    int[] speed = new int[n];
    int[] start = new int[n];

    for (int i = 0; i < n; i++) {
      speed[i] = sc.nextInt();
      start[i] = sc.nextInt();
    }

    double l = 0;
    double r = k;

    while (r - l > 0.00000001) {
      double m1 = l + (r - l) / 3;
      double m2 = r - (r - l) / 3;

      double fm1 = func(m1, speed, start);
      double fm2 = func(m2, speed, start);

      if (fm1 > fm2) {
        l = m1;
      } else if (fm1 < fm2) {
        r = m2;
      } else {
        l = m1;
        r = m2;
      }
    }

    double ans = func(l, speed, start);
    System.out.printf("%.6f", ans);
  }
}
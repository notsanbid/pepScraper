import java.util.*;

public class Main {
  static double func(double x, int[] arr) {
    double max1 = 0, max2 = 0;
    double sum = 0;

    for (int i = 0; i < arr.length; i++) {
      sum += arr[i] - x;
      if (sum < 0) {
        sum = 0;
      }
      max1 = Math.max(max1, sum);
    }

    sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += x - arr[i];
      if (sum < 0) {
        sum = 0;
      }
      max2 = Math.max(max2, sum);
    }

    return Math.max(max1, max2);
  }

  public static void main(String[] args) throws Exception{
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    double l = -10000;
    double r = 10000;

    while (r - l > 0.000000000001) {
      double mid1 = l + (r - l) / 3;
      double mid2 = r - (r - l) / 3;
      double fm1 = func(mid1, arr);
      double fm2 = func(mid2, arr);

      if (fm1 > fm2) {
        l = mid1;
      } else if (fm1 < fm2) {
        r = mid2;
      } else {
        l = mid1;
        r = mid2;
      }
    }

    double ans = func(l, arr);
    System.out.printf("%.6f", ans);
  }
}